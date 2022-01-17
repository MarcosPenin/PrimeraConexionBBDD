/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Controller;

import CRUD.Dao.AlumnoDao;
import CRUD.Dao.MatriculaDao;
import CRUD.Model.Alumno;
import CRUD.Model.Matricula;
import CRUD.Vista.AlumnoDatos;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.MatriculaDatos;
import CRUD.Vista.MatriculaVista;
import CRUD.Vista.Mensajes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaController {
    
     static Scanner sc = new Scanner(System.in);
    static MatriculaVista vista = new MatriculaVista();
    static MatriculaDao dao=new MatriculaDao();

    public static void registrar() {
        Matricula matricula = MatriculaDatos.datosRegistrar();
        dao.registrar(matricula);
    }

    public static void buscar(int idal,int idas) {        
       Matricula matricula= dao.buscar(idal,idas);
       vista.verMatricula(matricula);
    }

   
    
    public static void actualizar(int idal,int idas) {
       
        if(dao.buscar(idal,idas)!=null){      
        Matricula matricula=dao.buscar(idal, idas);
        dao.actualizar(matricula);
        }
    }

    public static void eliminar(int idal,int idas) {
     
        if(dao.buscar(idal,idas)!=null){
            Matricula matricula=dao.buscar(idal, idas);
               dao.eliminar(matricula);        
        }else{
            Mensajes.alumnoNoExiste();
        }
           
    }

    public static void obtener() {
        List<Matricula> matriculas = new ArrayList<Matricula>();
        matriculas = dao.obtener();
        vista.verMatriculas(matriculas);
    }
    
    
    
}
