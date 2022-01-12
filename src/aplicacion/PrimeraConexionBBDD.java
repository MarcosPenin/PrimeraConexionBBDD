package aplicacion;

import CRUD.Creation.CrearTablas;
import CRUD.Connection.Conexion;
import CRUD.Controller.ProfesorController;
import CRUD.Dao.ProfesorDao;
import CRUD.Model.Profesor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.Menu;

public class PrimeraConexionBBDD {

    static Scanner sc = new Scanner(System.in);
    static Menu menuPrincipal = new Menu(opciones());
    static Menu menuTablas = new Menu(tablas());

    public static void main(String[] args) throws IOException {

        byte cont = 0, op = 0, op2;
        Conexion conexion = Conexion.getInStance();
        conexion.conectar();
        CrearTablas.crearTabla(Conexion.sentencia);

        do {
            System.out.println("*****************************");
            menuPrincipal.printMenu();
            op = sc.nextByte();

            switch (op) {
                case 0:
                    System.out.println("SALIENDO");
                    break;
                case 1:
                    System.out.println("¿En qué tabla deseas registrar una fila?");
                    menuTablas.printMenu();
                    op2 = sc.nextByte();
                    switch (op2) {
                        case 1:
                            ProfesorController.registrar();
                    }

//                    InsertarFilas.insertarFila(sentencia, rstAux, lee);
                    break;
                case 2:
                    

//                    BorrarFilas.borrarFila(sentencia, rstAux, lee);
                    break;
                case 3:
//                    ModificarFilas.modificarFila(sentencia, rstAux, lee);
                    break;
                case 4:
                    ProfesorController.buscar();
                    
//                    Consultar.consulta(sentencia, rstAux, lee);
                    break;
                case 5:
                    ProfesorController.obtener();
                    break;
            }
        } while (op != 6);
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
        opciones.add("Notas");
        opciones.add("Salir");
        return opciones;
    }

}
