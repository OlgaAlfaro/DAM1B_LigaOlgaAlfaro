public class Liga {
    private final int numMaxEquipos = 20;

    private String pais;
    private Equipo[] listadoEquipos;

    public Liga(String pais){
        this.pais = pais;
        listadoEquipos = new Equipo[20];
    }

    public void mostrarListadoEquipos(){
        System.out.println("EQUIPO\t" + "CIUDAD\t" + "NUMERO JUGADORES");
        for(int i = 0; i < getNumEquipos(); i++){
            if(listadoEquipos[i] != null){
                System.out.println(listadoEquipos[i].getNombre() + "\t" + listadoEquipos[i].getCiudad() + "\t" + listadoEquipos[i].getNumJugadores());
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
        if(listadoEquipos[getNumEquipos()] == null){
            listadoEquipos[getNumEquipos()] = equipo;
        }
        else{
            System.out.println("La liga está llena");
        }

    }

}
