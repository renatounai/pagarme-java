package router;

import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.router.CardRouter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import unit.FieldsOnHashImpl;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

/**
 * Created by henriquekano on 9/29/17.
 */
public class CardTests {

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
    }

    @Test
    public void testCardCreate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new CardRouter(client)
                .create(parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/cards"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(equalToJson("{\"key\": \"value\"}"))
        );
    }

    @Test
    public void testBankAccountFindById() throws IOException, ApiErrors {
        new CardRouter(client)
                .findById("tx_id");

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/cards/tx_id"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testBankAccountFind() throws IOException, ApiErrors {
        new CardRouter(client)
                .find();

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/cards"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testBankAccountFindWithParameters() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new CardRouter(client)
                .find(parameters);

        wireMockRule.verify(1, getRequestedFor(urlMatching("/cards.*"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withQueryParam("key", equalTo("value"))
        );
    }
}
