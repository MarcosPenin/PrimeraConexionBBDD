
package CRUD.Vista;

import CRUD.Model.Alumno;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class AlumnoDatos {

    static Scanner sc = new Scanner(System.in);
   /**
    * Devuelve una instancia de Alumno en base a los datos introducidos
    * @param idal
    * @return Alumno
    */
    public static Alumno datosRegistrar(int idal) {
        String codigoAlumno=comprobarCodigo();
        System.out.println("Introduce el nombre del alumno");
        String nombre = ControlData.lerString(sc);
        Alumno alumno = new Alumno(idal, codigoAlumno, nombre);
        return alumno;
    }
/**
 * Devuelve el idal que introduce el usuario
 * @return int
 */
    public static int datosIdal() {
        System.out.println("Introduce el idal del alumno");
        int idal = ControlData.lerInt(sc);
        return idal;
    }

    /**
     * Devuelve una instancia de Alumno en base a los datos introducidos
     * @param idal
     * @return 
     */
    
    public static Alumno datosActualizar(int idal) {
        String codigoAlumno=comprobarCodigo();
        System.out.println("Introduce el nuevo nombre del alumno");
        String nombre = ControlData.lerString(sc);
        Alumno alumno = new Alumno(idal, codigoAlumno, nombre);
        return alumno;
    }

    /**
     * Pide el código del alumno, comnprobando si tiene el formato correcto
     * con el método de ControlData correspondiente
     * @return 
     */
    
    public static String comprobarCodigo() {
        boolean correcto = false;
        String codigoAlumno;
        do {
            System.out.println("Introduce el código del alumno");
            codigoAlumno = ControlData.lerString(sc);
            correcto = ControlData.comprobarCodigo(codigoAlumno);
        } while (!correcto);
        return codigoAlumno;

    }

}
