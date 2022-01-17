/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Model.Alumno;
import CRUD.Model.Profesor;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class AlumnoDatos {

    static Scanner sc = new Scanner(System.in);

    public static Alumno datosRegistrar(int idal) {
        String codigoAlumno=comprobarCodigo();
        System.out.println("Introduce el nombre del alumno");
        String nombre = ControlData.lerString(sc);
        Alumno alumno = new Alumno(idal, codigoAlumno, nombre);
        return alumno;
    }

    public static int datosIdal() {
        System.out.println("Introduce el idal del alumno que quieres buscar");
        int idal = ControlData.lerInt(sc);
        return idal;
    }

    public static Alumno datosActualizar(int idal) {
        String codigoAlumno=comprobarCodigo();
        System.out.println("Introduce el nombre del alumno");
        String nombre = ControlData.lerString(sc);
        Alumno alumno = new Alumno(idal, codigoAlumno, nombre);
        return alumno;
    }

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
