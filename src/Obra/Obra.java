package Obra;

import java.io.Serializable;

import Exposicion.Exposicion;
import Sala.Sala;
import Sala.SalaClimatizada;
import Utils.*;
/**
 * Esta clase engloba los diferentes tipos de los que puede ser una obra.
 */
public abstract class Obra implements Serializable{

    public String nombre;
    public String autor;
    public int anio;
    public boolean propia;
    public String poliza;
    public EstadosObra estado;
    public Dimensiones dim;
    public Exposicion exposicion;

    /**
     * Constructor de la clase Obra con las dimensiones como parámetros
     * 
     * @param nombre nombre de la obra
     * @param autor autor de la obra
     * @param anio año de realización
     * @param propia obra prestada o propia
     * @param poliza poliza de seguro
     * @param ancho ancho de la obra
     * @param largo largo de la obra
     * @param alto alto de la obra
     */
    public Obra(String nombre, String autor, int anio, boolean propia, String poliza, float ancho, float largo, float alto) {
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
        this.propia = propia;
        this.poliza = poliza;
        this.estado = EstadosObra.ALMACEN;
        dim = new Dimensiones(ancho, largo, alto);
    }

    /**
     * Constructor de la clase obra con las dimensiones como objeto
     * 
     * @param nombre nombre de la obra
     * @param autor autor de la obra
     * @param anio año de realización
     * @param propia obra prestada o propia
     * @param poliza poliza de seguro
     * @param dim dimensiones de la obra
     */
    public Obra(String nombre, String autor, int anio, boolean propia, String poliza, Dimensiones dim) {
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
        this.propia = propia;
        this.poliza = poliza;
        this.dim = dim;
    }


    /**
     * Getter del atributo nombre
     * 
     * @return nombre de la obra
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atributo nombre
     * 
     * @param nombre nuevo nombre de la obra
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo autor
     * 
     * @return autor de la obra
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Setter del atributo autor
     * 
     * @param autor autor de la obra
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Getter del atributo anio
     * 
     * @return año de realización
     */
    public int getAnio() {
        return anio;
    }
    
    /**
     * Setter del atributo anio
     * 
     * @param anio año de realización
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    /**
     * Getter del atributo propia
     * 
     * @return true si es propia, false si no
     */
    public boolean isPropia() {
        return propia;
    }
    
    /**
     * Setter del atributo propia
     * 
     * @param propia boolean 
     */
    public void setPropia(boolean propia) {
        this.propia = propia;
    }
    
    /**
     * Getter de la poliza de seguro
     * 
     * @return poliza de seguro
     */
    public String getPoliza() {
        return poliza;
    }
    
    /**
     * Setter del atributo poliza
     * 
     * @param poliza poliza de seguro
     */
    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public abstract boolean necesitaClimatizacion();

    public boolean exponer(Exposicion exposicion) {
        boolean status = false;

        if (estado != EstadosObra.ALMACEN) {
            return false;
        }

        if (exposicion.isTemporal()) {
            if (!propia) {
                return false;
            }
        }

        for (Sala s : exposicion.getSalas()) {
            if (s.getDimensiones().checkDimensiones(dim)) {
                if (this.necesitaClimatizacion()){
                    if (!s.isClimatizada())
                        continue;
                    ObraClimatizada obra = (ObraClimatizada) this;
                    SalaClimatizada sala = (SalaClimatizada) s;

                    if (obra.getTemp() != null) {
                        if (!sala.getTemperatura().checkTemperatura(obra.getTemp()))
                            continue;
                    }

                    if (obra.getHumedad() != null) {
                        if (!sala.getHumedad().checkHumedad(obra.getHumedad()))
                            continue;
                    }

                    exposicion.addObras(this);

                    status = true;

                }
            }
        }

        return status;

    }

    public Status retirar() {
        if (estado != EstadosObra.EXPOSICION)
            return Status.ERROR;

        this.exposicion.removeObras(this);

        this.exposicion = null;

        estado = EstadosObra.RETIRADA;

        return Status.OK;
    }

    public Status almacenar() {
        if (estado != EstadosObra.RETIRADA)
            return Status.ERROR;

        estado = EstadosObra.ALMACEN;

        return Status.OK;
    }

    public Status restaurar() {
        if (estado != EstadosObra.ALMACEN || !propia)
            return Status.ERROR;

        estado = EstadosObra.ENRESTAURACION;

        return Status.OK;
    }

    public Status prestar() {
        if (estado != EstadosObra.RETIRADA && estado != EstadosObra.ALMACEN && !propia)
            return Status.ERROR;

        estado = EstadosObra.PRESTADA;

        return Status.OK;
    }
}
