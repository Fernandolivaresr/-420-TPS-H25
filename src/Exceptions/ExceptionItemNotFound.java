package Exceptions;
/**
 * Exception lancée lorsqu'un article recherché n'existe pas dans la base.
 */
public class ExceptionItemNotFound extends RuntimeException {
    public ExceptionItemNotFound(int ID) {
        super("Item " + ID + " n'est pas dans la bases données");
    }
}
