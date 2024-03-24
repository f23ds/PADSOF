package Sorteo;

import java.time.LocalDate;
import java.util.*;

import Entrada.Comprada;

public class SorteoMientrasDureExp extends Sorteo{

    public SorteoMientrasDureExp(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion) {
        super(nEntradas, fInicioInscripcion, fFinInscripcion);
    }

    public boolean validarEntrada(Comprada entrada, UUID codigo) {
        return this.getCodigos().contains(codigo);
    }
    
}
