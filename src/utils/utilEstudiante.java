package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conect.Conexion;

public class utilEstudiante {
    public static void leerDatos(String nombreTabla) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM "+nombreTabla);
        res = ps.executeQuery();

        System.out.println("\n-----------------------------");
        System.out.println("\nLa lista de estudiantes es:\n");
        System.out.println("\nNombre\t\tApellido\tCi\tCelular");

        while (res.next()) {
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String ci = res.getString("ci");
            int celular = res.getInt("celular");
            System.out.println(nombre + "\t\t" + apellido + "\t\t" + ci+"\t"+celular);
        }  
    }
    public static void registrarDatosEstudiante(String nombre, String apellido, String ci, int celular) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `estudiante` (`id_Estudiantes`, `nombre`, `apellido`, `ci`, `celular`) VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+ci+"', '"+celular+"'); ");
        ps.execute();
    }
}
