/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Controller;

import static CRUD.Controller.AlumnoController.dao;
import CRUD.Dao.AlumnoDao;
import CRUD.Dao.MatriculaDao;
import CRUD.Model.Alumno;
import CRUD.Model.Matricula;
import CRUD.Vista.AlumnoDatos;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.MatriculaDatos;
import CRUD.Vista.MatriculaVista;
import CRUD.Vista.Mensajes;
import excepciones.AlumNoExisteException;
import excepciones.AsigNoExisteException;
import excepciones.DniInvalido;
import excepciones.MatriculaNoExisteException;
import excepciones.MatriculaRepetidaException;
import excepciones.ProfNoExisteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaController {

    static Scanner sc = new Scanner(System.in);
    static MatriculaVista vista = new MatriculaVista();
    static MatriculaDao dao = new MatriculaDao();

    public static void registrar() {
        try {
            Matricula matricula = MatriculaDatos.datosRegistrar();
            dao.registrar(matricula);
        } catch (ProfNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (AlumNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (AsigNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (MatriculaRepetidaException ex) {
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
        } catch (ProfNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (MatriculaNoExisteException ex) {
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
        List<Matricula> matriculas = new ArrayList<Matricula>();
        matriculas = dao.obtener();
        vista.verMatriculas(matriculas);
    }

}
