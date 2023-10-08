/**
 * Esta clase abstrae a la entidad cliente, que es la que puede crear las ordenes 
 * de pizza en el sistema.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package model;

import exception.ClientException;

public class Client {
  private Long id;
  private String name;
  private String telephoneNumber;

  /**
   * Este constructor crea un cliente que solamente se identifica con el número
   * telefónico, esto porque algunos clientes no les gusta dar su nombre. A estos
   * clientes se les conoce como "clientes anónimos".
   *
   * @param telephoneNumber Número telefónico del cliente.
   */
  public Client(Long id, String telephoneNumber) throws ClientException {
    this(id, "Anonymous", telephoneNumber);
  }

  /**
   * Este constructor crea un cliente que proporciona su nombre y su número
   * telefónico.
   *
   * @param id              Identificador único para cada cliente.
   * @param name            Nombre del cliente.
   * @param telephoneNumber Número telefónico del cliente.
   */
  public Client(Long id, String name, String telephoneNumber) throws ClientException {
    if (id.equals(null) || name.equals(null) || telephoneNumber.equals(null)) {
      throw new ClientException("A field doesn't exist.");
    }

    this.id = id;

    if (name.isBlank()) {
      throw new ClientException("The name is blank.");
    }
    this.name = name;

    this.telephoneNumber = telephoneNumber;
  }

  /**
   * Este método retorna el identificador del cliente.
   *
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Este método retorna el nombre del cliente.
   *
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Este método retorna el número telefónico del cliente.
   *
   * @return telephoneNumber
   */
  public String getTelephoneNumber() {
    return telephoneNumber;
  }

  /**
   * Este método permite cambiar el identificador del cliente.
   *
   * @param id Identificador nuevo del cliente.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Este método permite cambiar el nombre del cliente.
   *
   * @param name Nuevo nombre para el cliente.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Este método permite cambiar el número telefónico del cliente.
   *
   * @param telephoneNumber Número telefónico nuevo del cliente.
   */
  public void setTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }
}
