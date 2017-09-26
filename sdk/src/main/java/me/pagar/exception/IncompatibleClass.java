package me.pagar.exception;

public class IncompatibleClass extends RuntimeException {

    public IncompatibleClass(String message, Exception thrownException) {
        super(message, thrownException);
    }

    public IncompatibleClass(String message) {
        super(message);
    }
}
