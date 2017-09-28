package unit;

import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.router.SubscriptionRouter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;

public class SubscriptionTest {

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
                get(urlPathEqualTo("/subscriptions/tx_1"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                get(urlPathEqualTo("/subscriptions"))
                        .willReturn(aResponse()
                                .withBody("[]")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                get(urlPathMatching("/subscriptions?(.+=.+)+"))
                        .willReturn(aResponse()
                                .withBody("[]")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                post(urlPathEqualTo("/subscriptions"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                post(urlPathEqualTo("/subscriptions/tx_id/cancel"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                post(urlPathEqualTo("/subscriptions/tx_id/settle_charge"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
    }

    @Test
    public void testSubscriptionCreate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new SubscriptionRouter(client)
                .create(parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/subscriptions"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(equalToJson("{\"key\": \"value\"}"))
        );
    }

    @Test
    public void testSubscriptionFindById() throws IOException, ApiErrors {
        new SubscriptionRouter(client)
                .findById("tx_1");

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/subscriptions/tx_1"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testSubscriptionFind() throws IOException, ApiErrors {
        new SubscriptionRouter(client)
                .find();

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/subscriptions"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testSubscriptionFindWithParameters() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new SubscriptionRouter(client)
                .find(parameters);

        wireMockRule.verify(1, getRequestedFor(urlMatching("/subscriptions.*"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withQueryParam("key", equalTo("value"))
        );
    }

    @Test
    public void testSubscriptionCancel() throws IOException, ApiErrors {
        new SubscriptionRouter(client)
                .cancel("tx_id");

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/subscriptions/tx_id/cancel"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testSubscriptionSettleCharges() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"charges\": \"2\"}");
        new SubscriptionRouter(client)
                .settleCharges("tx_id", parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/subscriptions/tx_id/settle_charge"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(matchingJsonPath("charges", equalTo("2")))
        );
    }
}
