package Usuario;

/**
 * Clase para dar soporte al usuario gestor
 * 
 * @author Fabio Desio
 */
public class Gestor extends Usuario {

  private String usuario;

  /**
   * Constructor para la clase gestor
   * @param password del gestor
   * @param usuario para identificar al gestor
   */
  public Gestor(String password, String usuario) {
    super(password);
    this.usuario = usuario;
  }

  /**
   * Getter para el atributo usuario
   * @return usuario
   */
  public String getUsuario() {
    return usuario;
  }

  /**
   * Setter para el atributo usuario
   * @param usuario
   */
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
}
