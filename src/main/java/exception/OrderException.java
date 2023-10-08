/**
 * Esta clase me permite lanzar la excepción causada por un mal manejo de la 
 * clase que modela la entidad "orden".
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package exception;

public class OrderException extends Exception {

  public OrderException(String message) {
    super(message);
  }
}
