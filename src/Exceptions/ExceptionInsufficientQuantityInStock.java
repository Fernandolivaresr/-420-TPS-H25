package Exceptions;
/**
 * Exception lancée lorsqu'on tente de retirer plus d'unités qu'il n'y en a en stock.
 */
public class ExceptionInsufficientQuantityInStock extends RuntimeException {
    public ExceptionInsufficientQuantityInStock(int quantity) {
        super("Stock insuffisant pour enlever " + quantity + " unité(s)");
    }
}
