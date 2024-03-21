package Obra;

public class Escultura extends Obra {

    private String material;
    private Temperatura temp;
    private Humedad hum;

    /**/
    public Escultura(String nombre, String autor, int anio, boolean propia, String poliza, String material, float ancho,
            float largo, float alto, float tempMin, float tempMax, float humMin, float humMax) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto);

        this.material = material;
        this.temp = Temperatura(tempMin, tempMax);
        this.hum = Humedad(humMin, humMax);

    }

    public Escultura(String nombre, String autor, int anio, boolean propia, String poliza, String material,
            Dimensiones dim, Temperatura temp, Humedad hum) {
        super(nombre, autor, anio, propia, poliza, dim);

        this.material = material;
        this.temp = temp;
        this.hum = hum;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Temperatura getTemp() {
        return temp;
    }

    public void setTemp(Temperatura temp) {
        this.temp = temp;
    }

    public Humedad getHum() {
        return hum;
    }

    public void setHum(Humedad hum) {
        this.hum = hum;
    }
}
