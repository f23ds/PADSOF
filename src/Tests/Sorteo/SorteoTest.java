package Tests.Sorteo;

import Sorteo.*;
import Usuario.ClienteRegistrado;
import Utils.Status;
import Usuario.*;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SorteoTest {
    private Sorteo s;
    private Participante p;

    @BeforeEach
    void setUP() {
        p = new Participante(1, new ClienteRegistrado("password", "03344676R", false));
    }

    @Test
    void testInscribirParticipante() {
        s = new SorteoPlazoDado(20, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31),
                LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 1));
        assert(s.inscribirParticipante(p) == Status.ERROR);
        s = new SorteoPlazoDado(20, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31),
                LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 1));
        assert(s.inscribirParticipante(p) == Status.OK);
        
    }

    @Test
    void testSortear1() {
        s = new SorteoPlazoDado(1, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 14),
                LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 1));
        assert(s.inscribirParticipante(p) == Status.ERROR);
        assert(s.sortear() == Status.ERROR);
        s.setfFinInscripcion(LocalDate.of(2024, 12, 31));
        assert(s.inscribirParticipante(p) == Status.OK);
        assert(s.sortear() == Status.OK);
        for (Notificacion noti : p.getCliente().getNotificaciones()) {
            assert(s.getCodigos().contains(UUID.fromString(noti.getCuerpo())));
        }

    }

    @Test
    void testSortear2() {
        p = new Participante(2, new ClienteRegistrado("password", "03344676R", false));
        s = new SorteoPlazoDado(2, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 14),
                LocalDate.of(2025, 1, 1), LocalDate.of(2025, 12, 1));
        assert(s.inscribirParticipante(p) == Status.ERROR);
        assert(s.sortear() == Status.ERROR);
        s.setfFinInscripcion(LocalDate.of(2024, 12, 31));
        assert(s.inscribirParticipante(p) == Status.OK);
        assert(s.sortear() == Status.OK);
        assert(s.getCodigos().size() == 2);
        for (Notificacion noti : p.getCliente().getNotificaciones()) {
            assert(s.getCodigos().contains(UUID.fromString(noti.getCuerpo())));
        }

    }
}
