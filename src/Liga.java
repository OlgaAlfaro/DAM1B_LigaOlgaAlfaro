public class Liga {
    private final int numMaxEquipos = 20;

    private String pais;
    public Equipo[] listadoEquipos;

    public Liga(String pais){
        this.pais = pais;
        listadoEquipos = new Equipo[numMaxEquipos];
    }

    public void mostrarListadoEquipos(){
        System.out.println("EQUIPO\t\t" + "CIUDAD\t\t" + "NUMERO JUGADORES");
        for(int i = 0; i < getNumEquipos(); i++){
            if(listadoEquipos[i] != null){
                System.out.println(listadoEquipos[i].getNombre() + "\t\t" + listadoEquipos[i].getCiudad() + "\t\t" + listadoEquipos[i].getNumJugadores());
            }
        }
    }

    public int getNumEquipos(){
        int contador = 0;
        for(int i = 0; i<listadoEquipos.length; i++){
            if(listadoEquipos[i] != null){
                contador++;
            }
        }
        return contador;
    }

    public Equipo getEquipo(String nombreEquipo){
        Equipo miEquipo = listadoEquipos[0];
        for(int i = 0; i < getNumEquipos(); i++){
            if(listadoEquipos[i].getNombre() == nombreEquipo){
                miEquipo = listadoEquipos[i];
            }
        }
        return miEquipo;
    }

    public String getPais(){
        return pais;
    }

    public void anadirEquipo(Equipo equipo){
            listadoEquipos[getNumEquipos()] = equipo;
    }

}
