package Sala;

import Utils.*;
import Exposicion.*;

import java.io.*;

/** 
 * Clase abstracta para dar soporte a las salas
 * 
 * @author Víctor Sanz de Vergas
*/
public abstract class Sala implements Serializable {
    /*Atributos de la clase abstracta Sala */
    protected int aforo;
    protected int numTomasCorriente;
    protected Dimensiones dim;
    protected Sala subsala1;
    protected Sala subsala2;
    private Exposicion expo;

    /**
     * Constructor de la clase sala recibiendo como argumento un objeto Dimensiones
     * 
     * @param aforo aforo de la sala
     * @param numTomasCorriente numero de tomas de corriente de la sala
     * @param dim dimension de la sala
     */
    public Sala(int aforo, int numTomasCorriente, Dimensiones dim){
        this.aforo = aforo;
        this.numTomasCorriente = numTomasCorriente;
        this.dim = dim;
    }

    /**
     * Constructor de la clase sala recibiendo como argumento los atributos de la clase Dimensiones
     * 
     * @param aforo aforo de la sala
     * @param numTomasCorriente numero de tomas de corriente de la sala
     * @param ancho ancho de la sala
     * @param largo largo de la sala
     * @param alto alto de la sala
     */
    public Sala(int aforo, int numTomasCorriente, double ancho, double largo, double alto){
        this.aforo = aforo;
        this.numTomasCorriente = numTomasCorriente;
        this.dim = new Dimensiones(ancho, largo, alto);
        expo = null;
    }
    
    /**
     * 
     * Obtener el aforo de la sala
     * 
     * @return aforo de la sala
     */
    public int getAforo()
    {
        return aforo;
    }

    /**
     * 
     * Obtener el numero de tomas de corriente de la sala
     * 
     * @return numero de tomas de corriente
     */
    public int getTomasCorriente()
    {
        return numTomasCorriente;
    }

    /**
     * 
     * Obtener las dimensiones de la sala
     * 
     * @return dimensiones de la sala
     */
    public Dimensiones getDimensiones()
    {
        return dim;
    }

    /**
     * 
     * Setter para el atributo aforo
     * 
     * @param aforo integer con el aforo de la sala
     */
    public void setAforo(int aforo)
    {
        this.aforo = aforo;
    }

    /**
     * 
     * Setter para el atributo numTomasCorriente
     * 
     * @param numTomasCorriente integer con el numero de tomas de la sala
     */
    public void setTomasCorriente(int numTomasCorriente)
    {
        this.numTomasCorriente = numTomasCorriente;
    }

    /**
     * 
     * Setter para el atributo Dimensiones 
     * 
     * @param dim objeto dimensiones de la sala
     */
    public void setDimensiones(Dimensiones dim)
    {
        this.dim = dim;
    }

    /**
     * 
     * Setter para el atributo dim recibiendo los atributos de la clase Dimensiones
     * 
     * @param ancho double con ancho de la sala
     * @param largo double con largo de la sala
     * @param alto double con alto de la sala
     */
    public void setDimensiones(double ancho, double largo, double alto)
    {
        this.dim = new Dimensiones(ancho, largo, alto);
    }

    /**
     * Comprueba si una sala es climatizada
     * @return true o false
     */
    public abstract boolean isClimatizada();

    /**
     * Getter del atributo temperatura
     * @return null
     */
    public Temperatura getTemperatura() {
        return null;
    }

    /**
     * Getter del atributo humedad
     * @return null
     */
    public Humedad getHumedad() {
        return null;
    }


    /**
     * Getter de la primera subsala
     * 
     * @return subsala hija 1
     */
    public Sala getSubsala1() {
        return subsala1;
    }

    /**
     * Getter de la segunda subsala
     * 
     * @return subsala hija 2
     */
    public Sala getSubsala2() {
        return subsala2;
    }

    /**
     * getter del atributo exposicion
     * @return exposicion en la que está la sala
     */
    public Exposicion getExpo() {
        return expo;
    }

    /**
     * setter del atributo exposicion
     * @param expo exposicion a la que hay que asignar la sala
     */
    public void setExpo(Exposicion expo) {
        this.expo = expo;
    }

    /**
     * metodo abstracto para dividir sala
     * @return OK si se puede, ERROR en caso contrario
     */
    public abstract Status dividirSala(double ancho1, double ancho2, int aforo1, int aforo2, int numTomasCorriente1, int numTomasCorriente2, Temperatura t1, Temperatura t2, Humedad h1, Humedad h2);

    public abstract Status dividirSala(double ancho1, double ancho2, int aforo1, int aforo2, int numTomasCorriente1, int numTomasCorriente2);
   
}
