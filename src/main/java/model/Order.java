/**
 * Esta clase abstrae la entidad de orden, que es la contenedora de todos los 
 * detalles del pedido de pizza de un cliente.
 *
 * @author ThesplumCoder.
 * @date 8/10/2023.
 */
package model;

import exception.OrderException;

public class Order {
  private Long id;
  private Client client;
  private String pizzaFlavor;
  private String notes;

  /**
   * Este constructor crea una orden con todos los detalles excepto las notas. En
   * este caso el cliente no ha agregado ningun comentario sobre su pedido.
   *
   * @param id          Identificador único para cada orden.
   * @param client      Cliente que ha hecho la orden.
   * @param pizzaFlavor Sabor de la pizza.
   */
  public Order(Long id, Client client, String pizzaFlavor) throws OrderException {
    this(id, client, pizzaFlavor, "");
  }

  /**
   * Este constructor crea una orden con todos los detalles definidos que ha
   * proporcionado el cliente.
   *
   * @param id          Identificador único para cada orden.
   * @param client      Cliente con que ha creado la orden.
   * @param pizzaFlavor Sabor de la pizza.
   * @param notes       Notas agregadas por el cliente sobre la orden.
   */
  public Order(Long id, Client client, String pizzaFlavor, String notes) throws OrderException {
    if (id.equals(null) || client.equals(null) || pizzaFlavor.equals(null) || notes.equals(null)) {
      throw new OrderException("A field doesn't exist.");
    }

    this.id = id;
    this.client = client;

    if (pizzaFlavor.isBlank()) {
      throw new OrderException("The pizza flavor is blank.");
    }
    this.pizzaFlavor = pizzaFlavor;

    this.notes = notes;
  }

  /**
   * Retorna el identificador de la orden.
   *
   * @return Identificador único de la orden.
   */
  public Long getId() {
    return id;
  }

  /**
   * Retorna el cliente que realizó la orden.
   *
   * @return Objeto que representa al cliente.
   */
  public Client getClient() {
    return client;
  }

  /**
   * Retorna el sabor de la pizza de la orden.
   *
   * @return Sabor de la pizza de la orden.
   */
  public String getPizzaFlavor() {
    return pizzaFlavor;
  }

  /**
   * Retorna las notas que el cliente puso en la orden.
   *
   * @return Notas de la orden.
   */
  public String getNotes() {
    return notes;
  }

  /**
   * Cambia el identificador de la orden.
   *
   * @param id Nuevo identificador de la orden.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Cambia el cliente de la orden.
   *
   * @param client Nuevo cliente que solicita la orden.
   */
  public void setClient(Client client) {
    this.client = client;
  }

  /**
   * Cambia el sabor de la pizza de la orden.
   *
   * @param pizzaFlavor Nuevo sabor de pizza para la orden.
   */
  public void setPizzaFlavor(String pizzaFlavor) {
    this.pizzaFlavor = pizzaFlavor;
  }

  /**
   * Cambia las notas adicionales que puede poner el cliente a la orden.
   *
   * @param notes Nuevas notas que el cliente pone a la orden.
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }
}
