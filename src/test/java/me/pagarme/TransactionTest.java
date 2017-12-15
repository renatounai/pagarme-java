package me.pagarme;

import org.junit.Assert;
import org.junit.Test;
import me.pagar.model.Transaction;

public class TransactionTest {
    @Test
    public void testCreateTransaction() {
        Transaction transaction = new Transaction();
        transaction.save()

        Assert.assertTrue(transaction instanceof Transaction);
    }
}
