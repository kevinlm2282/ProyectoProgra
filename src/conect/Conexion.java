package conect;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

public static final String  URL = "jdbc:mysql://localhost:3306/colegio";    
public static final String  USERNAME = "root";
public static final String  PASSWORD = "";


public static Connection getConnection(){

    Connection connection = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("coneccion exitosa a la base de datos");
    } catch (Exception e) {
        System.out.println(e);
        // TODO: handle exception
    }
    return connection;
}

}
