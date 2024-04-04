package Sala;

import Utils.*;

/**
 * Clase para dar soporte a las salas no climatizadas
 * 
 * @author Víctor Sanz de Vergas
 */
public class SalaNoClimatizada extends Sala {

    /**
     * Constructor de la clase Sala no climatizada
     * 
     * @param aforo             aforo de la sala
     * @param numTomasCorriente numero de tomas de corriente de la sala
     * @param dim               objeto referente a las dimensiones de la sala
     */
    public SalaNoClimatizada(int aforo, int numTomasCorriente, Dimensiones dim) {
        super(aforo, numTomasCorriente, dim);
    }

    /**
     * 
     * @param aforo             aforo de la sala
     * @param numTomasCorriente numero de tomas de corriente de la sala
     * @param ancho             ancho de la sala
     * @param largo             largo de la sala
     * @param alto              alto de la sala
     */
    public SalaNoClimatizada(int aforo, int numTomasCorriente, double ancho, double largo, double alto) {
        super(aforo, numTomasCorriente, ancho, largo, alto);
    }

    /**
     * Divide la sala en otras dos setteando los atributos subsala2 y subsala2
     * 
     * @param ancho1             ancho de la primera subsala
     * @param ancho2             ancho de la segunda subsala
     * @param aforo1             aforo de la primera subsala
     * @param aforo2             aforo de la segunda subsala
     * @param numTomasCorriente1 numero de tomas de la primera subsala
     * @param numTomasCorriente2 numero de tomas de la segunda subsala
     * @return OK o ERROR en funcion de si hay ido bien o mal
     */
    public Status dividirSala(double ancho1, double ancho2, int aforo1, int aforo2, int numTomasCorriente1,
            int numTomasCorriente2) {
        if (ancho1 + ancho2 != dim.getAncho() || aforo1 + aforo2 != aforo
                || numTomasCorriente1 + numTomasCorriente2 != numTomasCorriente || this.getExpo() != null) {
            return Status.ERROR;
        }

        subsala1 = new SalaNoClimatizada(aforo1, numTomasCorriente1,
                new Dimensiones(ancho1, dim.getLargo(), dim.getAlto()));
        subsala2 = new SalaNoClimatizada(aforo2, numTomasCorriente2,
                new Dimensiones(ancho2, dim.getLargo(), dim.getAlto()));

        return Status.OK;
    }

    /**
     * la sala no es climatizada
     */
    public boolean isClimatizada() {
        return false;
    }

    /**
     * Divide la sala en dos secciones con dimensiones y capacidades especificadas,
     * y configura las condiciones climáticas para cada sección.
     * 
     * @param ancho1             Ancho de la primera sección
     * @param ancho2             Ancho de la segunda sección
     * @param aforo1             Aforo máximo de la primera sección
     * @param aforo2             Aforo máximo de la segunda sección
     * @param numTomasCorriente1 Número de tomas de corriente disponibles en la
     *                           primera sección
     * @param numTomasCorriente2 Número de tomas de corriente disponibles en la
     *                           segunda sección
     * @param t1                 Condiciones de temperatura para la primera sección
     * @param t2                 Condiciones de temperatura para la segunda sección
     * @param h1                 Condiciones de humedad para la primera sección
     * @param h2                 Condiciones de humedad para la segunda sección
     * @return Estado del proceso de división de la sala
     */
    public Status dividirSala(double ancho1, double ancho2, int aforo1, int aforo2, int numTomasCorriente1,
            int numTomasCorriente2, Temperatura t1, Temperatura t2, Humedad h1, Humedad h2) {
        return Status.ERROR;
    }

}
