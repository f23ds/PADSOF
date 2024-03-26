
import java.io.Serializable;
import java.util.*;
import Sorteo.*;
import Sala.*;
import Exposicion.*;
import Entrada.*;
import Obra.*;
import Usuario.*;
import Horario.*;
/**
 * Esta clase define el sistema que controla desde arriba todo el centro de exposiciones
 * 
 * @author Victor Sanz de Vergas
 * 
 */
public final class Sistema implements Serializable{
    private static Sistema instance; /*Singleton de la clase Sistema */
    private Collection<Entrada> entradas; /*Coleccion con las entradas vendidas por el centro */
    private Horario horario; /*Horario de apertura y cierre del centro */
    private Collection<ClienteRegistrado> clientes; /*Coleccion con los clientes registrados */
    private Collection<Empleado> empleados; /*Colleccion con los empleados registrados */
    private Gestor gestor; /*Referencia al gestor del centro */
    private Usuario usuarioActivo; /*Referencia al usuario activo en el sistema en el momento*/
    private Collection<Obra> obras; /*Obras disponibles en el centro de exposiciones */
    private Collection<Sala> salas; /*Coleccion de salas en el centro de exposiciones*/
    private Collection<Sorteo> sorteos; /*Sorteos disponibles para las exposiciones del centro*/
    private Collection<Exposicion> exposiciones; /*Exposiciones en el centro en ese momento */
    

    /**
     * GetInstance necesario para el Singleton que devuelve el atributo estatico Sistema
     * 
     * @param horario horario del centro
     * @param gestor gestor del centro
     * @param usuarioActivo usuario activo en ese momento
     * @return instancia del atributo estatico Sistema
     */
    public static Sistema getInstance(Horario horario, Gestor gestor, Usuario usuarioActivo) {
        if (instance == null) {
            instance = new Sistema(horario, gestor, usuarioActivo);
        }
        return instance;
    }

    /**
     * GetInstance para el SingleTon cuando no recibe argumentos
     * 
     * @return instancia del atributo estatico Sistema
     */
    public static Sistema getInstance() {
        if (instance == null) {
            instance = new Sistema();
        }
        return instance;
    }

    /**
     * Constructor privado de la clase Sistema con argumentos
     * 
     * @param horario horario del centro
     * @param gestor gestor del centro
     * @param usuarioActivo usuario activo en ese momento
     */
    private Sistema(Horario horario, Gestor gestor, Usuario usuarioActivo) {
        this.entradas = new ArrayList<Entrada>();
        this.horario = horario;
        this.clientes = new ArrayList<ClienteRegistrado>();
        this.empleados = new ArrayList<Empleado>();
        this.gestor = gestor;
        this.obras = new ArrayList<Obra>();
        this.salas = new ArrayList<Sala>();
        this.sorteos = new ArrayList<Sorteo>();
        this.exposiciones = new ArrayList<Exposicion>();
        this.usuarioActivo = usuarioActivo;
        
    }

    /**
     * Constructo privado sin argumentos que unicamente crea Sistema
     */
    private Sistema(){
        this.entradas = new ArrayList<Entrada>();
        this.clientes = new ArrayList<ClienteRegistrado>();
        this.empleados = new ArrayList<Empleado>();
        this.obras = new ArrayList<Obra>();
        this.salas = new ArrayList<Sala>();
        this.sorteos = new ArrayList<Sorteo>();
        this.exposiciones = new ArrayList<Exposicion>();
    }

    /**
     * Añadir entradas a la lista de entradas vendidas
     * 
     * @param entradas array de entradas para añadir
     */
    public void addEntradas(Entrada ... entradas){
        for(Entrada e: entradas){
            this.entradas.add(e);
        }
    }

    /**
     * Añadir clientes a la lista de clientes registrados
     * 
     * @param clientes array con los clientes a añadir
     */
    public void addClientes(ClienteRegistrado ... clientes){
        for(ClienteRegistrado c: clientes){
            this.clientes.add(c);
        }
    }

    /**
     * Añadir empleados a la coleccion de empleados
     * 
     * @param empleados array con los empleados a añadir
     */
    public void addEmpleados(Empleado ... empleados){
        for(Empleado e: empleados){
            this.empleados.add(e);
        }
    }

    /**
     * Añadir obras a la coleccion de obraa
     * 
     * @param obras array con las obras a añadir
     */
    public void addObras(Obra ... obras){
        for(Obra o:obras){
            this.obras.add(o);
        }
    }

    /**
     * Añadir salas a la coleccion de salas del centro
     * 
     * @param salas array con las salas a añadir
     */
    public void addSalas(Sala ... salas){
        for(Sala s: salas){
            this.salas.add(s);
        }
    }

