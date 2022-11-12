package models;

public class Persona {
    private String nombre;
    private String apellido;
    private String ci;
    private Integer celular;
    
    public Persona(String nombre, String apellido, String ci, Integer celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", ci=" + ci + ", celular=" + celular + "]";
    }   
    
}
