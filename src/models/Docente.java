package models;

public class Docente extends Persona {

    String codigoDocente;
    String gradoAcademico;
    
    public Docente(String nombre, String apellido, String ci, Integer celular, String codigoDocente,
            String gradoAcademico) {
        super(nombre, apellido, ci, celular);
        this.codigoDocente = codigoDocente;
        this.gradoAcademico = gradoAcademico;
    }

    public String getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(String codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }


    @Override
    public String toString() {
        return "Docente [nombre=" + getNombre() + ", apellido=" + getApellido() + ", ci=" + getCi() + ", celular=" + getCelular() +", codigoDocente=" + codigoDocente + ", gradoAcademico=" + gradoAcademico + "]";
    }

    


    
}
