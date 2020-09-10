package me.pagar.model;

import com.google.common.base.Strings;

public abstract class PagarMe {

    public static final String ENDPOINT = "https://api.pagar.me";

    public static final String API_VERSION = "1";

    public static final String VERSION = "1.5.8";

    public static final String HMAC_MD5_ALGORITHM = "HmacMD5";

    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

    public static final String SHA1_ALGORITHM = "sha1";

    public static final String SHA256_ALGORITHM = "sha256";

    public static final String ASCII = "ASCII";

    public static String fullApiUrl(final String path) {
        return ENDPOINT.concat("/")
                .concat(API_VERSION)
                .concat(path);
    }

    public boolean validateRequestSignature(final String payload, final String signature) {

        if (Strings.isNullOrEmpty(payload) || Strings.isNullOrEmpty(signature)) {
            return false;
        }

        return true;

    }
}
