package Tests.Obra;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Obra.ObraClimatizada;
import Obra.Pintura;
import Utils.Dimensiones;
import Utils.Humedad;
import Utils.Temperatura;

public class ObraClimatizadaTest {

    private ObraClimatizada o;

    @BeforeEach
    void setUP() {
        o = new Pintura("Elogio de la luz xvi", "Eduardo Chillida", 1971, true, "SEG018940", 100000, "Obra escultural que fusiona la solidez del material con la presencia de la luz.", "Oleo sobre tela", new Dimensiones(19, 37, 30), new Temperatura(0, 20), new Humedad(40, 65));
    
        assert(o != null);
    }

    @Test
    void testCargarObraClimatizadaDeFichero() {
        String obra = "CUADRO;EXTERNA;El beso;Gustav Klimt;1908;La obra representa dos amantes, y pertenece al periodo dorado de Klimt.;300000;SEG988976;Oleo sobre tela;;;;;180;180;;0--20;40--65";

        Pintura es_aux = Pintura.cargarPinturaDeFichero(obra.split(";", -1));

        assertEquals(es_aux.getTemp().getMin(), 0);
        assertEquals(es_aux.getHumedad().getMin(), 40);
        assertEquals(es_aux.getTemp().getMax(), 20);
        assertEquals(es_aux.getHumedad().getMax(), 65);
    }

    @Test
    void testGetHumedad() {
        assert(o.getHumedad() != null);
    }

    @Test
    void testGetTemp() {
        assert(o.getTemp() != null);
    }

    @Test
    void testNecesitaClimatizacion() {
        assert(o.necesitaClimatizacion());
    }

    @Test
    void testSetHumedad() {
        o.setHumedad(null);
        assert(o.getHumedad() == null);
    }

    @Test
    void testSetTemp() {
        o.setTemp(null);
        assert(o.getTemp() == null);

    }
}
