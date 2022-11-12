import models.Docente;
import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        Estudiante estudiante = new Estudiante("juan", "campos", "12345LP", 1234567, "1111111GGGG", "secundario");
        Docente docente = new Docente("roberto", "gimenez", "1234LLQW", 123456, "1234JKL", "doctorado");
        System.out.println("Este es el estudiante= " + estudiante.getNombre());
        System.out.println("Data docente= " + docente );
    }
}
