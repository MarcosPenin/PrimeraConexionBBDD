package CRUD.Controller;

import CRUD.Dao.ProfesorDao;
import CRUD.Model.Profesor;
import CRUD.Vista.ProfesorVista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author a20marcosgp
 */
public class ProfesorController {

    static Scanner sc = new Scanner(System.in);

    public static void registrar() {

        System.out.println("Introduce el dni del profesor");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre del profesor");
        String nombre = sc.nextLine();
        System.out.println("Introduce la titulación del profesor");
        String titulacion = sc.nextLine();

        Profesor profesor = new Profesor(dni, nombre, titulacion);
        ProfesorDao dao = new ProfesorDao();
        if (dao.registrar(profesor)) {
            System.out.println("Profesor registrado con éxito");
        };
    }

    public static void buscar() {
        System.out.println("Introduce el dni del profesor que quieres buscar");
        String dni = sc.nextLine();
        ProfesorDao dao = new ProfesorDao();
        Profesor x = dao.buscar(dni);
        ProfesorVista vista = new ProfesorVista();
        vista.verProfesor(x);

    }
//
//    public static Profesor buscar2() {
//        System.out.println("Introduce el dni del profesor que quieres buscar");
//        String dni = sc.nextLine();
//        ProfesorDao dao = new ProfesorDao();
//        Profesor x = dao.buscar(dni);
//        return x;
//    }

    public void actualizar() {
        System.out.println("Introduce el dni del profesor que quieras actualizar");
        String dni = sc.nextLine();

        System.out.println("Introduce el nuevo nombre del profesor");
        String nombre = sc.nextLine();
        System.out.println("Introduce la nueva titulación del profesor");
        String titulacion = sc.nextLine();

        Profesor x = new Profesor(dni, nombre, titulacion);
        ProfesorDao dao = new ProfesorDao();
        dao.actualizar(dni,x);
  
    }

//
//    public void eliminar(Profesor cliente) {
//       ProfesorDao dao = new ProfesorDao();
//        dao.eliminar(cliente);
//    }
    public static void obtener() {
        List<Profesor> profesores = new ArrayList<Profesor>();
        ProfesorDao dao = new ProfesorDao();
        profesores = dao.obtener();
        ProfesorVista vista = new ProfesorVista();
        vista.verProfesores(profesores);
    }
}
