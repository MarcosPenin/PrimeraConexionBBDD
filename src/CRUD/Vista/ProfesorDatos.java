
package CRUD.Vista;

import CRUD.Model.Profesor;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class ProfesorDatos {

    static Scanner sc = new Scanner(System.in);

    public static Profesor datosRegistrar() {
        System.out.println("Introduce el dni del profesor");
        String dni = ControlData.lerString(sc);
        System.out.println("Introduce el nombre del profesor");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduce la titulación del profesor");
        String titulacion = ControlData.lerString(sc);
        Profesor profesor = new Profesor(dni, nombre, titulacion);
        return profesor;
    }
    
    public static String datosDni(){
        System.out.println("Introduce el dni del profesor ");
        String dni = ControlData.lerString(sc);
        return dni;
    }
    
       
    public static Profesor datosActualizar(String dni){
        System.out.println("Introduce el nuevo nombre del profesor");
        String nombre = ControlData.lerString(sc);
        System.out.println("Introduce la nueva titulación del profesor");
        String titulacion = ControlData.lerString(sc);

        Profesor profesor = new Profesor(dni, nombre, titulacion);
        return profesor;
    }
    
     
    
    

}
