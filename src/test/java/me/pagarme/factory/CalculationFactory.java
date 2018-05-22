package me.pagarme.factory;

import java.util.Collection;
import me.pagar.model.Calculation;
import me.pagar.model.Installment;

/**
 *
 * @author jonatasmaxi
 */
public class CalculationFactory {

    public Calculation create() throws Throwable {
        Calculation calc = new Calculation();
        return calc;
    }
}
