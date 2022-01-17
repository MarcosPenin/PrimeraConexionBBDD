/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Model.Alumno;
import CRUD.Model.Asignatura;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AsignaturaVista {
      public void verAsignaturas(List<Asignatura> asignaturas) {
        for (Asignatura x : asignaturas) {
            System.out.println("Datos de la asignatura: " + x.toString());
        }
    }

    public void verAsignatura(Asignatura asignatura) {

        if (asignatura != null) {
            System.out.println("Datos de la asignatura: " + asignatura.toString());
        } else {
            System.out.println("La asignatura buscada no existe");
        }

    }
}
