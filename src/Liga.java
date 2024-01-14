import java.util.Objects;

public class Liga {
    private final int numMaxEquipos = 20;

    private String pais;
    public Equipo[] listadoEquipos;

    //Constructor de la clase Liga
    public Liga(String pais){
        this.pais = pais;
        listadoEquipos = new Equipo[numMaxEquipos];
    }

    //Muestra en pantalla todos los equipos de la Liga con su ciudad y el numero de jugadores de cada uno.
    public void mostrarListadoEquipos(){
        System.out.println("EQUIPO\t\t\t\t" + "CIUDAD\t\t\t" + "NUMERO JUGADORES");
        for(int i = 0; i < getNumEquipos(); i++){
            if(listadoEquipos[i] != null){
                System.out.println(listadoEquipos[i].getNombre() + "\t\t\t" + listadoEquipos[i].getCiudad() + "\t\t\t\t" + listadoEquipos[i].getNumJugadores());
            }
        }
    }

    //Metodo que devuelve el numero de Equipos que hay en la Liga
    public int getNumEquipos(){
        int contador = 0;
        for(int i = 0; i<listadoEquipos.length; i++){
            if(listadoEquipos[i] != null){
                contador++;
            }
        }
        return contador;
    }

    //Devuelve un objeto Equipo, del equipo de la Liga que coincide con el nombre introducido en el parámetro.
    public Equipo getEquipo(String nombreEquipo){
        Equipo miEquipo = listadoEquipos[0];
        for(int i = 0; i < getNumEquipos(); i++){
            if(Objects.equals(listadoEquipos[i].getNombre(), nombreEquipo)){
                miEquipo = listadoEquipos[i];
            }
        }
        return miEquipo;
    }

    //Metodo getter para acceder al Pais de la Liga.
    public String getPais(){
        return pais;
    }

    //Añade el equipo del parametro en la primera posición vacia del array listadoEquipos.
    public void anadirEquipo(Equipo equipo){
            listadoEquipos[getNumEquipos()] = equipo;
    }

}
