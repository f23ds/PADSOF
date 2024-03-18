package Exposicion;

/**
 * Clase para dar soporte a las exposiciones permanentes
 * 
 * @author Fabio Desio
 */
public class ExposicionPermanente extends Exposicion {
    /**
     * Constructor de exposición permanente
     * @param nombre de la exposición permamente 
     * @param autor de la exposición permamente
     * @param descr de la exposición permamente
     * @param estado de la exposición permamente
     */
    public ExposicionPermanente(String nombre, String autor, String descr, EstadoExposicion estado) {
        super(nombre, autor, descr, estado);
    }
}
