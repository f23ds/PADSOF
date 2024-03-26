package Sorteo;

import java.util.*;

import Entrada.Comprada;

import java.io.Serializable;
import java.time.*;

import Utils.*;

public abstract class Sorteo implements Serializable{
    private int nEntradas;
    private LocalDate fInicioInscripcion; 
    private LocalDate fFinInscripcion;
    private List<Participante> participantes;
    private EstadosSorteo estado; 
    private List<UUID> codigos; // generado con uuid.randomUUID();

    public Sorteo(int nEntradas, LocalDate fInicioInscripcion, LocalDate fFinInscripcion) {
        this.nEntradas = nEntradas;
        this.fInicioInscripcion = fInicioInscripcion;
        this.fFinInscripcion = fFinInscripcion;
        estado = EstadosSorteo.ACTIVO;
        participantes = new ArrayList<Participante>();
        codigos = new ArrayList<>();
    }

    public int getnEntradas() {
        return nEntradas;
    }

    public void setnEntradas(int nEntradas) {
        this.nEntradas = nEntradas;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public EstadosSorteo getEstado() {
        return estado;
    }

    public void setEstado(EstadosSorteo estado) {
        this.estado = estado;
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
            return Status.OK;
        }

        if (estado == EstadosSorteo.FINALIZADO) {
            return Status.ERROR;
        }

        participantes.add(participante);

        return Status.OK;      
    }

    public Status sortear() {
        if (estado == EstadosSorteo.FINALIZADO) 
            return Status.ERROR;

        Random random = new Random();
        int nEntradas = this.nEntradas;

        while (nEntradas > 0) {
            int numeroAleatorio = random.nextInt(participantes.size());

            Participante ganador = participantes.get(numeroAleatorio);

            int ents_participante = ganador.getNumEntradas();

            while (nEntradas > 0 && ents_participante > 0) {
                nEntradas -= 1;
                ents_participante -= 1;
                
                codigos.add(UUID.randomUUID());

                /*notificar ganador */
            }            
        }

        this.estado = EstadosSorteo.FINALIZADO;

        return Status.OK;
    }

    /**
     * Valida la entrada para un codigo de sorteo concreto. 
     * @param entrada entrada que se quiere comprar
     * @param codigo codigo del sorteo
     * @return true si es válida, false en caso contrario
     */
    public abstract boolean validarEntrada(Comprada entrada, UUID codigo);

    public List<UUID> getCodigos() {
        return codigos;
    }


    




}
