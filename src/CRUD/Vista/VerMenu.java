/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Controller.AlumnoController;
import CRUD.Controller.AsignaturaController;
import CRUD.Controller.MatriculaController;
import CRUD.Controller.NotaController;
import CRUD.Controller.ProfesorController;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.ControlData;
import utilidades.Menu;

/**
 *
 * @author usuario
 */
public class VerMenu {

    static Scanner sc = new Scanner(System.in);
    static Menu menuTablas = new Menu(tablas());
    static byte op;

    public static void menuPrincipal() {
        Menu menuPrincipal = new Menu(opciones());
        byte opMenu;
        System.out.println("*********************************************************************");
        System.out.println("****************************BIENVENIDO*********************** ");

        do {
            System.out.println("*********************************************************************");
            System.out.println("Introduzca la opción que desee realizar:");
            menuPrincipal.printMenu();
            opMenu = ControlData.lerByte(sc);
            switch (opMenu) {
                case 1:
                    menuInsertar();
                    break;
                case 2:
                    menuBorrar();
                    break;
                case 3:
                    menuModificar();
                    break;
                case 4:
                    menuBuscar();
                    break;
                case 5:
                    menuImprimir();
                    break;
            }
        } while (opMenu != 6);
    }

    public static void menuInsertar() {
            System.out.println("*********************************************************************");
            System.out.println("¿En qué tabla desea realizar la inserción?");
            menuTablas.printMenu();
            op = ControlData.lerByte(sc);
            switch (op) {
                case 1:
                    ProfesorController.registrar();
                    break;
                case 2:
                    AlumnoController.registrar();
                    break;
                case 3:
                    AsignaturaController.registrar();
                    break;
                case 4:
                    MatriculaController.registrar();
                    break;
                case 5:
                    NotaController.registrar();                                
                    break;

            }

    }

    public static void menuBorrar() {
            System.out.println("*********************************************************************");
            System.out.println("¿En qué tabla desea realizar el borrado?");
            menuTablas.printMenu();
            op = ControlData.lerByte(sc);
            switch (op) {
                case 1:
                    ProfesorController.eliminar();
                    break;
                case 2:
                    AlumnoController.eliminar();
                    break;
                case 3:
                    AsignaturaController.eliminar();
                    break;
                case 4:
                    MatriculaController.eliminar();
                    break;
                case 5:                    
                    NotaController.eliminar();
                    break;
            }

    }

    public static void menuModificar() {
            System.out.println("*********************************************************************");
            System.out.println("¿En qué tabla desea actualizar los datos?");
            menuTablas.printMenu();
            op = ControlData.lerByte(sc);
            switch (op) {
                case 1:
                    ProfesorController.actualizar();
                    break;
                case 2:
                    AlumnoController.actualizar();
                    break;
                case 3:
                    AsignaturaController.actualizar();
                    break;
                case 4:
                    MatriculaController.eliminar();
                    break;
                case 5:
                    NotaController.actualizar();
                    break;
            }
    }

    public static void menuBuscar() {
            System.out.println("*********************************************************************");
            System.out.println("¿Qué desea buscar?");
            menuTablas.printMenu();
            op = ControlData.lerByte(sc);
            switch (op) {
                case 1:
                    ProfesorController.buscar();
                    break;
                case 2:
                    AlumnoController.buscar();
                    break;
                case 3:
                    AsignaturaController.buscar();
                    break;
                case 4:
                    MatriculaController.buscar();
                    break;
                case 5:
                    NotaController.buscar();
                    break;
            }
    }

    public static void menuImprimir() {
            System.out.println("*********************************************************************");
            System.out.println("¿Qué tabla quiere imprimir?");
            menuTablas.printMenu();
            op = ControlData.lerByte(sc);
            switch (op) {
                case 1:
                    ProfesorController.obtener();
                    break;
                case 2:
                    AlumnoController.obtener();
                    break;
                case 3:
                    AsignaturaController.obtener();
                    break;
                case 4:
                    MatriculaController.obtener();
                case 5:
                    NotaController.obtener();
                    break;
            }
    }

    static ArrayList<String> opciones() {
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Inserción de nuevas filas");
        opciones.add("Borrar filas");
        opciones.add("Modificar filas");
        opciones.add("Buscar");
        opciones.add("Imprimir tabla");
        opciones.add("Salir");
        return opciones;
    }

    static ArrayList<String> tablas() {
        ArrayList<String> opciones = new ArrayList<String>();
        opciones.add("Profesores");
        opciones.add("Alumnos");
        opciones.add("Asignaturas");
        opciones.add("Matrículas");
        opciones.add("Notas");
        opciones.add("Volver");
        return opciones;
    }

}
