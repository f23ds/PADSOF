package Usuario;

import java.util.*;
import java.util.stream.Collectors;

import Entrada.*;

/**
 * Clase para dar soporte a cliente registrado
 *
 * @author Fabio Desio
 */
public class ClienteRegistrado extends Usuario {

  private String dni;
  private boolean recibirNotificaciones;
  private List<Notificacion> notificaciones;
  private List<Comprada> entradas;

  /**
   * Constructor de la clase cliente registrado
   * @param password del cliente registrado
   * @param dni del cliente registrado
   * @param recibirNotificaciones si permite recibir o no notificaciones
   */
  public ClienteRegistrado(
    String password,
    String dni,
    boolean recibirNotificaciones
  ) {
    super(password);
    this.dni = dni;
    this.recibirNotificaciones = recibirNotificaciones;
    this.notificaciones = new ArrayList<>();
    this.entradas = new ArrayList<>();
  }

  /**
   * Metodo para ver notificaciones (tendra sentido con la interfaz gráfica)
   * @return null
   */
  public List<Notificacion> verNotificaciones() {
    return null;
  }

  /* GETTERS Y SETTERS */
  /**
   * Getter de atributo dni
   * @return dni
   */
  public String getDni() {
    return dni;
  }

  /**
   * Getter de atributo recibirNotificaciones
   * @return recibirNotificaciones
   */
  public boolean isRecibirNotificaciones() {
    return recibirNotificaciones;
  }

    /**
     * Getter de atributo notificaciones
     * @return notificaciones
     */
    public List<Notificacion> getNotificaciones() {
      return notificaciones;
    }

  /**
   * Setter del atributo dni
   * @param dni del cliente
   */
  public void setDni(String dni) {
    this.dni = dni;
  }

  /**
   * Setter del atributo recibirNotificaciones
   * @param recibirNotificaciones boolean
   */
  public void setRecibirNotificaciones(boolean recibirNotificaciones) {
    this.recibirNotificaciones = recibirNotificaciones;
  }

  /**
   * Setter del atributo notificaciones
   * @param notificaciones notificaciones a añadir
   */
  public void addNotificaciones(Notificacion ... notificaciones) {
    for(Notificacion n: notificaciones){
      this.notificaciones.add(n);
    }
  }

  /**
   * Getter del atributo entradas
   * @return entradas compradas por el cliente
   */
  public List<Comprada> getEntradas() {
    return entradas;
  }

  /**
   * añadir entradas a un cliente
   * 
   * @param entradasCompradas entradas compradas
   */
  public void addEntradas(Comprada... entradasCompradas) {
      List<Comprada> entradasFilt = Arrays
      .stream(entradasCompradas)
      .filter(elemento -> elemento != null)
      .collect(Collectors.toList());

    this.entradas.addAll(entradasFilt);
  }
}
