package Usuario;

/**
 * Clase para dar soporte a las notificaciones
 * 
 * @author Fabio Desio
 */
public class Notificacion {

  private Empleado emisor;
  private String cuerpo;

  /**
   * Constructor de la clase notificacion
   * @param emisor empleado
   * @param cuerpo de la notificación
   */
  public Notificacion(Empleado emisor, String cuerpo) {
    this.emisor = emisor;
    this.cuerpo = cuerpo;
  }

  /**
   * Getter del atributo emisor
   * @return emisor
   */
  public Empleado getEmisor() {
    return emisor;
  }

  /**
   * Getter del atributo cuerpo
   * @return cuerpo
   */
  public String getCuerpo() {
    return cuerpo;
  }

  /**
   * Setter del atributo emisor
   * @param emisor
   */
  public void setEmisor(Empleado emisor) {
    this.emisor = emisor;
  }

  /**
   * Setter del atributo cuerpo
   * @param cuerpo
   */
  public void setCuerpo(String cuerpo) {
    this.cuerpo = cuerpo;
  }
}
