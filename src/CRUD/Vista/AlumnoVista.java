/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Vista;

import CRUD.Model.Alumno;
import CRUD.Model.Profesor;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AlumnoVista {
    
    
    
    public void verAlumnos(List<Alumno> alumnos) {
        for (Alumno x : alumnos) {
            System.out.println("Datos del Alumno: " + x.toString());
        }
    }

    public void verAlumno(Alumno alumno) {

        if (alumno != null) {
            System.out.println("Datos del alumno: " + alumno.toString());
        } else {
            System.out.println("El alumno buscado no existe");
        }

    }
    
    
    
}
