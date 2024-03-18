package Utils;


/** 
 * Clase para dar soporte a la temperatura
 * 
 * @author Víctor Sanz de Vergas
*/
public class Temperatura {
    /*Atributos de la clase Temperatura */
    private float min;
    private float max;

    /**
     * Constructor de la temperatura
     * 
     * @param min minimo de temperatura
     * @param max maximo de temperatura
     */
    public Temperatura(float min, float max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Getter del atributo minimo
     * 
     * @return
     */
    public float getMin() {
        return min;
    }

    /**
     * Setter del atributo minimo
     * 
     * @param min minimo de temperatura
     */
    public void setMin(float min) {
        this.min = min;
    }

    /**
     * Getter del atributo maximo
     * 
     * @return
     */
    public float getMax() {
        return max;
    }

    /**
     * Setter del atributo maximo
     * 
     * @param max maximo de temperatura
     */
    public void setMax(float max) {
        this.max = max;
    }
}
