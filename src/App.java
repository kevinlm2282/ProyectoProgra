import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.PreparableStatement;

import models.Docente;
import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        // Estudiante estudiante = new Estudiante("juan", "campos", "12345LP", 1234567, "1111111GGGG", "secundario");
        // Docente docente = new Docente("roberto", "gimenez", "1234LLQW", 123456, "1234JKL", "doctorado");
        // System.out.println("Este es el estudiante= " + estudiante.getNombre());
        // System.out.println("Data docente= " + docente );
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        ResultSet res;
        
        ps = con.prepareStatement("SELECT * FROM estudiante");
        res = ps.executeQuery();
        if(res.next()){
            System.out.println(res.getString("apellido"));
        }




        

    }
}
