/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author usuario
 */
public class NotaRepetidaException extends Exception{
     public NotaRepetidaException() {
        super("Lo siento, ya hay una nota registrada para ese alumno en esa asignatura en esa fecha");
    }
}
