package Exposicion;

import java.util.*;

import Exposicion.Descuento.*;
import Sorteo.*;

/**
 * Clase para dar soporte a las exposiciones permanentes
 * 
 * @author Fabio Desio
 */
public class ExposicionPermanente extends Exposicion {
    
    /**
     * Constructor de una exposición permanente 
     * @param nombre
     * @param autor
     * @param descr
     * @param estado
     * @param descuentos
     * @param sorteo
     * @param tiposObras
     */
    public ExposicionPermanente(String nombre, String autor, String descr, EstadoExposicion estado,
            ArrayList<Descuento> descuentos, Sorteo sorteo, ArrayList<TipoObraExposicion> tiposObras) {
        super(nombre, autor, descr, estado, descuentos, sorteo, tiposObras);
    }
    

    /* TODO: métodos clase exposición permanente */
}
