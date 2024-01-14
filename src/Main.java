import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static Scanner teclado = new Scanner(System.in);

    static Liga miLiga;

    //Metodo main que inicia el programa, pide que se introduzca el pais de la liga, y muestra el menu.
    //Según la opcion seleccionada ejecuta el método correspondiente. Tras ejecutarse el método, vuelve al menú.
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

    //Muestra en pantalla el menu y devuelve la opcion introducida en el teclado.
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

    //Pide que introduzca en el teclado los datos del equipo ha introducir, y si no está llena la Liga lo añade.
    public static void insertarEquipo(){
        teclado.useDelimiter("\n");
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

    //Pide los datos del jugador y el Equipo al que introducirlo. Si el equipo no existe, pide que introduzca otro, hasta que sea correcto.
    // La posicion tiene que ser una de las 4 posibles(POR, DEF, CTC, DEL).
    // Despues comprueba si el equipo esta lleno, y si no lo está añade el jugador.
    public static void insertarJugador(){
        teclado.useDelimiter("\n");
        System.out.println("Indique el nombre del equipo donde quiere insertar el jugador:");
        String nomEquipo = teclado.next();

        Equipo miEquipo = miLiga.getEquipo(nomEquipo);
        while(!Objects.equals(miEquipo.getNombre(), nomEquipo)){
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
        switch(nomPosicion){
            case "POR" : System.out.println();
                        break;
            case "DEF" : System.out.println();
                        break;
            case "CTC" : System.out.println();
                        break;
            case "DEL" : System.out.println();
                        break;
            default :   System.out.println("Posición no valida. \n" +
                        "Inserte la posición del jugador(POR, DEF, CTC, o DEL):");
                        nomPosicion = teclado.next();
                        break;
        }


        Jugador miJugador = new Jugador(nomJugador, nomPais, numEdad, nomPosicion);
        if(miEquipo.listaJugadores[21] != null){
            System.out.println("El equipo está lleno.");
        }

        else{
            miEquipo.adquirirJugador(miJugador);
            System.out.println("Creando jugador...\n" +
                    "Insertando jugador...\n" +
                    "Jugador " + nomJugador + " insertado en " + nomEquipo);

        }

    }

    //Muestra en pantalla los Equipos de la Liga
    public static void verLiga(){
        System.out.println("**********COMPOSICIÓN DE LA LIGA**********");
        miLiga.mostrarListadoEquipos();
        System.out.println("******************************************");
    }

    //Muestra en pantalla los Jugadores del Equipo introducido(entra en un bucle hasta que se introduce un equipo correcto).
    public static void verJugadores(){
        teclado.useDelimiter("\n");
        System.out.println("Indique el equipo que quiere visualizar:");
        String nomEquipo = teclado.next();
        Equipo miEquipo = miLiga.getEquipo(nomEquipo);
        while(!Objects.equals(miEquipo.getNombre(), nomEquipo)){
            System.out.println("El equipo indicado no existe.");
            System.out.println("Introduce otro equipo:");
            nomEquipo = teclado.next();
        }
        System.out.println("**********" + nomEquipo + "***************");
        miEquipo.mostrarListaJugadores();
        System.out.println("******************************************");

    }

    //Pide un equipo y un jugador, al comprobar que ambos existen lo vende (lo elimina del array)
    //Si el equipo no existe, entra en un bucle hasta que se introduce uno correcto
    //Si el jugador no existe vuelve al menu.
    public static void venderJugador(){
        teclado.useDelimiter("\n");
        System.out.println("Inserte el nombre del equipo donde quiere vender el jugador:");
        String nomEquipo = teclado.next();
        Equipo miEquipo = miLiga.getEquipo(nomEquipo);
        while(!Objects.equals(miEquipo.getNombre(), nomEquipo)){
            System.out.println("El equipo indicado no existe.");
            System.out.println("Introduce otro equipo:");
            nomEquipo = teclado.next();
        }
        System.out.println("Inserte el nombre del jugador:");
        String nomJugador = teclado.next();

        Jugador miJugador = miEquipo.getJugador(nomJugador);
        if(!Objects.equals(miJugador.getNombre(), nomJugador)){
            System.out.println("El jugador no existe.");
        }
        else{
            miEquipo.venderJugador(nomJugador);
            System.out.println("Vendiendo jugador...\n" +
                    "Jugador vendido.");
        }

    }
}