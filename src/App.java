import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.xdevapi.PreparableStatement;

import models.Docente;
import models.Estudiante;

public class App {
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
	static int select = -1; //opción elegida del usuario
	static int num1 = 0, num2 = 0; //Variables
    public static void main(String[] args) throws Exception {
        String nombre, apellido, ci;
        int celular;

        
		//Mientras la opción elegida sea 0, preguntamos al usuario
		while(select != 0){
			//Try catch para evitar que el programa termine si hay un error
			try{
				System.out.println("Elige opción:\n1.- Leer tabla estudiantes" +
						"\n2.- Registrar nuevo estudiante\n" +
						"3.- Leer tabla profesor\n" +
						"4.- Registrar nuevo profesor\n" +
                        "5.- Leer tabla calificaciones\n" +
                        "6.- Registrar nueva calificacion\n" +
                        "7.- Leer tabla curso\n" +
                        "8.- Registrar nuevo curso\n" +
                        "9.- Leer tabla materia\n" +
                        "10.- Registrar nueva materia\n" +
						"0.- Salir");
				//Recoger una variable por consola
				select = Integer.parseInt(scanner.nextLine()); 
	
				//Ejemplo de switch case en Java
				switch(select){
				case 1: 
                    leerDatos("estudiante");					
					break;
				case 2: 
                    System.out.println("Ingresa nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingresa apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingresa documento de identidad: ");
                    ci = scanner.nextLine();
                    System.out.println("Ingresa celular: ");
                    celular = scanner.nextInt();
                    registrarDatosEstudiante(nombre,apellido,ci,celular);
					System.out.println("Dato registrado!");
					break;
				case 3: 					
                    leerDatosProf("profesor");	
					break;
				case 4: 
                    System.out.println("Ingresa nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingresa apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingresa documento de identidad: ");
                    ci = scanner.nextLine();
                    registrarDatosProfesor(nombre,apellido,ci);
                    System.out.println("Dato registrado!");
					break;
                case 5: 					
                    System.out.println("La lista de calificaciones es:");
                    leerDatos("calificaciones");		
					break;
				case 6: 
                    System.out.println("Ingresa nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingresa apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingresa documento de identidad: ");
                    ci = scanner.nextLine();
                    registrarDatosProfesor(nombre,apellido,ci);
                    System.out.println("Dato registrado!");
					break;
				case 0: 
					System.out.println("Adios!");
					break;
				default:
					System.out.println("Número no reconocido");break;
				}
				
				System.out.println("\n"); //Mostrar un salto de línea en Java
				
			}catch(Exception e){
				System.out.println("Uoop! Error!");
			}
		}
        
        

	}
	

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

    public static void registrarDatosEstudiante(String nombre, String apellido, String ci, int celular) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `estudiante` (`id_Estudiantes`, `nombre`, `apellido`, `ci`, `celular`) VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+ci+"', '"+celular+"'); ");
        ps.execute();
    }
    public static void registrarDatosProfesor(String nombre, String apellido, String ci) throws SQLException{
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();

        PreparedStatement ps;
        
        ps = con.prepareStatement("INSERT INTO `profesor` (`id_Profesor`, `nombre`, `apellido`, `ci`) VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+ci+"'); ");
        ps.execute();
    }
}
