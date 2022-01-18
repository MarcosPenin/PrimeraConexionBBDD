
package CRUD.Controller;

import CRUD.Dao.NotaDao;
import CRUD.Model.Nota;
import CRUD.Vista.NotaDatos;
import CRUD.Vista.NotaVista;
import excepciones.MatriculaNoExisteException;
import excepciones.NotaNoExisteException;
import excepciones.NotaRepetidaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class NotaController {

    static Scanner sc = new Scanner(System.in);
    static NotaDao dao = new NotaDao();
    static NotaVista vista = new NotaVista();

    public static void registrar() {
        try {
            Nota nota = NotaDatos.datosRegistrar();
            dao.registrar(nota);
        } catch (MatriculaNoExisteException | NotaRepetidaException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void buscar() {
        try {
            Nota nota = NotaDatos.datosBuscar();
            vista.verNota(nota);
        } catch (NotaNoExisteException | MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void actualizar() {

        try {
            Nota nota = NotaDatos.datosActualizar();
        } catch (NotaNoExisteException | MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminar() {

        Nota nota;
        try {
            nota = NotaDatos.datosBuscar();
            dao.eliminar(nota);
        } catch (NotaNoExisteException | MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

public static void obtener() {
        List<Nota> notas = new ArrayList<>();
        notas = dao.obtener();      
        vista.verNotas(notas);
    }
 
}
