package me.pagar.model;

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import me.pagar.util.JSONUtils;
import me.pagar.security.TLSSocketFactory;
import me.pagar.security.TLSSocketConnectionFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.UriBuilder;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {
    public final static String AMOUNT = "amount";

    private HttpsURLConnection httpClient;

    private String method;

    private String url;

    private Map<String, Object> parameters;

    private InputStream is;

    private static int getJavaVersion() {
        String version = System.getProperty("java.version");
        if(version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if(dot != -1) {
                version = version.substring(0, dot);
            }
        }

        return Integer.parseInt(version);
    }

    private void setupSecureConnection(final HttpsURLConnection httpClient) throws IOException,
            NoSuchAlgorithmException, KeyManagementException, PagarMeException {

        int sysMajorVersion = RestClient.getJavaVersion();

        if (sysMajorVersion < 6 || sysMajorVersion > 8) {
            throw new PagarMeException("Your installed Java version should be >= 6 and <= 8");
        }

        if (sysMajorVersion == 6) {
            httpClient.setSSLSocketFactory(new TLSSocketConnectionFactory());
        } else {
            httpClient.setSSLSocketFactory(new TLSSocketFactory());
        }
    }

    public RestClient(final String method, final String url) throws PagarMeException {
        this(method, url, null, null);
    }

    public RestClient(final String method, final String url, Map<String, Object> parameters) throws PagarMeException {
        this(method, url, parameters, null);
    }

    public RestClient(final String method, final String url, Map<String, Object> parameters,
            Map<String, String> headers) throws PagarMeException {
        System.setProperty("https.protocols", "TLSv1.2");

        this.method = method;
        this.url = url;
        this.parameters = parameters;

        if (null == headers) {
            headers = new HashMap<String, String>();
        }

        if (null == this.parameters) {
            this.parameters = new HashMap<String, Object>();
        }

        String sdkVersion = String.format("PagarMe-Java/%s", PagarMe.VERSION);

        headers.put("User-Agent", sdkVersion);
        headers.put("X-PagarMe-User-Agent", sdkVersion);
        headers.put("Accept", "application/json");

        if (Strings.isNullOrEmpty(url)) {
            throw new PagarMeException("You must set the URL to make a request.");
        }

        if (!Strings.isNullOrEmpty(method)) {

            try {
                final UriBuilder builder = UriBuilder.fromPath(this.url);

                if (this.parameters.containsKey(AMOUNT) && this.parameters.size() == 1) {
                    builder.queryParam(AMOUNT, this.parameters.remove(AMOUNT));
                }

                if (method.equalsIgnoreCase(HttpMethod.GET)) {

                    for (Map.Entry<String, Object> entry : this.parameters.entrySet()) {
                        builder.queryParam(entry.getKey(), entry.getValue());
                    }

                }

                httpClient = (HttpsURLConnection) builder
                        .build(this)
                        .toURL()
                        .openConnection();
                httpClient.setRequestMethod(this.method.toUpperCase());
                httpClient.setDoInput(true);
                httpClient.setDoOutput(false);

                setupSecureConnection(httpClient);

                if (headers.size() > 0) {

                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        httpClient.addRequestProperty(entry.getKey(), entry.getValue());
                    }

                }

            } catch (Exception e) {
                throw PagarMeException.buildWithError(e);
            }

        }

    }

    public PagarMeResponse execute() throws PagarMeException {
        final StringBuilder builder = new StringBuilder();
        int responseCode = -1;

        try {

            if (method.equalsIgnoreCase(HttpMethod.POST)
                    || method.equalsIgnoreCase(HttpMethod.PUT)
                    || method.equalsIgnoreCase(HttpMethod.DELETE)) {
                httpClient.setDoOutput(true);

                if (parameters.size() > 0) {
                    final byte[] payload = JSONUtils.getInterpreter().toJson(parameters).getBytes();
                    httpClient.addRequestProperty("Content-Type", "application/json");
                    httpClient.addRequestProperty("Content-Length", String.valueOf(payload.length));

                    final OutputStream os = httpClient.getOutputStream();
                    os.write(payload);
                    os.flush();
                }

            }

            try {
                is = httpClient.getInputStream();
                responseCode = httpClient.getResponseCode();
            } catch (IOException e) {
                is = httpClient.getErrorStream();
                responseCode = httpClient.getResponseCode();
            }

            final BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append('\r');
            }

            reader.close();
            httpClient.disconnect();

            return new PagarMeResponse(responseCode,
                    JSONUtils.getInterpreter().fromJson(builder.toString(), JsonElement.class));
        } catch (Exception e) {

            if (e instanceof JsonSyntaxException) {
                throw new PagarMeException(responseCode, url, method, builder.toString());
            }

            throw PagarMeException.buildWithError(e);
        }

    }
}
