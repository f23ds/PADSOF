package Obra;

import Utils.*;

public class Escultura extends ObraClimatizada {

    private String material;

    /**/
    public Escultura(String nombre, String autor, int anio, boolean propia, String poliza, String material, float ancho,
            float largo, float alto, float tempMin, float tempMax, float humMin, float humMax) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto, tempMin, tempMax, humMin, humMax);

        this.material = material;

    }

    public Escultura(String nombre, String autor, int anio, boolean propia, String poliza, String material,
            Dimensiones dim, Temperatura temp, Humedad hum) {
        super(nombre, autor, anio, propia, poliza, dim, temp, hum);

        this.material = material;

    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