    /**
     * Añadir sorteos a la coleccion de sorteos activos
     * 
     * @param sorteos array con sorteos a añadir
     */
    public void addSorteos(Sorteo ... sorteos){
        for(Sorteo s: sorteos){
            this.sorteos.add(s);
        }
    }

    /**
     * Añadir exposiciones a la coleccion de exposiciones
     * 
     * @param exposiciones array con las exposiciones a añadir
     */
    public void addExposiciones(Exposicion ... exposiciones){
        for(Exposicion e: exposiciones){
            this.exposiciones.add(e);
        }        
    }

    /**
     * Setter del horario del centro de exposiciones
     * 
     * @param horario horario del centro
     */
    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    /**
     * Setter del gestor del centro de exposiciones
     * 
     * @param gestor objeto referente al gestor del centro
     */
    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    /**
     * Setter del usuario activo en ese momento
     * 
     * @param usuarioActivo objeto referente al usuario activo
     */
    public void setUsuarioActivo(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
    

    /**
     * Getter del horario del centro
     * 
     * @return objeto referente al horario
     */
    public Horario getHorario() {
        return horario;
    }

    /**
     * Getter de la coleccion de clientes registrados
     * 
     * @return coleccion de clientes
     */
    public Collection<ClienteRegistrado> getClientes() {
        return clientes;
    }

    /**
     * Getter de la coleccion de empleados registrados
     * 
     * @return coleccion de empleados
     */
    public Collection<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Getter de la coleccion de empleados
     * 
     * @return objeto referente al gestor del centro
     */
    public Gestor getGestor() {
        return gestor;
    }

    /**
     * Getter del usuario activo en ese momento
     * 
     * @return objeto referente al usuario activo
     */
    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    /**
     * Getter de la coleccion de obras del centro
     * 
     * @return coleccion con las obras
     */
    public Collection<Obra> getObras() {
        return obras;
    }

    /**
     * Getter de la coleccion de salas del centro
     * 
     * @return coleccion con las salas
     */
    public Collection<Sala> getSalas() {
        return salas;
    }

    /**
     * Getter de la coleccion de los sorteos disponibles en el centro
     * 
     * @return coleccion con los sorteos
     */
    public Collection<Sorteo> getSorteos() {
        return sorteos;
    }

    /**
     * Getter de la coleccion de exposiciones en el centro
     * 
     * @return coleccion con las exposiciones
     */
    public Collection<Exposicion> getExposiciones() {
        return exposiciones;
    }

    /**
     * Getter de la coleccion de entradas vendidas en el centro
     * 
     * @return coleccion con las entradas
     */
    public Collection<Entrada> getEntradas() {
        return entradas;
    }

    /**
     * Login del cliente buscandolo en la coleccion de clientes del sistema
     * 
     * @param dni string con el dni del cliente a logear 
     * @param pwd contraseña del cliente a logear
     * @return objeto referente al cliente encontrado o null si no se encuentra
     */
    public ClienteRegistrado loginCliente(String dni, String pwd){
        for(ClienteRegistrado c: clientes){
            if(dni.equals(c.getDni()) && pwd.equals(c.getPassword())){
                return c;
            }
        }
        return null;
    }

    /**
     * Login del empleado buscandolo en la coleccion de empleados del sistema
     * 
     * @param dni string con el dni del empleado a logear 
     * @param pwd contraseña del empleado a logear
     * @return objeto referente al empleado encontrado o null si no se encuentra
     */
    public Empleado loginEmpleado(String dni, String password){
        for(Empleado e: empleados){
            if(dni.equals(e.getDni()) && password.equals(e.getPassword())){
                return e;
            }
        }
        return null;
    }

    /**
     * Login del gestor comprobando sus credenciales
     * 
     * @param dni string con el dni del gestor a logear 
     * @param pwd contraseña del gestor a logear
     * @return objeto referente al gestor o null si las credenciales no son correctas
     */
    public Gestor loginGestor(String usuario, String password){
        if(usuario.equals(gestor.getUsuario()) && password.equals(gestor.getPassword())){
            return gestor;
        }
        return null;
    }

    /**
     * Buscar las exposiciones permanentes en el centro de exposiciones
     * 
     * @return arraylist con las exposiciones permanenetes
     */
    public Collection<Exposicion> buscarPorPermanente(){
        Collection<Exposicion> permanentes = new ArrayList<Exposicion>();

        for(Exposicion e: exposiciones){
            if(e.isPermanente()){
                permanentes.add(e);
            }
        }

        return permanentes;
    }

    /**
     * Buscar las exposiciones temporales en el centro de exposiciones
     * 
     * @return arraylist con las exposiciones temporales
     */
    public Collection<Exposicion> buscarPorTemporal(){
        Collection<Exposicion> temporales = new ArrayList<>();

        for(Exposicion e: exposiciones){
            if(e.isTemporal()){
                temporales.add(e);
            }
        }

        return temporales;
    }
    
    
}
