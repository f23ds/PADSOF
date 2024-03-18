package Usuario;

/**
 * Clase que da soporte para la clase empleado
 */
public class Empleado extends Usuario {

  private String dni, direccion;
  private long nss, numCuenta;
  private boolean enviarNotificaciones, cambiarClimatizacion, venderEntradas;

  /**
   * Constructor para la clase empleado
   * @param password del empleado
   * @param dni del empleaod
   * @param direccion del empleado
   * @param nss del empleado
   * @param numCuenta del empleado
   * @param enviarNotificaciones si se le permite enviar o no notificaciones
   * @param cambiarClimatizacion si se le permite cambiar o no la climatización de las salas
   * @param venderEntradas si se le permite vender o no entradas a los clientes no registrados
   */
  public Empleado(
    String password,
    String dni,
    String direccion,
    long nss,
    long numCuenta,
    boolean enviarNotificaciones,
    boolean cambiarClimatizacion,
    boolean venderEntradas
  ) {
    super(password);
    this.dni = dni;
    this.direccion = direccion;
    this.nss = nss;
    this.numCuenta = numCuenta;
    this.enviarNotificaciones = enviarNotificaciones;
    this.cambiarClimatizacion = cambiarClimatizacion;
    this.venderEntradas = venderEntradas;
  }

  /**
   * Getter para el atributo dni
   * @return dni
   */
  public String getDni() {
    return dni;
  }

  /**
   * Getter para el atributo direccion
   * @return direccion
   */
  public String getDireccion() {
    return direccion;
  }

  /**
   * Getter para el atributo nss
   * @return nss
   */
  public long getNss() {
    return nss;
  }

  /**
   * Getter para el atributo numCuenta
   * @return numCuenta
   */
  public long getNumCuenta() {
    return numCuenta;
  }

  /**
   * Getter para el atributo enviarNotificaciones
   * @return enviarNotificaciones
   */
  public boolean isEnviarNotificaciones() {
    return enviarNotificaciones;
  }

  /**
   * Getter para el atributo cambiarClimatizacion
   * @return cambiarClimatizacion
   */
  public boolean isCambiarClimatizacion() {
    return cambiarClimatizacion;
  }

  /**
   * Getter para el atributo venderEntradas
   * @return venderEntradas
   */
  public boolean isVenderEntradas() {
    return venderEntradas;
  }

  /**
   * Setter para el atributo dni
   * @param dni
   */
  public void setDni(String dni) {
    this.dni = dni;
  }

  /**
   * Setter para el atributo direccion
   * @param direccion
   */
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  /**
   * Setter para el atributo nss
   * @param nss
   */
  public void setNss(long nss) {
    this.nss = nss;
  }

  /**
   * Setter para el atributo numCuenta
   * @param numCuenta
   */
  public void setNumCuenta(long numCuenta) {
    this.numCuenta = numCuenta;
  }

  /**
   * Setter para el atributo enviarNotificaciones
   * @param enviarNotificaciones
   */
  public void setEnviarNotificaciones(boolean enviarNotificaciones) {
    this.enviarNotificaciones = enviarNotificaciones;
  }

  /**
   * Setter para el atributo cambiarClimatizacion
   * @param cambiarClimatizacion
   */
  public void setCambiarClimatizacion(boolean cambiarClimatizacion) {
    this.cambiarClimatizacion = cambiarClimatizacion;
  }

  /**
   * Setter para el atributo venderEntradas
   * @param venderEntradas
   */
  public void setVenderEntradas(boolean venderEntradas) {
    this.venderEntradas = venderEntradas;
  }
}
