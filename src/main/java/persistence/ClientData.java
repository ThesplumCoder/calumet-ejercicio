/**
 * ClientData permite traer todos los registros de los clientes de base de 
 * datos y mapearlos en objetos para poder utilizarlos.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package persistence;

public class ClientData extends CrudOperations {

  public ClientData() {
    super("client");
  }
}
