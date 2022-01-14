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

    public void exito(){
        System.out.println("Operación realizada con éxito");
    }
   
    public void verProfesores(List<Profesor> profesores) {
        for (Profesor x : profesores) {
            System.out.println("Datos del Cliente: " + x.toString());
        }
    }

    public void verProfesor(Profesor profesor) {

        if (profesor != null) {
            System.out.println("Datos del Cliente: " + profesor.toString());
        } else {
            System.out.println("El profesor buscado no existe");
        }

    }
}
