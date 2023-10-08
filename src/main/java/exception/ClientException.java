/**
 * Esta clase me permite lanzar la excepción causada por un mal manejo de la 
 * clase que modela la entidad "cliente".
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package exception;

public class ClientException extends Exception {

  public ClientException(String message) {
    super(message);
  }
}
