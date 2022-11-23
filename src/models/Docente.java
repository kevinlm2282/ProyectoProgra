package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conect.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public ObservableList<Docente> getDocentes() throws SQLException{
        ObservableList<Docente> obs = FXCollections.observableArrayList();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM `profesor`");
        res = ps.executeQuery();

        while (res.next()) {
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String ci = res.getString("ci");
            Docente docente = new Docente(nombre, apellido, ci, 0, "1","Primero");
            obs.add(docente);
            System.out.println(nombre + "\t\t" + apellido + "\t\t" + ci+"\t");
        }  

        return obs;

    }
}
