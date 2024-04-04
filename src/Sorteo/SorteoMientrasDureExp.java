package Sorteo;

import java.time.LocalDate;
import java.util.*;

import Entrada.Comprada;

/**
 * Esta clase implementa el sorteo valido siempre que la exposicion este disponible
 * 
 * @author Ignacio Sánchez
 */
public class SorteoMientrasDureExp extends Sorteo {
    
    // Constructor

    /**
     * Constructor de la clase SorteoMientrasDureExp.
     * @param nEntradas Número de entradas para el sorteo.
     * @param fInicioInscripcion Fecha de inicio de la inscripción.
     * @param fFinInscripcion Fecha de fin de la inscripción.
     */
    public SorteoMientrasDureExp(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion) {
        super(nEntradas, fInicioInscripcion, fFinInscripcion);
    }

    // Métodos
    
    /**
     * Obtiene el tipo de sorteo.
     * @return Tipo de sorteo (MIENTRAS_DURE_EXP).
     */
    public TipoSorteo getTipoSorteo() {
        return TipoSorteo.MIENTRAS_DURE_EXP;
    }

    /**
     * Valida una entrada para el sorteo.
     * @param entrada Entrada a validar.
     * @param codigo Código de sorteo.
     * @return true si la entrada es válida, false en caso contrario.
     */
    public boolean validarEntrada(Comprada entrada, UUID codigo) {
        // Solo se puede comprar una entrada con un código de sorteo
        if (entrada.getNumEntradas() > 1) return false;

        // Verifica si el código de sorteo está en la lista de códigos generados
        return this.getCodigos().contains(codigo);
    }
}
