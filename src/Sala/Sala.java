package Sala;

import Utils.*;

/** 
 * Clase abstracta para dar soporte a las salas
 * 
 * @author Víctor Sanz de Vergas
*/
public abstract class Sala {
    /*Atributos de la clase abstracta Sala */
    protected int aforo;
    protected int numTomasCorriente;
    protected Dimensiones dim;
    protected Sala subsala1;
    protected Sala subsala2;

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
    public Sala(int aforo, int numTomasCorriente, float ancho, float largo, float alto){
        this.aforo = aforo;
        this.numTomasCorriente = numTomasCorriente;
        this.dim = new Dimensiones(ancho, largo, alto);
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
     * @param ancho float con ancho de la sala
     * @param largo float con largo de la sala
     * @param alto float con alto de la sala
     */
    public void setDimensiones(float ancho, float largo, float alto)
    {
        this.dim = new Dimensiones(ancho, largo, alto);
    }


    
}
