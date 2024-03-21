package Sorteo;

import java.sql.Date;
import java.util.*;
import java.time.*;

public abstract class Sorteo {
    private int nEntradas;
    private LocalDate fInicioInscripcion; 
    private LocalDate fFinInscripcion;
    private Collection<Participante> participantes = new ArrayList<>();

    public Sorteo(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion,
            Collection<Participante> participantes) {
        this.nEntradas = nEntradas;
        this.fInicioInscripcion = fInicioInscripcion;
        this.fFinInscripcion = fFinInscripcion;
        this.participantes = participantes;
    }

    public int getnEntradas() {
        return nEntradas;
    }

    public void setnEntradas(int nEntradas) {
        this.nEntradas = nEntradas;
    }

    public LocalDate getfInicioInscripcion() {
        return fInicioInscripcion;
    }

    public void setfInicioInscripcion(LocalDate fInicioInscripcion) {
        this.fInicioInscripcion = fInicioInscripcion;
    }

    public LocalDate getfFinInscripcion() {
        return fFinInscripcion;
    }

    public void setfFinInscripcion(LocalDate fFinInscripcion) {
        this.fFinInscripcion = fFinInscripcion;
    }

    public Collection<Participante> getParticipantes() {
        return participantes;
    }

    public Status inscribirParticipante(Participante participante) {
        LocalDate fechaActual = LocalDate.now();

        if (fInicioInscripcion.isBefore(fechaActual) && fFinInscripcion.isAfter(fechaActual)) {
            this.participantes.add(participante);
            return OK;
        }

        return ERROR;      
    }

    



    




}
