import java.util.Arrays;
import java.util.Objects;

public class Equipo {
    private final int numMaxJugadores = 22;

    private String nombre;
    private String ciudad;
    public Jugador[] listaJugadores;

    public Equipo(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
        listaJugadores = new Jugador[numMaxJugadores];
    }

    public String getNombre(){
        return nombre;
    }

    public String getCiudad(){
        return ciudad;
    }

    public int getNumJugadores(){
        int contador = 0;
        for(int i = 0; i<listaJugadores.length; i++){
            if(listaJugadores[i] != null){
                contador++;
            }
        }
        return contador;
    }

    public void mostrarListaJugadores(){
        System.out.println("NOMBRE\t" + "POSICIÓN\t" + "EDAD\t" + "NACIONALIDAD\t" + "LESIONADO\t");
        for(int i = 0; i < getNumJugadores(); i++){
            System.out.println(listaJugadores[i].getNombre() + "\t\t" + listaJugadores[i].getPosicion() + "\t\t" + listaJugadores[i].getEdad() + "\t\t" + listaJugadores[i].getNacionalidad() + "\t\t" + listaJugadores[i].getLesionado());
        }
    }

    public void adquirirJugador(Jugador jugador){
            listaJugadores[getNumJugadores()] = jugador;
    }

    public void venderJugador(String nombreJugador){
        for(int i = 0; i <= getNumJugadores(); i++){
            if(Objects.equals(listaJugadores[i].getNombre(), nombreJugador)){
                borrar(i);
            }
        }
    }

    private void borrar(int posicion){
        if (posicion >= 0 && posicion < getNumJugadores()) {
            for (int i = posicion + 1; i <= getNumJugadores(); i++) {
                listaJugadores[i - 1] = listaJugadores[i];
            }

        }

    }

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
