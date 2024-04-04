package Tests.Obra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exposicion.TipoDeObra;
import Obra.Pintura;
import Utils.Dimensiones;

public class PinturaTest {
    private Pintura p;

    @BeforeEach
    void setUP() {
        p = new Pintura("Elogio de la luz xvi", "Eduardo Chillida", 1971, true, "SEG018940", 100000, "Obra escultural que fusiona la solidez del material con la presencia de la luz.", "Oleo sobre tela", new Dimensiones(19, 37, 30), null, null);
    
        assert(p != null);

    }

    @Test
    void testCargarEsculturaDeFichero() {
        String obra = "CUADRO;EXTERNA;El beso;Gustav Klimt;1908;La obra representa dos amantes, y pertenece al periodo dorado de Klimt.;300000;SEG988976;Oleo sobre tela;;;;;180;180;;0--20;40--65";

        Pintura p_aux = Pintura.cargarPinturaDeFichero(obra.split(";", -1));

        assertEquals(p_aux.getTecnica(), "Oleo sobre tela");

        assert(p_aux.getTipoObra() == TipoDeObra.PINTURA);
    }

    @Test
    void testGetTecnica() {
        assertEquals(p.getTecnica(), "Oleo sobre tela");

    }

    @Test
    void testGetTipoObra() {
        assert(p.getTipoObra() == TipoDeObra.PINTURA);
    }

    @Test
    void testSetTecnica() {
        p.setTecnica("Diamante");
        assertEquals(p.getTecnica(), "Diamante");
    }
}
