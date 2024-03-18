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

    /**
     * Divide la sala en otras dos setteando los atributos subsala2 y subsala2 
     * 
     * @param ancho1 ancho de la primera subsala
     * @param ancho2 ancho de la segunda subsala
     * @param aforo1 aforo de la primera subsala
     * @param aforo2 aforo de la segunda subsala
     * @param numTomasCorriente1 numero de tomas de la primera subsala
     * @param numTomasCorriente2 numero de tomas de la segunda subsala
     * @return OK o ERROR en funcion de si hay ido bien o mal
     */
    public Status dividirSala(float ancho1, float ancho2, int aforo1, int aforo2, int numTomasCorriente1, int numTomasCorriente2){
        if(ancho1 + ancho2 != dim.getAncho() || aforo1 + aforo2 != aforo || numTomasCorriente1 + numTomasCorriente2 != numTomasCorriente){
            return Status.ERROR;
        }

        subsala1 = new SalaNoClimatizada(aforo1, numTomasCorriente1, new Dimensiones(ancho1, dim.getLargo(), dim.getAlto()));
        subsala2 = new SalaNoClimatizada(aforo2, numTomasCorriente2, new Dimensiones(ancho2, dim.getLargo(), dim.getAlto()));

        return Status.OK;
    }
}
