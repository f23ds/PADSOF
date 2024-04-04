package Tests.Obra;

import Obra.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exposicion.TipoDeObra;

import static org.junit.jupiter.api.Assertions.*;
import Utils.Dimensiones;

public class EsculturaTest {
    private Escultura es;

    @BeforeEach
    void setUP() {
        es = new Escultura("Elogio de la luz xvi", "Eduardo Chillida", 1971, false, "SEG018940", 100000, "Obra escultural que fusiona la solidez del material con la presencia de la luz.","Alabastro", new Dimensiones(19, 37, 30), null, null);
    }

    @Test
    void testCargarEsculturaDeFichero() {
        String obra = "ESCULTURA;EXTERNA;Elogio de la luz xvi;Eduardo Chillida;1971;Obra escultural que fusiona la solidez del material con la presencia de la luz.;100000;SEG018940;;Alabastro;;;;19;37;30;;";

        Escultura es_aux = Escultura.cargarEsculturaDeFichero(obra.split(";", -1));

        assertEquals(es_aux.getMaterial(), "Alabastro");

        assert(es_aux.getTipoObra() == TipoDeObra.ESCULTURA);
    }

    @Test
    void testGetMaterial() {
        assertEquals(es.getMaterial(), "Alabastro");
    }

    @Test
    void testGetTipoObra() {
        assert(es.getTipoObra() == TipoDeObra.ESCULTURA);
    }

    @Test
    void testSetMaterial() {
        es.setMaterial("Diamante");
        assertEquals(es.getMaterial(), "Diamante");

    }
}
