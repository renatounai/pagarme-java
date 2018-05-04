
package me.pagar.model;

/**
 *
 * @author jonatasmaxi
 */
public class Installment  extends PagarMeModel<String> {
    int installment;
    int amount; 
    int installment_amount; 

    public int getInstallment() {
        return installment;
    }

    public int getAmount() {
        return amount;
    }

    public int getInstallment_amount() {
        return installment_amount;
    }
    
    
}
