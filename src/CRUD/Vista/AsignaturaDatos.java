
package CRUD.Vista;

import CRUD.Model.Asignatura;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class AsignaturaDatos {
    
    static Scanner sc = new Scanner(System.in);

  /**
   * Devuelve una instancia de asignatura en base a los datos introducidos
   * @param idas
   * @return 
   */
    public static Asignatura datosRegistrar(int idas) {
        String codigoAsignatura=comprobarCodigo();
        System.out.println("Introduce el nombre del ciclo");
        String nombreCiclo = ControlData.lerString(sc);
       Asignatura asignatura = new Asignatura(idas, codigoAsignatura, nombreCiclo);
        return asignatura;
    }

    /**
     * Pide un idas para la asignatura y lo devuelve
     * @return 
     */
    
    public static int datosIdas() {
        System.out.println("Introduce el idas de la asignatura");
        int idas = ControlData.lerInt(sc);
        return idas;
    }

    /**
     * Devuelve una instancia de Asignatura en base a los datos introducidos
     * @param idas
     * @return 
     */
    
    public static Asignatura datosActualizar(int idas) {
        String codigoAsignatura=comprobarCodigo();
        System.out.println("Introduce el nombre del ciclo");
        String nombreCiclo = ControlData.lerString(sc);
        Asignatura asignatura = new Asignatura(idas, codigoAsignatura, nombreCiclo);
        return asignatura;
    }

    /**
     * Comprueba el código de la asignatura llamando a los datos correspondientes
     * @return 
     */
    
    public static String comprobarCodigo() {
        boolean correcto = false;
        String codigoAsignatura;
        do {
            System.out.println("Introduce el código de la asignatura");
            codigoAsignatura = ControlData.lerString(sc);
            correcto = ControlData.comprobarCodigo(codigoAsignatura);
        } while (!correcto);
        return codigoAsignatura;

    }
    
    
    
    
}
