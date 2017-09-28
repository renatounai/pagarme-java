package router;

import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.router.TransactionRouter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import unit.FieldsOnHashImpl;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TransactionTest {

    ApiClient client;
    APiConfigurations configs;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Before
    public void beforeEach() {
        APiConfigurations configs = new APiConfigurations("API KEY", "ENCRYPTION KEY");
        configs.baseUrl = "http://localhost:" + wireMockRule.port();
        this.configs = configs;

        ApiClient client = new ApiClient(configs);
        this.client = client;

        wireMockRule.stubFor(
            get(urlPathEqualTo("/transactions/tx_1"))
                .willReturn(aResponse()
                    .withBody("{}")
                    .withStatus(200)
                )
        );
        wireMockRule.stubFor(
            get(urlPathEqualTo("/transactions"))
                .willReturn(aResponse()
                    .withBody("[]")
                    .withStatus(200)
                )
        );
        wireMockRule.stubFor(
            get(urlPathMatching("/transactions?(.+=.+)+"))
                .willReturn(aResponse()
                    .withBody("[]")
                    .withStatus(200)
                )
        );
        wireMockRule.stubFor(
            post(urlPathEqualTo("/transactions"))
                .willReturn(aResponse()
                    .withBody("{}")
                    .withStatus(200)
                )
        );
        wireMockRule.stubFor(
            post(urlPathEqualTo("/transactions/tx_id/refund"))
                .willReturn(aResponse()
                    .withBody("{}")
                    .withStatus(200)
                )
        );
    }

    @Test
    public void testTransactionCreate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new TransactionRouter(client)
            .create(parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/transactions"))
            .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
            .withRequestBody(equalToJson("{\"key\": \"value\"}"))
        );
    }

    @Test
    public void testTransactionFindById() throws IOException, ApiErrors {
        new TransactionRouter(client)
            .findById("tx_1");

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/transactions/tx_1"))
            .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testTransactionFind() throws IOException, ApiErrors {
        new TransactionRouter(client)
            .find();

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/transactions"))
            .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testTransactionFindWithParameters() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new TransactionRouter(client)
            .find(parameters);

        wireMockRule.verify(1, getRequestedFor(urlMatching("/transactions.*"))
            .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
            .withQueryParam("key", equalTo("value"))
        );
    }

    @Test
    public void testTransactionRefund() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"amount\": \"1000\"}");
        new TransactionRouter(client)
            .refund("tx_id", parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/transactions/tx_id/refund"))
            .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
            .withRequestBody(matchingJsonPath("amount", equalTo("1000")))
        );
    }
}
