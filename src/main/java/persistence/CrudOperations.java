/**
 * Esta clase me permite utilizar las operaciones más comunes sobre la base de 
 * datos, para cualquier entidad.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CrudOperationsException;
import utility.ConnectionDB;

public abstract class CrudOperations {
  private ConnectionDB cDB = new ConnectionDB("calumet_ejercicio", "localhost:3306", "javaApp", "javaApp");
  private Connection conn = cDB.getConnection();
  private String entity;

  /**
   * Configura el objeto para que utilice las operaciones CRUD sobre la entidad
   * que se indique.
   *
   * @param entity Nombre de la entidad como está identificada en BD.
   */
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
  protected ResultSet getAll() {
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

  /**
   * Inserta un registro en la tabla de la entidad.[WIP]
   *
   * @param columns Una lista con todos los nombres de columnas que se quieren tomar en cuenta para hacer la inserción. Se toma en cuenta el orden en que están en la lista.
   * @param values Valores de la entidad que se quiere registrar en BD.
   */
  protected void addOne(List<String> columns, List<String> values) throws CrudOperationsException {
    if(columns.size() != values.size()) {
      throw new CrudOperationsException("The amount of columns against the values is different.");
    }

    int amountColumns;
    Statement stmt;
    String columnOrder;
    String[] columnsArr;
    String valuesOrder;
    String insertQuery;

    amountColumns = columns.size();
    columnsArr = (String[]) columns.toArray();
    columnOrder = new String();
    columnOrder += "(";
    for(int i = 0; i < amountColumns; i++) {
      columnOrder += columnsArr[i];
      if(i != (amountColumns - 1)) {
        columnOrder += ",";
      }
    }
    columnOrder += ")";
    insertQuery = "INSERT INTO " + entity + columnOrder + " VALUES ";
  }
}
