/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author usuario
 */
public class MatriculaNoExisteException extends Exception {
       
      public MatriculaNoExisteException() {
        super("Lo siento, la matrícula que ha introducido no está registrada");
    }
    
    
}
