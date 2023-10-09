/**
 * Esta clase me permite utilizar las operaciones más comunes sobre la base de 
 * datos, para cualquier entidad.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package persistence;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import utility.ConnectionDB;

public abstract class CrudOperations {
  private ConnectionDB cDB = new ConnectionDB("calumet-ejercicio", "localhost:3306", "javaApp", "javaApp");
  private Connection conn = cDB.getConnection();
  private String entity;

  public CrudOperations(String entity) {
    if (!(entity.isBlank())) {
      this.entity = entity;
    }
  }

  /**
   * Retorna todos los registros de la entidad que se solicita.
   *
   * @return Todos los registros encontrados en la tabla de la entidad. Si la
   *         operación falló entonces devuelve nulo.
   */
  public ResultSet getAll() {
    Statement stmt;
    ResultSet rs = null;
    String selecQuery = "SELECT * FROM " + entity;

    try {
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rs = stmt.executeQuery(selecQuery);
      return rs;
    } catch (SQLException sqlex) {
      Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, sqlex);
    }
    return rs;
  }
}
