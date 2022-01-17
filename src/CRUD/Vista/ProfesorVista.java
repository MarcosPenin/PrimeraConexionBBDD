/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Vista;

import CRUD.Model.Profesor;
import java.util.List;


/**
 *
 * @author a20marcosgp
 */
public class ProfesorVista {

    public void verProfesores(List<Profesor> profesores) {
        for (Profesor x : profesores) {
            System.out.println("Datos del Profesor: " + x.toString());
        }
    }

    public void verProfesor(Profesor profesor) {

        if (profesor != null) {
            System.out.println("Datos del Profesor: " + profesor.toString());
        } else {
            System.out.println("El profesor buscado no existe");
        }

    }
}
