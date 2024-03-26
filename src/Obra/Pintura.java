package Obra;

import Utils.*;

public class Pintura extends ObraClimatizada{
    private String tecnica;
    private Temperatura temp;
    private Humedad hum;

    public Pintura(String nombre, String autor, int anio, boolean propia, String poliza, String tecnica, float ancho,
            float largo, float alto, float tempMin, float tempMax, float humMin, float humMax) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto, tempMin, tempMax, humMin, humMax);

        this.tecnica = tecnica;
        this.temp = new Temperatura(tempMin, tempMax);
        this.hum = new Humedad(humMin, humMax);

    }

    public Pintura(String nombre, String autor, int anio, boolean propia, String poliza, String tecnica,
            Dimensiones dim, Temperatura temp, Humedad hum) {
        super(nombre, autor, anio, propia, poliza, dim, temp, hum);
        
        this.tecnica = tecnica;
        this.temp = temp;
        this.hum = hum;
    }

    public boolean necesitaHumedad() {
        if (temp == null) {
            return false;
        }
        return true;
    }

    public boolean necesitaTemperatura() {
        if (temp == null) {
            return false;
        }
        return true;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
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
