package Sorteo;

import java.time.*;
import java.util.Collection;
import java.util.UUID;

import Entrada.Comprada;

public class SorteoPlazoDado extends Sorteo {
    private LocalDate fInicio;
    private LocalDate fFinal;
    
    public SorteoPlazoDado(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion,
            Collection<Participante> participantes, LocalDate fInicio, LocalDate fFinal) {
        super(nEntradas, fInicioInscripcion, fFinInscripcion);
        this.fInicio = fInicio;
        this.fFinal = fFinal;
    }

    public boolean validarEntrada(Comprada entrada, UUID codigo) {

        if (!this.getCodigos().contains(codigo)) {
            return false;
        }

        if (!fInicio.isBefore(entrada.getFecha())) {
            return false;
        }

        if (!fFinal.isAfter(entrada.getFecha())) {
            return false;
        }

        return true;

    }

    
    
}
