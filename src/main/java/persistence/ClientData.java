/**
 * ClientData permite traer todos los registros de los clientes de base de 
 * datos y mapearlos en objetos para poder utilizarlos.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.ClientException;
import model.Client;

public class ClientData extends CrudOperations {

  /**
   * Crea el mapeador de clientes, y informa a la superclase que la entidad que va
   * a manejar es la del cliente.
   */
  public ClientData() {
    super("client");
  }

  /**
   * Retorna una lista con todos los clientes que se trajeron desde la base de
   * datos, convertidos en objetos.
   *
   * @return Una lista de clientes.
   */
  public List<Client> getAllClients() {
    List<Client> clients = new ArrayList<>();
    Client c;
    Long id;
    String name;
    String telephoneNumber;
    ResultSet rs = getAll();

    if (rs != null) {
      try {
        while (rs.next()) {
          id = Long.valueOf(rs.getInt("id"));
          name = rs.getString("name");
          telephoneNumber = rs.getString("telephone_number");
          c = new Client(id, name, telephoneNumber);
          clients.add(c);
        }
      } catch (SQLException sqlex) {
        Logger.getLogger(ClientData.class.getName()).log(Level.SEVERE, null, sqlex);
      } catch (ClientException clex) {
        System.out.println(clex.getMessage());
      }
    }
    return clients;
  }
}
