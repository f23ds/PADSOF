package Sala;

import Utils.*;

/** 
 * Clase para dar soporte a las salas climatizadas
 * 
 * @author Víctor Sanz de Vergas
*/
public class SalaClimatizada extends Sala{
    private Temperatura temperatura;
    private Humedad humedad;

    /**
     * Constructor de la clase SalaClimatizada con atributos pasados como objetos
     * 
     * @param id id de la 
     * @param aforo
     * @param numTomasCorriente
     * @param dim
     */
    public SalaClimatizada(int aforo, int numTomasCorriente, Dimensiones dim, Temperatura temperatura, Humedad humedad) {
        super(aforo, numTomasCorriente, dim);
        this.humedad = humedad;
        this.temperatura = temperatura;
    }

    /**
     * Constructor de la clase SalaClimatizada con atributos pasados con subatributos
     * 
     * @param aforo aforo de la sala climatizada
     * @param numTomasCorriente numero de tomas de la sala climatizada
     * @param dim dimensiones de la clase SalaClimatizada
     * @param temp_min
     * @param temp_max
     * @param hum_min
     * @param hum_max
     */
    public SalaClimatizada(int aforo, int numTomasCorriente, float ancho, float largo, float alto, float temp_min, float temp_max, float hum_min, float hum_max) {
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
    public void setTemperatura(float temp_min, float temp_max) {
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
     * Setter del atributo humedad recibiendo como argumento los parámetros de humedad
     * 
     * @param hum_min humedad minima de la sala
     * @param hum_max humedad máxima de la sala
     */
    public void setHumedad(float hum_min, float hum_max) {
        this.humedad = new Humedad(hum_min, hum_max);
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
    public Status dividirSala(float ancho1, float ancho2, int aforo1, int aforo2, int numTomasCorriente1, int numTomasCorriente2, Temperatura t1, Temperatura t2, Humedad h1, Humedad h2){
        if(ancho1 + ancho2 != dim.getAncho() || aforo1 + aforo2 != aforo || numTomasCorriente1 + numTomasCorriente2 != numTomasCorriente){
            return Status.ERROR;
        }

        subsala1 = new SalaClimatizada(aforo1, numTomasCorriente1, new Dimensiones(ancho1, dim.getLargo(), dim.getAlto()), t1, h1);
        subsala2 = new SalaClimatizada(aforo2, numTomasCorriente2, new Dimensiones(ancho2, dim.getLargo(), dim.getAlto()), t2, h2);
    }
}
