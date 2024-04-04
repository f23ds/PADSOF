package Tests.Sorteo;

import Sorteo.*;
import Usuario.ClienteRegistrado;
import Entrada.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SorteoPlazoDadoTest {
    private Sorteo s;
    private UUID codigo;
    private ClienteRegistrado cliente;

    @BeforeEach
    void setUP() {
        s = new SorteoPlazoDado(20, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31),
                LocalDate.of(2021, 1, 1), LocalDate.of(2021, 12, 1));
        codigo = UUID.randomUUID();
        s.getCodigos().add(codigo);
        cliente = new ClienteRegistrado("password", "03344676R", false);
    }

    @Test
    void testValidarEntrada1() {
        Comprada e = new Comprada(1, 20.0, LocalDate.of(2020, 2, 14), LocalDate.of(2021, 1, 14), LocalTime.of(10, 0, 0), null, cliente);

        assert(s.validarEntrada(e, codigo));
        assert(!s.validarEntrada(e, UUID.randomUUID()));
    }

    @Test
    void testValidarEntrada2() {
        Comprada e = new Comprada(3, 20.0, LocalDate.of(2020, 2, 14), LocalDate.of(2021, 1, 24), LocalTime.of(10, 0, 0), null, cliente);

        assert(!s.validarEntrada(e, codigo));
    }

    @Test
    void testValidarEntrada3() {
        Comprada e = new Comprada(1, 20.0, LocalDate.of(2020, 2, 14), LocalDate.of(2022, 2, 14), LocalTime.of(10, 0, 0), null, cliente);

        assert(!s.validarEntrada(e, codigo));
    }
}
