package Exceptions;

public class ExceptionItemNotFound extends RuntimeException {
    public ExceptionItemNotFound(int ID) {
        super("Item " + ID + " n'est pas dans la bases données");
    }
}
