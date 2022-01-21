
package CRUD.Vista;

import CRUD.Model.Alumno;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AlumnoVista {  
    /**
     * Imprime todos los alumnos registrados
     * @param alumnos 
     */
    public void verAlumnos(List<Alumno> alumnos) {
        for (Alumno x : alumnos) {
            System.out.println("Datos del Alumno: " + x.toString());
        }
    }

    /**
     * Imprime los datos de un alumno concreto
     * @param alumno 
     */
    
    public void verAlumno(Alumno alumno) {

        if (alumno != null) {
            System.out.println("Datos del alumno: " + alumno.toString());
        } else {
            System.out.println("El alumno buscado no existe");
        }

    }
  
}
