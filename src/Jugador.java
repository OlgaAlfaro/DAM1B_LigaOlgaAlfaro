public class Jugador {
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String posicion;
    private boolean lesionado;

  //Método constructor de la clase Jugador
    public Jugador(String nombre, String nacionalidad, int edad, String posicion){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.posicion = posicion;
        lesionado = false;
    }

    //Metodos getters para acceder a los atributos de la clase
    public String getNombre(){
        return nombre;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }

    public int getEdad(){
        return edad;
    }

    public String getPosicion(){
        return posicion;
    }

    public boolean getLesionado(){
        return lesionado;
    }

    //Metodos setters para lesionado, true si esta lesionado, false si no(o se ha recuperado)
    public void lesionarse(){
        lesionado = true;
    }

    public void recuperarse(){
        lesionado = false;
    }
}
