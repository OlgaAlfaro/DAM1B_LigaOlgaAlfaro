import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner teclado = new Scanner(System.in);
    static Liga miLiga;
    public static void main(String[] args) {
        System.out.println("Empiece creando una liga:");
        System.out.println("Inserte el país de la liga:");
        String nomPais = teclado.nextLine();
        miLiga = new Liga(nomPais);
        int opcion = menu();
        while(opcion <1 || opcion > 6){
            System.out.println("Opcion incorrecta\n" +
                    "Teclear opcion: ");
            opcion = teclado.nextInt();
        }
        while(opcion != 6){
            switch(opcion){
                case 1: insertarEquipo();
                    break;
                case 2: insertarJugador();
                    break;
                case 3: verLiga();
                    break;
                case 4: verJugadores();
                    break;
                case 5: venderJugador();
                    break;
            }
            opcion = menu();
        }
    }

    public static int menu(){
        System.out.println("\nMENU DE LA LIGA\n" +
                "1- Insertar Equipo\n" +
                "2- Insertar Jugador\n" +
                "3- Ver equipos de la liga\n" +
                "4- Ver jugadores de un equipo\n" +
                "5- Vender jugador\n" +
                "6- Salir\n");
        int opcion = teclado.nextInt();
        return opcion;
    }
    public static void insertarEquipo(){
        System.out.println("Inserte el nombre del equipo:");
        String nomEquipo = teclado.next();

        System.out.println("Inserte la ciudad del equipo:");
        String nomCiudad = teclado.next();

        Equipo miEquipo = new Equipo(nomEquipo, nomCiudad);
        if (miLiga.listadoEquipos[19] != null) {
            System.out.println("La liga está llena.");

        }
        else{
            miLiga.anadirEquipo(miEquipo);
            System.out.println("Creando equipo...\n" +
                    "Insertando equipo...\n" +
                    "Equipo " + nomEquipo + " insertado");
        }

    }

    public static void insertarJugador(){
        System.out.println("Indique el nombre del equipo donde quiere insertar el jugador:");
        String nomEquipo = teclado.next();
        if(miLiga.getEquipo(nomEquipo).getNombre() != nomEquipo){
            System.out.println("El equipo indicado no existe.");
            System.out.println("Introduce otro equipo:");
            nomEquipo = teclado.next();
        }
        System.out.println("Indique el nombre del jugador:");
        String nomJugador = teclado.next();

        System.out.println("Indique la nacionalidad del jugador:");
        String nomPais = teclado.next();

        System.out.println("Indique la edad del jugador:");
        int numEdad = teclado.nextInt();

        System.out.println("Indique la posicion del jugador:");
        String nomPosicion = teclado.next();
        Jugador miJugador = new Jugador(nomJugador, nomPais, numEdad, nomPosicion);
        if(miLiga.getEquipo(nomEquipo).listaJugadores[21] != null){
            System.out.println("El equipo está lleno.");
        }

        else{
            (miLiga.getEquipo(nomEquipo)).adquirirJugador(miJugador);
            System.out.println("Creando jugador...\n" +
                    "Insertando jugador...\n" +
                    "Jugador " + nomJugador + " insertado en " + nomEquipo);

        }

    }

    public static void verLiga(){
        System.out.println("**********COMPOSICIÓN DE LA LIGA**********");
        miLiga.mostrarListadoEquipos();
        System.out.println("******************************************");
    }

    public static void verJugadores(){
        System.out.println("Indique el equipo que quiere visualizar:");
        String nomEquipo = teclado.next();
            System.out.println("**********" + nomEquipo + "***************");
            miLiga.getEquipo(nomEquipo).mostrarListaJugadores();
            System.out.println("******************************************");

    }


    public static void venderJugador(){
        System.out.println("Inserte el nombre del equipo donde quiere vender el jugador:");
        String nomEquipo = teclado.next();
        System.out.println("Inserte el nombre del jugador:");
        String nomJugador = teclado.next();
        if(miLiga.listadoEquipos[miLiga.getNumEquipos() - 1].getNombre() != nomEquipo){
            System.out.println("El equipo indicado no existe.");
        }
        else if(miLiga.getEquipo(nomEquipo).listaJugadores[miLiga.getEquipo(nomEquipo).getNumJugadores() - 1].getNombre() != nomJugador){
            System.out.println("El jugador no existe.");
        }
       else{
           miLiga.getEquipo(nomEquipo).venderJugador(nomJugador);
           System.out.println("Vendiendo jugador...\n" +
                    "Jugador vendido.");
       }

    }
}