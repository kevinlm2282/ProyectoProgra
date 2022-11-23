package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conect.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Calificaciones;

public class Calificaciones implements FuncionesBasicas {
    //Variables Locales
    private double valor;
    private int idcurso,idEstudiante;

    //Constructor
    public Calificaciones(double valor, int idcurso, int idEstudiante) {
        this.valor = valor;
        this.idcurso = idcurso;
        this.idEstudiante = idEstudiante;
    }

    //Metodos de la interfaz FuncionesBasicas.java
    @Override
    public void registrar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modificar() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminar() {
        // TODO Auto-generated method stub
        
    }

    //Getters y Setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    //ToString()
    @Override
    public String toString() {
        return "Calificaciones [valor=" + valor + "]";
    }
    public ObservableList<Calificaciones> getCalificaciones(String idVar) throws SQLException{
        ObservableList<Calificaciones> obs = FXCollections.observableArrayList();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM `calificaciones` WHERE `estudiante_idEstudiante`= '"+idVar+"';");
        res = ps.executeQuery();

        while (res.next()) {
            int idEstudiante = res.getInt("estudiante_idEstudiante");
            int idcurso = res.getInt("curso_idCurso");
            Double valor = res.getDouble("valor");
            Calificaciones calificaciones = new Calificaciones(valor,idcurso,idEstudiante);

            obs.add(calificaciones);
            System.out.println(valor + "\t\t" + idcurso + "\t\t" + idEstudiante);
        }  

        return obs;

    }

    public static void registrarDatosEstudiante(String nombre, String apellido, String ci, int celular) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `estudiante` (`id_Estudiantes`, `nombre`, `apellido`, `ci`, `celular`) VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+ci+"', '"+celular+"'); ");
        ps.execute();
    }
}
