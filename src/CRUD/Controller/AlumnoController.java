/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Controller;

import CRUD.Dao.AlumnoDao;
import CRUD.Dao.ProfesorDao;
import CRUD.Model.Alumno;
import CRUD.Model.Profesor;
import CRUD.Vista.AlumnoDatos;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.Mensajes;
import CRUD.Vista.ProfesorDatos;
import CRUD.Vista.ProfesorVista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class AlumnoController {

    static Scanner sc = new Scanner(System.in);
    static AlumnoVista vista = new AlumnoVista();
    static AlumnoDao dao=new AlumnoDao();

    public static void registrar() {
        int idal = dao.obtenerIdal();
        Alumno alumno = AlumnoDatos.datosRegistrar(idal);
        dao.registrar(alumno);
    }

    public static void buscar() {
       int idal=AlumnoDatos.datosIdal();
       Alumno x= dao.buscar(idal);
       vista.verAlumno(x);
    }

    public static void actualizar() {
        int idal=AlumnoDatos.datosIdal();
        if(dao.buscar(idal)!=null){      
        Alumno alumno=AlumnoDatos.datosActualizar(idal);
        dao.actualizar(alumno);
        }else{
            Mensajes.alumnoNoExiste();
        }
    }

    public static void eliminar() {
        int idal=AlumnoDatos.datosIdal();
        if(dao.buscar(idal)!=null){
               dao.eliminar(idal);        
        }else{
            Mensajes.alumnoNoExiste();
        }
           
    }

    public static void obtener() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos = dao.obtener();
        vista.verAlumnos(alumnos);
    }
}
