package Usuario;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase para dar soporte a cliente registrado
 *
 * @author Fabio Desio
 */
public class ClienteRegistrado extends Usuario {

  private String dni;
  private boolean recibirNotificaciones;
  private Collection<Notificacion> notificaciones;

  /**
   * Constructor de la clase cliente registrado
   * @param password del cliente registrado
   * @param dni del cliente registrado
   * @param recibirNotificaciones si permite recibir o no notificaciones
   * @param notificaciones array de notificaciones 
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
  }

  /* FIXME: se implementa con la interfaz gráfica */
  public Collection<Notificacion> verNotificaciones() {
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
  public Collection<Notificacion> getNotificaciones() {
    return notificaciones;
  }

  /**
   * Setter del atributo dni
   * @param dni
   */
  public void setDni(String dni) {
    this.dni = dni;
  }

  /**
   * Setter del atributo recibirNotificaciones
   * @param recibirNotificaciones
   */
  public void setRecibirNotificaciones(boolean recibirNotificaciones) {
    this.recibirNotificaciones = recibirNotificaciones;
  }

  /**
   * Setter del atributo notificaciones
   * @param notificaciones
   */
  public void setNotificaciones(Collection<Notificacion> notificaciones) {
    this.notificaciones = notificaciones;
  }
}
