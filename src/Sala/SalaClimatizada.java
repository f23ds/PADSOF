package Sala;

import Utils.*;

/**
 * Clase para dar soporte a las salas climatizadas
 * 
 * @author Víctor Sanz de Vergas
 */
public class SalaClimatizada extends Sala {
    private Temperatura temperatura;
    private Humedad humedad;

    /**
     * Constructor de la clase SalaClimatizada con atributos pasados como objetos
     * 
     * @param id                id de la
     * @param aforo
     * @param numTomasCorriente
     * @param dim
     */
    public SalaClimatizada(int aforo, int numTomasCorriente, Dimensiones dim, Temperatura temperatura,
            Humedad humedad) {
        super(aforo, numTomasCorriente, dim);
        this.humedad = humedad;
        this.temperatura = temperatura;
    }

    /**
     * Constructor de la clase SalaClimatizada que inicializa una sala con
     * condiciones climáticas.
     * 
     * @param aforo             Aforo máximo de la sala
     * @param numTomasCorriente Número de tomas de corriente disponibles en la sala
     * @param ancho             Ancho de la sala
     * @param largo             Largo de la sala
     * @param alto              Alto de la sala
     * @param temp_min          Temperatura mínima admitida en la sala
     * @param temp_max          Temperatura máxima admitida en la sala
     * @param hum_min           Humedad mínima admitida en la sala
     * @param hum_max           Humedad máxima admitida en la sala
     */
    public SalaClimatizada(int aforo, int numTomasCorriente, double ancho, double largo, double alto, double temp_min,
            double temp_max, double hum_min, double hum_max) {
        super(aforo, numTomasCorriente, ancho, largo, alto);
        this.humedad = new Humedad(hum_min, hum_max);
        this.temperatura = new Temperatura(temp_min, temp_max);
    }

    /**
     * Getter del atributo temperatura
     * 
     * @return objeto temperatura
     */
    public Temperatura getTemperatura() {
        return temperatura;
    }

    /**
     * Setter del atributo temperatura
     * 
     * @param temperatura objeto referente a la temperatura de la sala
     */
    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Setter del atributo temperatura
     * 
     * @param temp_min temperatura minima de la sala
     * @param temp_max temperatura máxima de la sala
     */
    public void setTemperatura(double temp_min, double temp_max) {
        this.temperatura = new Temperatura(temp_min, temp_max);
    }

    /**
     * Getter del atributo humedad
     * 
     * @return objeto referente a la humedad de la sala
     */
    public Humedad getHumedad() {
        return humedad;
    }

    /**
     * Setter del atributo humedad
     * 
     * @param humedad objeto referente a la humedad de la sala
     */
    public void setHumedad(Humedad humedad) {
        this.humedad = humedad;
    }

    /**
     * Setter del atributo humedad recibiendo como argumento los parámetros de
     * humedad
     * 
     * @param hum_min humedad minima de la sala
     * @param hum_max humedad máxima de la sala
     */
    public void setHumedad(double hum_min, double hum_max) {
        this.humedad = new Humedad(hum_min, hum_max);
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
            int numTomasCorriente2, Temperatura t1, Temperatura t2, Humedad h1, Humedad h2) {
        if (ancho1 + ancho2 != dim.getAncho() || aforo1 + aforo2 != aforo
                || numTomasCorriente1 + numTomasCorriente2 != numTomasCorriente || this.getExpo() != null) {
            return Status.ERROR;
        }

        subsala1 = new SalaClimatizada(aforo1, numTomasCorriente1,
                new Dimensiones(ancho1, dim.getLargo(), dim.getAlto()), t1, h1);
        subsala2 = new SalaClimatizada(aforo2, numTomasCorriente2,
                new Dimensiones(ancho2, dim.getLargo(), dim.getAlto()), t2, h2);

        return Status.OK;
    }

    /**
     * la sala es climatizada
     */
    public boolean isClimatizada() {
        return true;
    }

    /**
     * Divide la sala en dos secciones con dimensiones y capacidades especificadas,
     * sin configurar condiciones climáticas para cada sección.
     * 
     * @param ancho1             Ancho de la primera sección
     * @param ancho2             Ancho de la segunda sección
     * @param aforo1             Aforo máximo de la primera sección
     * @param aforo2             Aforo máximo de la segunda sección
     * @param numTomasCorriente1 Número de tomas de corriente disponibles en la
     *                           primera sección
     * @param numTomasCorriente2 Número de tomas de corriente disponibles en la
     *                           segunda sección
     * @return Estado del proceso de división de la sala
     */
    public Status dividirSala(double ancho1, double ancho2, int aforo1, int aforo2, int numTomasCorriente1,
            int numTomasCorriente2) {
        return Status.ERROR;
    }

}
