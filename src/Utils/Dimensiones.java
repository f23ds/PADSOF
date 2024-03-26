package Utils;


/** 
 * Clase para dar soporte a las dimensiones de un objeto o sala
 * 
 * @author Víctor Sanz de Vergas
*/
public class Dimensiones {
    private float ancho;
    private float largo;
    private float alto;


    /**
     * Constructor de la clase Dimensionse
     * 
     * @param ancho float con el ancho
     * @param largo float con el largo
     * @param alto float con el alto
     */
    public Dimensiones(float ancho, float largo, float alto){
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
    }

    /**
     * Getter del atributo ancho
     * 
     * @return float del ancho
     */
    public float getAncho()
    {
        return ancho;
    }

    /**
     * Getter del atributo largo
     * 
     * @return float del largo
     */
    public float getLargo()
    {
        return largo;
    }

    /**
     * Getter del atributo alto
     * 
     * @return float del alto
     */
    public float getAlto()
    {
        return alto;
    }
    
    /**
     * Setter del atributo ancho
     * 
     * @param ancho float del ancho
     */
    public void setAncho(float ancho)
    {
        this.ancho = ancho;
    }

    /**
     * Setter del atributo largo
     * 
     * @param largo float del largo
     */
    public void setLargo(float largo)
    {
        this.largo = largo;
    }

    /**
     * Setter del atributo alto
     * 
     * @param alto float del alto
     */
    public void setAlto(float alto)
    {
        this.alto = alto;
    }


    /**
     * Checker para comprobar si dos dimensiones son compatibles
     * 
     * @param dim a checkear
     * @return true o false
     */
    public boolean checkDimensiones(Dimensiones dim) {

        return this.alto < dim.alto || this.ancho < dim.ancho || this.largo < dim.largo;
    }

}
