package models;
public class Curso {
    //Variables Locales
    String nombre;

    //Getters y Setters
    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //ToString()
    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + "]";
    }
    
}
