/**
 * Esta clase me permite establecer una conexión con la base de datos de la 
 * aplicación.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package utility;

import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
  private final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private final String PROTOCOL = "jdbc:mysql://";

  private String url;
  private String database;
  private String hostname;
  private String user;
  private String password;
  private Connection connection;

  /**
   * Crea la conexión a base de datos con los parámetros especificados. Si el
   * proceso tiene éxito la conexión se podrá empezar a utilizar para hacer
   * operaciones.
   *
   * @param database Nombre de la base de datos.
   * @param hostname Dominio en el cual está respondiendo el gestor de base de
   *                 datos.
   * @param user     Nombre del usuario con el que se quiere autenticar.
   * @param password Contraseña del usuario.
   */
  public ConnectionDB(String database, String hostname, String user, String password) {
    url = PROTOCOL + hostname + "/" + database + "?serverTimezone=UTC";
    try {
      Class.forName(DRIVER);
      connection = DriverManager.getConnection(url, user, password);
      connection.setTransactionIsolation(8);
      System.out.println("Connected");
    } catch (ClassNotFoundException cnfex) {
      Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, cnfex);
    } catch (SQLException sqlex) {
      Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, sqlex);
    }
  }

  /**
   * Retorna la conexión que nos permite interactuar con la base de datos.
   *
   * @return Objeto de la conexión exitosa. Si hubo algún falló retornará nulo.
   */
  public Connection getConnection() {
    return connection;
  }

  /**
   * Cierra la conexión establecida con base de datos.
   */
  public void closeConnection() {
    if (!connection.equals(null)) {
      try {
        connection.close();
      } catch (SQLException sqlex) {
        Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, sqlex);
      }
    }
  }

}
