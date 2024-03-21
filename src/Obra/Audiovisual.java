package Obra;

/**
 * 
 */
public class Audiovisual extends Obra {
    int duracion;

    public Audiovisual(String nombre, String autor, int anio, boolean propia, String poliza, int duracion,
            float ancho, float largo, float alto) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto);

        this.duracion = duracion;

    }

    public Audiovisual(String nombre, String autor, int anio, boolean propia, String poliza, int duracion,
            Dimensiones dim) {
        super(nombre, autor, anio, propia, poliza, dim);

        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
