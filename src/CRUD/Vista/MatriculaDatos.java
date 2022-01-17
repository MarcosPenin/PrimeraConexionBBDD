/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Vista;

import CRUD.Dao.AlumnoDao;
import CRUD.Dao.MatriculaDao;
import CRUD.Dao.ProfesorDao;
import CRUD.Model.Matricula;
import CRUD.Model.Profesor;
import excepciones.AlumNoExisteException;
import excepciones.AsigNoExisteException;
import excepciones.MatriculaRepetidaException;
import excepciones.ProfNoExisteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.ControlData;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaDatos {

    static Scanner sc = new Scanner(System.in);

    public static Matricula datosRegistrar() {
        Matricula matricula = null;
        try {
            System.out.println("Introduce el dni del profesor");
            String dni = ControlData.lerString(sc);
            MatriculaDao.comprobarDni(dni);
            System.out.println("Introduce el idal del alumno");
            int idal = ControlData.lerInt(sc);
            MatriculaDao.comprobarIdal(idal);
            System.out.println("Introduce el idas de la asignatura");
            int idas = ControlData.lerInt(sc);
            MatriculaDao.comprobarIdas(idas);

            matricula = new Matricula(dni, idal, idas);
            MatriculaDao.comprobarCoherencia(matricula);

        } catch (ProfNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (AlumNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (AsigNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (MatriculaRepetidaException ex) {
            System.out.println(ex.getMessage());
        }
        return matricula;
    }

    public static Matricula datosActualizar() {

        Matricula matricula = null;

        System.out.println("Introduce el idal del alumno");
        int idal = ControlData.lerInt(sc);
        System.out.println("Introduce el idas de la asignatura");
        int idas = ControlData.lerInt(sc);

        MatriculaDao md = new MatriculaDao();
        if (md.buscar(idal, idas) != null) {
            System.out.println("Introduce el dni del nuevo profesor");
            String dni = ControlData.lerString(sc);
            try {
                MatriculaDao.comprobarDni(dni);
                matricula = new Matricula(dni, idal, idas);
            } catch (ProfNoExisteException ex) {
                ex.getMessage();
            }

        }

        return matricula;

    }
}
