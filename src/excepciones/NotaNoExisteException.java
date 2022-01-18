/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author usuario
 */
public class NotaNoExisteException extends Exception {
     public NotaNoExisteException() {
        super("Lo siento, la nota que busca no está registrada");
    }
}
