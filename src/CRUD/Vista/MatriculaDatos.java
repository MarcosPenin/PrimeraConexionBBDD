/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Vista;

import CRUD.Dao.MatriculaDao;
import CRUD.Model.Matricula;
import excepciones.AlumNoExisteException;
import excepciones.AsigNoExisteException;
import excepciones.MatriculaNoExisteException;
import excepciones.MatriculaRepetidaException;
import excepciones.OtroProfesorException;
import excepciones.ProfNoExisteException;
import java.util.Scanner;
import utilidades.ControlData;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaDatos {

    static Scanner sc = new Scanner(System.in);
    MatriculaDao dao = new MatriculaDao();

    /**
     * Devuelve una asignatura en base a los datos introducidos
     * @return
     * @throws ProfNoExisteException
     * @throws AlumNoExisteException
     * @throws AsigNoExisteException
     * @throws MatriculaRepetidaException
     * @throws OtroProfesorException 
     */
    
    
    public Matricula datosRegistrar() throws ProfNoExisteException, AlumNoExisteException, AsigNoExisteException, MatriculaRepetidaException,OtroProfesorException {
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
            dao.comprobarProfesor(dni, idas);
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
        } catch(OtroProfesorException ex){
            throw new OtroProfesorException();
        }
        
        
        return matricula;
    }
/**
 * Devuelve una matrícula en base a los datos introducidos
 * @return
 * @throws MatriculaNoExisteException
 * @throws ProfNoExisteException 
 */
    
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

     /**
      * Devuelve una matrícula en base a los datos introducidos
      * @return
      * @throws MatriculaNoExisteException 
      */
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
