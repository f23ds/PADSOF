package Sorteo;

import Usuario.ClienteRegistrado;

public class Participante {
    private int numEntradas;
    private ClienteRegistrado cliente;

    public Participante(int numEntradas) {
        if (numEntradas != 1 && numEntradas != 2) {
            
        }
        this.numEntradas = numEntradas;
    }

    public ClienteRegistrado getCliente() {
        return cliente;
    }

    public int getNumEntradas() {
        return numEntradas;
    }

    public void setNumEntradas(int numEntradas) {
        this.numEntradas = numEntradas;
    }

}
