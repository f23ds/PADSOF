package Sala;

import Utils.*;


/** 
 * Clase para dar soporte a las salas no climatizadas
 * 
 * @author Víctor Sanz de Vergas
*/
public class SalaNoClimatizada extends Sala{

    /**
     * Constructor de la clase Sala no climatizada
     * 
     * @param aforo aforo de la sala
     * @param numTomasCorriente numero de tomas de corriente de la sala
     * @param dim objeto referente a las dimensiones de la sala
     */
    public SalaNoClimatizada(int aforo, int numTomasCorriente, Dimensiones dim) {
        super(aforo, numTomasCorriente, dim);
    }

    /**
     * 
     * @param aforo aforo de la sala
     * @param numTomasCorriente numero de tomas de corriente de la sala
     * @param ancho ancho de la sala
     * @param largo largo de la sala
     * @param alto alto de la sala
     */
    public SalaNoClimatizada(int aforo, int numTomasCorriente, float ancho, float largo, float alto) {
        super(aforo, numTomasCorriente, ancho, largo, alto);
    }
}
