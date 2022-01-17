/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaRepetidaException extends Exception {
     public MatriculaRepetidaException() {
        super("Lo siento, ese alumno ya está registrado en la misma asignatura con otro profesor");
    }
}
