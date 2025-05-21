package Exceptions;
/**
 * Exception lancée lorsqu'un article avec un ID donné existe déjà dans la base.
 */
public class ExceptionItemAlreadyExists extends RuntimeException {
  public ExceptionItemAlreadyExists(int ID) {
    super("Item " + ID + " est déjà dans la bases de données");
  }
}
