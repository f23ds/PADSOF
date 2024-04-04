package Tests.Usuario;

import Usuario.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class ClienteRegistradoTest {
    private ClienteRegistrado c;

    @BeforeEach
    void setUP() {
        c = new ClienteRegistrado("HolaMundo1234", "56785685I", true);

        assert(c != null);
    }

    @Test
    void testGetPassword(){
        assertEquals(c.getPassword(), "HolaMundo1234");
    }

    @Test
    void testGetDni(){
        assertEquals(c.getDni(), "56785685I");
    }

    @Test
    void testSetPassword(){
        c.setPassword("PepeLiron89");
        assertEquals(c.getPassword(), "PepeLiron89");
    }

    @Test
    void testSetDni(){
        c.setDni("63724855Z");
        assertEquals(c.getDni(), "63724855Z");
    }

    void testañadirNotificaciones(){
        Collection<Notificacion> notificaciones = new ArrayList<Notificacion>();

        Notificacion n1 = new Notificacion(null, "Hola que pasa");
        Notificacion n2 = new Notificacion(null, "Que tal estas");
        notificaciones.add(n1);
        notificaciones.add(n2);

        c.addNotificaciones(n1);
        c.addNotificaciones(n2);

        assertEquals(c.getNotificaciones(), notificaciones);
    }

}