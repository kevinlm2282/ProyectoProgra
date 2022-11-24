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
    private String idcurso,idEstudiante,nombre,apellido;

    //Constructor
    public Calificaciones(double valor, String idcurso, String idEstudiante) {
        this.valor = valor;
        this.idcurso = idcurso;
        this.idEstudiante = idEstudiante;
    }


    public Calificaciones(String nombre, String apellido, double valor) {
        this.valor = valor;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(String idcurso) {
        this.idcurso = idcurso;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
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
            String idEstudianteSt = "";
            String idCursoSt = "";
            if(idcurso==1){idCursoSt="Literatura";}
            if(idcurso==2){idCursoSt="Religion";}
            if(idcurso==3){idCursoSt="Matematicas";}
            if(idcurso==4){idCursoSt="Fisica";}
            Double valor = res.getDouble("valor");
            Calificaciones calificaciones = new Calificaciones(valor,idCursoSt,idEstudianteSt);

            obs.add(calificaciones);
            System.out.println(valor + "\t\t" + idcurso + "\t\t" + idEstudiante);
        }  

        return obs;

    }

    public ObservableList<Calificaciones> getCalificacionesNombres() throws SQLException{
        ObservableList<Calificaciones> obs = FXCollections.observableArrayList();
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM `estudiante` a, `calificaciones` b WHERE 1;");
        
        res = ps.executeQuery();

        while (res.next()) {
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            Double valor = res.getDouble("valor");
            Calificaciones calificaciones2 = new Calificaciones(nombre,apellido,valor);

            obs.add(calificaciones2);
            System.out.println(valor + "\t\t" + nombre + "\t\t" + apellido);
        }  

        return obs;

    }
    public static void registrarCalificaciones(String valor, String idCurso, String idEstudiante) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `calificaciones` (`id`, `valor`, `curso_idCurso`, `estudiante_idEstudiante`) VALUES (NULL, '"+valor+"', '"+idCurso+"', '"+idEstudiante+"');");
        ps.execute();
    }

    public static void registrarDatosEstudiante(String nombre, String apellido, String ci, int celular) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `estudiante` (`id_Estudiantes`, `nombre`, `apellido`, `ci`, `celular`) VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+ci+"', '"+celular+"'); ");
        ps.execute();
    }
}
