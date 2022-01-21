/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Dao.NotaDao;
import CRUD.Model.Matricula;
import CRUD.Model.Nota;
import static CRUD.Vista.MatriculaDatos.sc;
import excepciones.MatriculaNoExisteException;
import excepciones.NotaNoExisteException;
import excepciones.NotaRepetidaException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import utilidades.ControlData;

/**
 *
 * Esta clase es diferenc
 */
public class NotaDatos {

    static NotaDao dao = new NotaDao();

    /**
     * Devuelve una nota en base a los datos introducidos, comprobando si 
     * responde a una matrícula existente y si el formato de la fecha
     * introducida es correcto. 
     * @return
     * @throws MatriculaNoExisteException
     * @throws NotaRepetidaException 
     */
    
    public static Nota datosRegistrar() throws MatriculaNoExisteException, NotaRepetidaException {
        Matricula matricula = null;
        Nota nota = null;
        try {

            matricula = MatriculaDatos.datosBuscar();
            System.out.println("Introduce la nota");
            float nta = ControlData.lerFloat(sc);
            Date fecha = ControlData.pedirFecha();
            NotaDao.comprobarNota(matricula, fecha);

            nota = new Nota(matricula.getIdal(), matricula.getIdas(), nta, fecha);

        } catch (MatriculaNoExisteException ex) {
            throw new MatriculaNoExisteException();
        } catch (NotaRepetidaException ex) {
            throw new NotaRepetidaException();
        }
        return nota;
    }

    /**
     * Devuelve una nota en base a los datos introducidos
     * @return
     * @throws NotaNoExisteException
     * @throws MatriculaNoExisteException 
     */
    
    public static Nota datosBuscar() throws NotaNoExisteException, MatriculaNoExisteException {
        Matricula matricula = null;
        Nota nota = null;

        matricula = MatriculaDatos.datosBuscar();
        Date fecha = ControlData.pedirFecha2();

        if (dao.buscar(matricula, fecha) != null) {
            nota = dao.buscar(matricula, fecha);
        } else {
            throw new NotaNoExisteException();
        }
        return nota;

    }

    /**
     * Devuelve una nota en base a los datos introducidos. 
     * @return
     * @throws NotaNoExisteException
     * @throws MatriculaNoExisteException 
     */
    
    public static Nota datosActualizar() throws NotaNoExisteException, MatriculaNoExisteException {
        Nota nota = null;

        try {
            nota = datosBuscar();
            System.out.println("Introduce la nueva nota");
            float nta = ControlData.lerFloat(sc);
            nota.setNota(nta);
        } catch (NotaNoExisteException ex) {
            throw new NotaNoExisteException();

        }
        return nota;
    }

}
