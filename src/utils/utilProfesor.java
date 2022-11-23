package utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conect.Conexion;

public class utilProfesor {
    public static void leerDatosProf(String nombreTabla) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM "+nombreTabla);
        res = ps.executeQuery();

        System.out.println("\n-----------------------------");
        System.out.println("\nLa lista de profesores es:\n");
        System.out.println("\nNombre\t\tApellido\tCi");

        while (res.next()) {
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String ci = res.getString("ci");
            System.out.println(nombre + "\t\t" + apellido + "\t\t" + ci);
        }  
    }
    public static void registrarDatosProfesor(String nombre, String apellido, String ci) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `profesor` (`id_Profesor`, `nombre`, `apellido`, `ci`) VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+ci+"'); ");
        ps.execute();
    }
}
