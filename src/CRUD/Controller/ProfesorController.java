package CRUD.Controller;

import CRUD.Dao.ProfesorDao;
import CRUD.Model.Profesor;
import CRUD.Vista.Mensajes;
import CRUD.Vista.ProfesorDatos;
import CRUD.Vista.ProfesorVista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Clase controlador de la clase modelo Profesor. Para cada caso, llama a ProfesorDatos para 
 * pedir los datos que necesida, a ProfesorDao para operar con la base de datos
 * y cuando es necesario a ProfesorVista para mostrar registros.
 */
public class ProfesorController {

    static Scanner sc = new Scanner(System.in);
    static ProfesorVista vista = new ProfesorVista();
    static ProfesorDao dao = new ProfesorDao();

    public static void registrar() {
        Profesor profesor = ProfesorDatos.datosRegistrar();
        dao.registrar(profesor);
    }

    public static void buscar() {
        String dni = ProfesorDatos.datosDni();
        Profesor x = dao.buscar(dni);
        vista.verProfesor(x);
    }

    public static void actualizar() {
        String dni = ProfesorDatos.datosDni();
        if (dao.buscar(dni) != null) {
            Profesor profesor = ProfesorDatos.datosActualizar(dni);
            dao.actualizar(profesor);
        } else {
            Mensajes.profesorNoExiste();
        }
    }

    public static void eliminar() {
        String dni = ProfesorDatos.datosDni();
        if (dao.buscar(dni) != null) {
            dao.eliminar(dni);
        } else {
            Mensajes.profesorNoExiste();
        }
    }

    public static void obtener() {
        List<Profesor> profesores = new ArrayList<>();
        profesores = dao.obtener();
        vista.verProfesores(profesores);
    }

    public static void verAsignaturas() {
            String dni = ProfesorDatos.datosDni();
            dao.verAsignaturas(dni);
        
        
    }


}
