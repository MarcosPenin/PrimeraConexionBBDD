/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Controller;

import CRUD.Dao.ProfesorDao;
import CRUD.Model.Profesor;
import CRUD.Vista.ProfesorDatos;
import CRUD.Vista.ProfesorVista;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class NotaController {

    static Scanner sc = new Scanner(System.in);
    static ProfesorVista vista = new ProfesorVista();

    public static void registrar() {
        Profesor profesor = ProfesorDatos.datosRegistrar();
        ProfesorDao dao = new ProfesorDao();
        dao.registrar(profesor);
    }

    public static void buscar() {
        String dni = ProfesorDatos.datosDni();
        ProfesorDao dao = new ProfesorDao();
        Profesor x = dao.buscar(dni);    
        vista.verProfesor(x);

    }

    public static void actualizar() {
        String dni = ProfesorDatos.datosDni();
        Profesor profesor = ProfesorDatos.datosActualizar(dni);
        ProfesorDao dao = new ProfesorDao();
        dao.actualizar(profesor);

    }

    public static void eliminar() {
        String dni = ProfesorDatos.datosDni();
        ProfesorDao dao = new ProfesorDao();
        dao.eliminar(dni);
    }

    public static void obtener() {
        List<Profesor> profesores = new ArrayList<Profesor>();
        ProfesorDao dao = new ProfesorDao();
        profesores = dao.obtener();      
        vista.verProfesores(profesores);
    }
 
}
