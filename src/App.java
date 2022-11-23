
import java.util.Scanner;

import utils.utilEstudiante;
import utils.utilProfesor;;

public class App {
    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
	static int select = -1; //opción elegida del usuario
	static int num1 = 0, num2 = 0; //Variables
    public static void main(String[] args) throws Exception {
        String nombre, apellido, ci;
        int celular;
        utilEstudiante controllerEstudiante = new utilEstudiante();
        utilProfesor controllerProfesor = new utilProfesor();
        
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
                    utilEstudiante.leerDatos("estudiante");				
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
                    controllerEstudiante.registrarDatosEstudiante(nombre, apellido, ci, celular);
					System.out.println("Dato registrado!");
					break;
				case 3:
                    controllerProfesor.leerDatosProf("profesor");
					break;
				case 4:
                    System.out.println("Ingresa nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingresa apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingresa documento de identidad: ");
                    ci = scanner.nextLine();
                    controllerProfesor.registrarDatosProfesor(nombre, apellido, ci);
                    System.out.println("Dato registrado!");
					break;
                case 5: 					
                    System.out.println("La lista de calificaciones es:");
                    //leerDatos("calificaciones");		
					break;
				case 6: 
                    System.out.println("Ingresa nombre: ");
                    nombre = scanner.nextLine();
                    System.out.println("Ingresa apellido: ");
                    apellido = scanner.nextLine();
                    System.out.println("Ingresa documento de identidad: ");
                    ci = scanner.nextLine();
                    //registrarDatosProfesor(nombre,apellido,ci);
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
	
}
