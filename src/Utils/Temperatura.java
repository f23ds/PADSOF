package Utils;

import java.io.*;
/** 
 * Clase para dar soporte a la temperatura
 * 
 * @author Víctor Sanz de Vergas
*/
public class Temperatura implements Serializable {
    /*Atributos de la clase Temperatura */
    private double min;
    private double max;

    /**
     * Constructor de la temperatura
     * 
     * @param min minimo de temperatura
     * @param max maximo de temperatura
     */
    public Temperatura(double min, double max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Getter del atributo minimo
     * 
     * @return
     */
    public double getMin() {
        return min;
    }

    /**
     * Setter del atributo minimo
     * 
     * @param min minimo de temperatura
     */
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Getter del atributo maximo
     * 
     * @return
     */
    public double getMax() {
        return max;
    }

    /**
     * Setter del atributo maximo
     * 
     * @param max maximo de temperatura
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Checker para comprobar si dos temperaturas son compatibles
     * 
     * @param temp a checkear
     * @return true o false
     */
    public boolean checkTemperatura(Temperatura temp) {

        if (temp == null) {
            return false;
        }

        return this.min >= temp.min && this.max <= temp.max;
    }
}
