/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Controller;


import CRUD.Dao.AsignaturaDao;

import CRUD.Model.Asignatura;
import CRUD.Vista.AsignaturaDatos;
import CRUD.Vista.AsignaturaVista;
import CRUD.Vista.Mensajes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class AsignaturaController {

    static Scanner sc = new Scanner(System.in);
    static AsignaturaVista vista = new AsignaturaVista();
    static AsignaturaDao dao = new AsignaturaDao();

    public static void registrar() {
        int idas = dao.obtenerIdas();
        Asignatura asignatura = AsignaturaDatos.datosRegistrar(idas);
        dao.registrar(asignatura);
    }

    public static void buscar() {
        int idas = AsignaturaDatos.datosIdas();
        Asignatura x = dao.buscar(idas);
        vista.verAsignatura(x);
    }

    public static void actualizar() {
        int idas = AsignaturaDatos.datosIdas();
        if (dao.buscar(idas) != null) {

            Asignatura asignatura = AsignaturaDatos.datosActualizar(idas);
            dao.actualizar(asignatura);
        } else {
            Mensajes.asignaturaNoExiste();
        }
    }

    public static void eliminar() {
        int idas = AsignaturaDatos.datosIdas();
        if (dao.buscar(idas) != null) {
            dao.eliminar(idas);
        } else {
            Mensajes.asignaturaNoExiste();
        }
    }

    public static void obtener() {       
        List<Asignatura> asignaturas =  dao.obtener();
        vista.verAsignaturas(asignaturas);
    }
    
    public static void verProfesores(){
        int idas=AsignaturaDatos.datosIdas();      
        dao.verProfesores(idas); 
    }
    
    
    
    
    
}
