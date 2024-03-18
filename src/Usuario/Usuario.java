package Usuario;

/**
 * Clase para dar soporte a la clase de usuario
 *
 * @author Fabio Desio
 */
public abstract class Usuario {

  private String password;

  /**
   * Constructor para la clase de usuario
   * @param password del usuario en cuestión
   */
  public Usuario(String password) {
    this.password = password;
  }

  /**
   * Getter del atributo password
   *
   * @return contraseña del usuario
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter del atributo password
   *
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
