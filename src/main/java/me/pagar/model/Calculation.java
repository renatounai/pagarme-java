package me.pagar.model;

import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.HttpMethod;
import me.pagar.util.JSONUtils;

/**
 *
 * @author jonatasmaxi
 */
public class Calculation {

    public Calculation() {

    }

    public List<Installment> calculateInstallments(int amount,
            int freeInstallments, int interestRate, int maxInstallments) throws PagarMeException {
        /*  validateId();
        final PagarMeRequest request = new PagarMeRequest(HttpMethod.POST,
                String.format("/%s/%s/settle_charge", getClassName(), getId()));
        if (chargesToSettle != null) {
            Map<String, Object> charges = new HashMap<String, Object>();
            charges.put("charges", chargesToSettle);
            request.setParameters(charges);
        } 
        return JSONUtils.getAsObject((JsonObject) request.execute(), Subscription.class);
    } */
        final PagarMeRequest request = new PagarMeRequest(HttpMethod.GET, "/transactions/calculate_installments_amount");
        Map<String, Object> installments = new HashMap<String, Object>();
        installments.put("amount",amount);
        installments.put("max_installments", maxInstallments);
        installments.put("free_installments", freeInstallments);
        installments.put("interest_rate", interestRate);
        request.setParameters(installments);
        JSONUtils.getAsJson(request.execute());

        return null;
    }
}
