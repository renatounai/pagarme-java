package router;

import com.github.tomakehurst.wiremock.client.BasicCredentials;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import me.pagar.APiConfigurations;
import me.pagar.ApiClient;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.router.BankAccountRouter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import unit.FieldsOnHashImpl;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

public class BankAccountTest {

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
    public void testBankAccountsCreate() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new BankAccountRouter(client)
                .create(parameters);

        wireMockRule.verify(1, postRequestedFor(urlEqualTo("/bank_accounts"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withRequestBody(equalToJson("{\"key\": \"value\"}"))
        );
    }

    @Test
    public void testBankAccountFindById() throws IOException, ApiErrors {
        new BankAccountRouter(client)
                .findById("tx_1");

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/bank_accounts/tx_1"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testBankAccountFind() throws IOException, ApiErrors {
        new BankAccountRouter(client)
                .find();

        wireMockRule.verify(1, getRequestedFor(urlEqualTo("/bank_accounts"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
        );
    }

    @Test
    public void testBankAccountFindWithParameters() throws IOException, ApiErrors {
        FieldsOnHash parameters = new FieldsOnHashImpl("{\"key\": \"value\"}");
        new BankAccountRouter(client)
                .find(parameters);

        wireMockRule.verify(1, getRequestedFor(urlMatching("/bank_accounts.*"))
                .withBasicAuth(new BasicCredentials(configs.apiKey, "x"))
                .withQueryParam("key", equalTo("value"))
        );
    }
}
