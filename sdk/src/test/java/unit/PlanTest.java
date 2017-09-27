package unit;

import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.router.PlanRouter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;

public class PlanTest {

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
                get(urlPathEqualTo("/plans/tx_1"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                get(urlPathEqualTo("/plans"))
                        .willReturn(aResponse()
                                .withBody("[]")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                get(urlPathMatching("/plans?(.+=.+)+"))
                        .willReturn(aResponse()
                                .withBody("[]")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                post(urlPathEqualTo("/plans"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                put(urlPathEqualTo("/plans/tx_id"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
    }

    @Test
    public void testPlanCreate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new PlanRouter(client)
                .create(parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/plans"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(equalToJson("{\"key\": \"value\"}"))
        );
    }

    @Test
    public void testPlanFindById() throws IOException, ApiErrors {
        new PlanRouter(client)
                .findById("tx_1");

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/plans/tx_1"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testPlanFind() throws IOException, ApiErrors {
        new PlanRouter(client)
                .find();

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/plans"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testPlanFindWithParameters() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new PlanRouter(client)
                .find(parameters);

        wireMockRule.verify(1, getRequestedFor(urlMatching("/plans.*"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withQueryParam("key", equalTo("value"))
        );
    }

    @Test
    public void testPlanUpdate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"amount\": \"1000\"}");
        new PlanRouter(client)
                .update("tx_id", parameters);

        wireMockRule.verify(1, putRequestedFor(urlEqualTo("/plans/tx_id"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(matchingJsonPath("amount", equalTo("1000")))
        );
    }
}
