/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Model.Alumno;
import CRUD.Model.Asignatura;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class AsignaturaDatos {
    
        static Scanner sc = new Scanner(System.in);

    public static Asignatura datosRegistrar(int idas) {
        String codigoAsignatura=comprobarCodigo();
        System.out.println("Introduce el nombre del ciclo");
        String nombreCiclo = ControlData.lerString(sc);
       Asignatura asignatura = new Asignatura(idas, codigoAsignatura, nombreCiclo);
        return asignatura;
    }

    public static int datosIdas() {
        System.out.println("Introduce el idas de la asignatura que quieres buscar");
        int idas = ControlData.lerInt(sc);
        return idas;
    }

    public static Asignatura datosActualizar(int idas) {
        String codigoAsignatura=comprobarCodigo();
        System.out.println("Introduce el nombre del ciclo");
        String nombreCiclo = ControlData.lerString(sc);
        Asignatura asignatura = new Asignatura(idas, codigoAsignatura, nombreCiclo);
        return asignatura;
    }

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
