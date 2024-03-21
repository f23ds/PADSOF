package Sorteo;

import java.time.*;
import java.util.Collection;

public class SorteoFechaHora extends Sorteo {
    private LocalDate fecha;
    private LocalTime hora;

    public SorteoFechaHora(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion,
            Collection<Participante> participantes, LocalDate fecha, LocalTime hora) {
        super(nEntradas, fInicioInscripcion, fFinInscripcion, participantes);
        this.fecha = fecha;
        this.hora = hora;
    }

}
