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
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class NotaDatos {

    static NotaDao dao = new NotaDao();

    public static Nota datosRegistrar() throws MatriculaNoExisteException, NotaRepetidaException {
        Matricula matricula = null;
        Nota nota = null;
        try {

            matricula = MatriculaDatos.datosBuscar();
            System.out.println("Introduce la nota");
            float nta = ControlData.lerFloat(sc);
            System.out.println("Introduce el año");
            int ano = ControlData.lerInt(sc)-1900;
            System.out.println("Introduce el mes");
            int mes = ControlData.lerInt(sc)-1;
            System.out.println("Introduce el día");
            int dia = ControlData.lerInt(sc);
            Date fecha = new Date(ano, mes, dia);
         
            NotaDao.comprobarNota(matricula, fecha);

            nota = new Nota(matricula.getIdal(), matricula.getIdas(), nta, fecha);

        } catch (MatriculaNoExisteException ex) {
            throw new MatriculaNoExisteException();
        } catch (NotaRepetidaException ex) {
            throw new NotaRepetidaException();
        }
        return nota;
    }

    public static Nota datosBuscar() throws NotaNoExisteException, MatriculaNoExisteException {
        Matricula matricula = null;
        Nota nota=null;
        matricula = MatriculaDatos.datosBuscar();
        System.out.println("Introduce el año");
        int ano = ControlData.lerInt(sc);
        System.out.println("Introduce el mes");
        int mes = ControlData.lerInt(sc);
        System.out.println("Introduce el día");
        int dia = ControlData.lerInt(sc);
        Date fecha = new Date(ano, mes, dia);
        
        if(dao.buscar(matricula, fecha)!=null){
            nota=dao.buscar(matricula, fecha);
        }else{
            throw new NotaNoExisteException();
        }

        return nota;

    }

      public static Nota datosActualizar() throws NotaNoExisteException, MatriculaNoExisteException {
        Nota nota = null;

        try {
            nota = datosBuscar();
            System.out.println("Introduce la nueva nota");
            float nta=ControlData.lerFloat(sc);
           nota.setNota(nta);
        } catch (NotaNoExisteException ex) {
            throw new NotaNoExisteException();
        
        } 
        return nota;
    }
    
    
    
    
    
}
