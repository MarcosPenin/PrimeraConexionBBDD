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
public class ProfNoExisteException extends Exception {
    public ProfNoExisteException() {
        super("Lo siento, el profesor que ha introducido no está registrado");
    }
    
}
