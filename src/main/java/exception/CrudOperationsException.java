/**
 * Esta clase me permite lanzar la excepción causada por un mal manejo de la 
 * clase que realiza las operaciones CRUD.
 *
 * @author ThesplumCoder.
 * @date 12/10/2023.
 */
package exception;

public class CrudOperationsException extends Exception {

  public CrudOperationsException(String message) {
    super(message);
  }
}
