package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conect.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Estudiante extends Persona{

    private String codigoEstudiante;
    private String grado;


    
    public Estudiante(String nombre, String apellido, String ci, Integer celular) {
        super(nombre, apellido, ci, celular);
    }

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
        return getNombre()+" "+getApellido();
    }

    public ObservableList<Estudiante> getEstudiantes() throws SQLException{
        ObservableList<Estudiante> obs = FXCollections.observableArrayList();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM `estudiante`");
        res = ps.executeQuery();

        while (res.next()) {
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String ci = res.getString("ci");
            int celular = res.getInt("celular");
            Estudiante estudiante = new Estudiante(nombre, apellido, ci, celular,"1","Primero");
            obs.add(estudiante);
            System.out.println(nombre + "\t\t" + apellido + "\t\t" + ci+"\t"+celular);
        }  

        return obs;

    }

}
