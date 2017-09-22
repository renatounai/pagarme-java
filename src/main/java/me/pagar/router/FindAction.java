package me.pagar.router;

import me.pagar.ApiClient;
import me.pagar.endpoint.ApiResources;
import me.pagar.endpoint.EndpointConsumer;
import me.pagar.exception.ApiErrors;
import me.pagar.generickeyvalueobject.FieldsOnHash;
import me.pagar.objecttraits.CanBecomeKeyValueVariable;

import java.io.IOException;

/**
 * Created by henriquekano on 9/22/17.
 */
class FindAction<T extends FieldsOnHash> {

    T execute(ApiClient client, ApiResources resource, CanBecomeKeyValueVariable... parameters) throws IOException, ApiErrors {
        return new EndpointConsumer(client)
            .find()
            .of(resource)
            .withNoParameters();
    }
}
