package Obra;

public class Fotografia extends Obra {
    private TipoFotografia tipo;
    private Temperatura temp;
    private Humedad hum;

    public Fotografia(String nombre, String autor, int anio, boolean propia, String poliza, TipoFotografia tipo,
            float ancho, float largo, float alto, float tempMin, float tempMax, float humMin, float humMax) {
        super(nombre, autor, anio, propia, poliza, ancho, largo, alto);

        this.tipo = tipo;
        this.temp = Temperatura(tempMin, tempMax);
        this.hum = Humedad(humMin, humMax);
    }

    public Fotografia(String nombre, String autor, int anio, boolean propia, String poliza, TipoFotografia tipo,
            Dimensiones dim, Temperatura temp, Humedad hum) {
        super(nombre, autor, anio, propia, poliza, dim);

        this.tipo = tipo;
        this.temp = temp;
        this.hum = hum;
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
