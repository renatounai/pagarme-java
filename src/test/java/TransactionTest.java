import me.pagar.route.APiConfigurations;
import me.pagar.route.ApiClient;
import me.pagar.route.ApiErrors;
import me.pagar.route.requestobject.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class TransactionTest {

    @Test
    public void testTransactionCreate() throws ApiErrors, IOException {

        APiConfigurations configs = new APiConfigurations();
        configs.apiKey = "ak_test_XP6fGg1xM9qZ25ZV2WjnchNrXdZ7Oe";
        ApiClient client = new ApiClient(configs);

        Address address = new Address()
                .city("São Paulo")
                .country("br")
                .neighborhood("bairro")
                .state("São Paulo")
                .street("rua")
                .streetNumber("122")
                .zipcode("06350270");

        Transaction txRequest = new Transaction()
                .amount(100)
                .billing(new Billing()
                        .setAddress(address)
                        .setName("Billing")
                )
                .cardCvv("122")
                .cardExpirationDate("1221")
                .cardHolderName("qwe")
                .cardNumber("4242424242424242")
                .customer(new Customer()
                        .setBirthday("1990-12-12")
                        .setCountry("br")
                        .setDocuments(Arrays.asList(
                                new Document()
                                .setNumber("35965816804")
                                .setType("cpf")
                        ))
                        .setEmail("qwe@qwe.com")
                        .setExternalId("1")
                        .setName("teste")
                        .setPhoneNumbers(Arrays.asList(
                                "+551187654321"
                        ))
                        .setType("individual")
                )
                .items(Arrays.asList(
                        new Item()
                        .setId("ewr1")
                        .setQuantity(1)
                        .setTangible(true)
                        .setTitle("titulo")
                        .setUnitPrice(1000)
                ))
                .shipping(new Shipping()
                        .setAddress(address)
                        .setExpedited(true)
                        .setFee(123)
                        .setName("Name")
                );

        try {
            me.pagar.route.responseobject.Transaction txResponse = client.transactions().create(txRequest);
            System.out.print(txResponse.toJson());
        } catch (ApiErrors e) {
            System.out.print(e.getBody());
        }
    }
}
