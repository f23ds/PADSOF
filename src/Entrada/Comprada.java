package Entrada;

import Usuario.ClienteRegistrado;
import java.time.LocalDateTime;

/**
 * Clase para dar soporte a las entradas compradas
 *
 * @author Fabio Desio
 */
public class Comprada extends Entrada {

  private int numTarjeta;
  private ClienteRegistrado cliente;

  /**
   * Constructor de la clase entrada comprada
   * @param numEntradas a comprar
   * @param precioCompra total de la compra
   * @param fechaHora de la compra
   * @param numTarjeta asociada a la compra
   * @param cliente comprador de la entrada
   */
  public Comprada(
    int numEntradas,
    float precioCompra,
    LocalDateTime fechaHora,
    int numTarjeta,
    ClienteRegistrado cliente
  ) {
    super(numEntradas, precioCompra, fechaHora);
    this.numTarjeta = numTarjeta;
    this.cliente = cliente;
  }

  /**
   * Getter del atributo numTarjeta
   * @return numTarjeta
   */
  public int getNumTarjeta() {
    return numTarjeta;
  }

  /**
   * Getter del atributo cliente registrado
   * @return cliente
   */
  public ClienteRegistrado getCliente() {
    return cliente;
  }

  /**
   * Setter del atributo numTarjeta
   * @param numTarjeta
   */
  public void setNumTarjeta(int numTarjeta) {
    this.numTarjeta = numTarjeta;
  }

  /**
   * Setter del atributo cliente registrado
   * @param cliente
   */
  public void setCliente(ClienteRegistrado cliente) {
    this.cliente = cliente;
  }
}
