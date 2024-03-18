package Exposicion;

/**
 * Esta clase provee de soporte para la organización de exposiones
 *
 * @author Fabio Desio
 */
public abstract class Exposicion {

  private String nombre, autor, descr;
  private EstadoExposicion estado;

  /**
   * Constructor para la clase abstracta Exposición
   * @param nombre de la exposición
   * @param autor de la exposición
   * @param descr de la exposición
   */
  public Exposicion(
    String nombre,
    String autor,
    String descr,
    EstadoExposicion estado
  ) {
    this.nombre = nombre;
    this.autor = autor;
    this.descr = descr;
    this.estado = estado;
  }

  /**
   * Getter del atributo nombre
   * @return String con el nombre de la exposición
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Getter del atributo autor
   * @return String con el autor de la exposición
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Getter del atributo descripción
   * @return String con la descripción de la exposición
   */
  public String getDescr() {
    return descr;
  }

  /**
   * Getter del atributo estado
   * @return Estadosxposicion con el estado de la exposición
   */
  public EstadoExposicion getEstado() {
    return estado;
  }

  /**
   * Setter del atributo nombre
   * @param nombre de la exposición
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Setter del atributo autor
   * @param autor de la exposición
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * Setter del atributo descripción
   * @param descr de la exposición
   */
  public void setDescr(String descr) {
    this.descr = descr;
  }

  /**
   * Setter del atributo estado
   * @param estado de la exposición
   */
  public void setEstado(EstadoExposicion estado) {
    this.estado = estado;
  }
  /* TODO: métodos a implementar */

}
