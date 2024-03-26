package Sorteo;

import Utils.*;
import Entrada.*;

import java.util.*;
import java.time.*;

public class SorteoFechaHora extends Sorteo {
    private LocalDate fecha;
    private LocalTime hora;

    public SorteoFechaHora(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion, LocalDate fecha, LocalTime hora) {
        super(nEntradas, fInicioInscripcion, fFinInscripcion);
        this.fecha = fecha;
        this.hora = hora;
    }

    public boolean validarEntrada(Comprada entrada, UUID codigo) {

        if (!this.getCodigos().contains(codigo)) {
            return false;
        }

        if (entrada.getFecha() != fecha) {
            return false;
        }

        if (entrada.getHora() != hora) {
            return false;
        }

        return true;

    }

}
