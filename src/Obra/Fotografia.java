package Obra;

import Utils.*;

public class Fotografia extends ObraClimatizada {
    private TipoFotografia tipo;
    private Temperatura temp;
    private Humedad hum;

    public Fotografia(String nombre, String autor, int anio, boolean propia, String poliza, TipoFotografia tipo,
            float ancho, float largo, float alto, float tempMin, float tempMax, float humMin, float humMax) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto, tempMin, tempMax, humMin, humMax);

        this.tipo = tipo;
        this.temp = new Temperatura(tempMin, tempMax);
        this.hum = new Humedad(humMin, humMax);
    }

    public Fotografia(String nombre, String autor, int anio, boolean propia, String poliza, TipoFotografia tipo,
            Dimensiones dim, Temperatura temp, Humedad hum) {
        super(nombre, autor, anio, propia, poliza, dim, temp, hum);

        this.tipo = tipo;
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

    public TipoFotografia getTipo() {
        return tipo;
    }

    public void setTipo(TipoFotografia tipo) {
        this.tipo = tipo;
    }
}
