package Obra;

import Utils.*;

public abstract class ObraClimatizada extends Obra {
    private Temperatura temp;
    private Humedad humedad;

    public ObraClimatizada(String nombre, String autor, int anio, boolean propia, String poliza, Dimensiones dim,
            Temperatura temp, Humedad humedad) {
        super(nombre, autor, anio, propia, poliza, dim);
        this.temp = temp;
        this.humedad = humedad;
    }

    public ObraClimatizada(String nombre, String autor, int anio, boolean propia, String poliza, float ancho,
            float largo, float alto, float tempMin, float tempMax, float humMin, float humMax) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto);
        temp = new Temperatura(tempMin, tempMax);
        humedad = new Humedad(humMin, humMax);
    }

    public Temperatura getTemp() {
        return temp;
    }

    public void setTemp(Temperatura temp) {
        this.temp = temp;
    }

    public Humedad getHumedad() {
        return humedad;
    }

    public void setHumedad(Humedad humedad) {
        this.humedad = humedad;
    }

    public boolean necesitaClimatizacion() {
        return true;
    }

    

}
