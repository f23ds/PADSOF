package Sorteo;

import java.time.*;
import java.util.Collection;

public class SorteoPlazoDado extends Sorteo {
    private LocalDate fInicio;
    private LocalDate fFinal;
    
    public SorteoPlazoDado(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion,
            Collection<Participante> participantes, LocalDate fInicio, LocalDate fFinal) {
        super(nEntradas, fInicioInscripcion, fFinInscripcion, participantes);
        this.fInicio = fInicio;
        this.fFinal = fFinal;
    }

    
    
}
