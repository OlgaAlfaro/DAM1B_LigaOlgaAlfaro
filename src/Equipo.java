import java.util.Arrays;
import java.util.Objects;

public class Equipo {
    private final int numMaxJugadores = 22;

    private String nombre;
    private String ciudad;
    public Jugador[] listaJugadores;

    //Método constructor de la clase Equipo
    public Equipo(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
        listaJugadores = new Jugador[numMaxJugadores];
    }

    //Metodos getters para acceder a los atributos Nombre y Ciudad
    public String getNombre(){
        return nombre;
    }

    public String getCiudad(){
        return ciudad;
    }

    //Este método devuelve el numero de jugadores que hay en el equipo
    public int getNumJugadores(){
        int contador = 0;
        for(int i = 0; i<listaJugadores.length; i++){
            if(listaJugadores[i] != null){
                contador++;
            }
        }
        return contador;
    }

    //Metodo que muestra en pantalla cada jugador del equipo con todos los atributos de cada uno.
    //Si el nombre es largo, se muestra solo los primeros caracteres para abreviar y que no ocupe demasiado
    public void mostrarListaJugadores(){
        System.out.println("NOMBRE\t\t\t" + "POSICIÓN\t\t" + "EDAD\t\t" + "NACIONALIDAD\t\t" + "LESIONADO\t\t");
        for(int i = 0; i < getNumJugadores(); i++){
            System.out.println(String.format("%.10s", listaJugadores[i].getNombre()) + String.format("%12s", listaJugadores[i].getPosicion()) + String.format("%13d", listaJugadores[i].getEdad()) + String.format("%20s", listaJugadores[i].getNacionalidad()) + String.format("%17s", listaJugadores[i].getLesionado()));
        }
    }

    //Introduce el jugador del parametro en el equipo, en la primera posición vacía del array listaJugadores.
    public void adquirirJugador(Jugador jugador){
            listaJugadores[getNumJugadores()] = jugador;
    }

    //Elimina el jugador escogido con el método borrar, quitándolo del equipo y moviendo  el resto de los jugadores a la izquierda,
    //para que no quede ninguna posición vacía en medio del array.
    public void venderJugador(String nombreJugador){
        for(int i = 0; i <= getNumJugadores(); i++){
            if(Objects.equals(listaJugadores[i].getNombre(), nombreJugador)){
                borrar(i);
            }
        }
    }

    //Metodo que borra un elemento de un array moviendo los demas de su derecha a la izquierda.
    private void borrar(int posicion){
        if (posicion >= 0 && posicion < getNumJugadores()) {
            for (int i = posicion + 1; i <= getNumJugadores(); i++) {
                listaJugadores[i - 1] = listaJugadores[i];
            }

        }

    }

    //Metodo que facilita la búsqueda de un jugador, evitando utilizar codigo extenso en el main en venderJugador.
    public Jugador getJugador(String nomJugador){
        Jugador miJugador = listaJugadores[0];
        for(int i = 0; i < getNumJugadores(); i++){
            if(Objects.equals(listaJugadores[i].getNombre(), nomJugador)){
                miJugador = listaJugadores[i];
            }
        }
        return miJugador;
    }
}
