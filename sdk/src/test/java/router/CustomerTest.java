package router;

import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.router.CustomerRouter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import unit.FieldsOnHashImpl;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

public class CustomerTest {

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
                get(urlPathEqualTo("/customers/tx_1"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                get(urlPathEqualTo("/customers"))
                        .willReturn(aResponse()
                                .withBody("[]")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                get(urlPathMatching("/customers?(.+=.+)+"))
                        .willReturn(aResponse()
                                .withBody("[]")
                                .withStatus(200)
                        )
        );
        wireMockRule.stubFor(
                post(urlPathMatching("/customers"))
                        .willReturn(aResponse()
                                .withBody("{}")
                                .withStatus(200)
                        )
        );
    }

    @Test
    public void testCustomerCreate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new CustomerRouter(client)
                .create(parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/customers"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(equalToJson("{\"key\": \"value\"}"))
        );
    }

    @Test
    public void testCustomerFindById() throws IOException, ApiErrors {
        new CustomerRouter(client)
                .findById("tx_1");

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/customers/tx_1"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testCustomerFind() throws IOException, ApiErrors {
        new CustomerRouter(client)
                .find();

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/customers"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testCustomerFindWithParameters() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new CustomerRouter(client)
                .find(parameters);

        wireMockRule.verify(1, getRequestedFor(urlMatching("/customers.*"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withQueryParam("key", equalTo("value"))
        );
    }
}
