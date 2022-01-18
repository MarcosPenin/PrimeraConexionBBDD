/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Controller;

import CRUD.Dao.NotaDao;
import CRUD.Dao.ProfesorDao;
import CRUD.Model.Nota;
import CRUD.Model.Profesor;
import CRUD.Vista.NotaDatos;
import CRUD.Vista.NotaVista;
import CRUD.Vista.ProfesorDatos;
import CRUD.Vista.ProfesorVista;
import excepciones.MatriculaNoExisteException;
import excepciones.NotaNoExisteException;
import excepciones.NotaRepetidaException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class NotaController {

    static Scanner sc = new Scanner(System.in);
    static NotaDao dao = new NotaDao();
    static NotaVista vista = new NotaVista();

    public static void registrar() {
        try {
            Nota nota = NotaDatos.datosRegistrar();
            dao.registrar(nota);
        } catch (MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (NotaRepetidaException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void buscar() {
        try {
            Nota nota = NotaDatos.datosBuscar();
            vista.verNota(nota);
        } catch (NotaNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void actualizar() {

        try {
            Nota nota = NotaDatos.datosActualizar();
        } catch (NotaNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminar() {

        Nota nota;
        try {
            nota = NotaDatos.datosBuscar();
            dao.eliminar(nota);
        } catch (NotaNoExisteException ex) {
            System.out.println(ex.getMessage());
        } catch (MatriculaNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

public static void obtener() {
        List<Nota> notas = new ArrayList<>();
        notas = dao.obtener();      
        vista.verNotas(notas);
    }
 
}
