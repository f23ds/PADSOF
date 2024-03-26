package Utils;

/** 
 * Clase para dar soporte a la humedad
 * 
 * @author Víctor Sanz de Vergas
*/
public class Humedad {
    /*Atributos de la clase Humedad */
    private float min;
    private float max;
    
    /**
     * Constructor de la clase Humedad
     * 
     * @param min minimo de humedad
     * @param max maximo de humedad
     */
    public Humedad(float min, float max) {
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
     * @param min minimo de humedad
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
     * @param max maximo de humedad
     */
    public void setMax(float max) {
        this.max = max;
    }

    /**
     * Checker para comprobar si dos humedades son compatibles
     * 
     * @param humedad a checkear
     * @return true o false
     */
    public boolean checkHumedad(Humedad humedad) {

        if (humedad == null) {
            return false;
        }

        return this.min > humedad.min || this.max < humedad.max;
    }
}
