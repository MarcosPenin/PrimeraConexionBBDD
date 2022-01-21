
package CRUD.Controller;

import CRUD.Dao.MatriculaDao;
import CRUD.Model.Matricula;
import CRUD.Vista.MatriculaDatos;
import CRUD.Vista.MatriculaVista;
import excepciones.AlumNoExisteException;
import excepciones.AsigNoExisteException;
import excepciones.MatriculaNoExisteException;
import excepciones.MatriculaRepetidaException;
import excepciones.OtroProfesorException;
import excepciones.ProfNoExisteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Clase controlador de la clase modelo Matrícula(nombre para ProfesoresAlumnosAsignaturas). Para cada caso, llama a MatrículaDatos para 
 * pedir los datos que necesida, a MatrículaDao para operar con la base de datos
 * y cuando es necesario a MatrículaVista para mostrar registros.
 */
public class MatriculaController {

    static Scanner sc = new Scanner(System.in);
    static MatriculaVista vista = new MatriculaVista();
    static MatriculaDao dao = new MatriculaDao();
    static MatriculaDatos md = new MatriculaDatos();

    public static void registrar() {
        try {
            Matricula matricula;
            matricula = md.datosRegistrar();
            dao.registrar(matricula);
        } catch (ProfNoExisteException | AlumNoExisteException | AsigNoExisteException | MatriculaRepetidaException | OtroProfesorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void buscar() {
        try {
            Matricula matricula = MatriculaDatos.datosBuscar();
            vista.verMatricula(matricula);
        } catch (MatriculaNoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void actualizar() {
        try {
            Matricula matricula = MatriculaDatos.datosActualizar();
            dao.actualizar(matricula);
        } catch (ProfNoExisteException | MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminar() {
        try {
            
            Matricula matricula = MatriculaDatos.datosBuscar();
            dao.eliminar(matricula);
        } catch (MatriculaNoExisteException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void obtener() {
        List<Matricula> matriculas = new ArrayList<>();
        matriculas = dao.obtener();
        vista.verMatriculas(matriculas);
    }

}
