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
import excepciones.MatriculaNoExisteException;
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
    MatriculaDao dao = new MatriculaDao();

    public static Matricula datosRegistrar() throws ProfNoExisteException, AlumNoExisteException, AsigNoExisteException, MatriculaRepetidaException {
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
            throw new ProfNoExisteException();
        } catch (AlumNoExisteException ex) {
            throw new AlumNoExisteException();
        } catch (AsigNoExisteException ex) {
            throw new AsigNoExisteException();
        } catch (MatriculaRepetidaException ex) {
            throw new MatriculaRepetidaException();
        }
        return matricula;
    }

    public static Matricula datosActualizar() throws MatriculaNoExisteException, ProfNoExisteException {
        Matricula matricula = null;

        try {
            matricula = datosBuscar();
            System.out.println("Introduce el dni del nuevo profesor");
            String dni = ControlData.lerString(sc);
            MatriculaDao.comprobarDni(dni);
            matricula.setDni(dni);
        } catch (ProfNoExisteException ex) {
            throw new ProfNoExisteException();
        } catch (MatriculaNoExisteException e) {
            throw new MatriculaNoExisteException();
        }

        return matricula;
    }

   
    
    
    public static Matricula datosBuscar() throws MatriculaNoExisteException {
        Matricula matricula = null;
        System.out.println("Introduce el idal del alumno");
        int idal = ControlData.lerInt(sc);
        System.out.println("Introduce el idas de la asignatura ");
        int idas = ControlData.lerInt(sc);
        MatriculaDao dao = new MatriculaDao();
        if (dao.buscar(idal, idas) != null) {
            matricula = dao.buscar(idal, idas);

        } else {
            throw new MatriculaNoExisteException();
        }

        return matricula;

    }

}
