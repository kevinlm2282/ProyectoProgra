package models;

public class Estudiante extends Persona{

    private String codigoEstudiante;
    private String grado;
    
    public Estudiante(String nombre, String apellido, String ci, Integer celular, String codigoEstudiante,
            String grado) {
        super(nombre, apellido, ci, celular);
        this.codigoEstudiante = codigoEstudiante;
        this.grado = grado;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Estudiante [nombre=" + getNombre() + ", apellido=" + getApellido() + ", ci=" + getCi() + ", celular=" + getCelular() +", codigoEstudiante=" + codigoEstudiante + ", grado=" + grado + "]";
    }


    
}
