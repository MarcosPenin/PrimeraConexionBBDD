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
public class AsigNoExisteException extends Exception {
    
    public AsigNoExisteException() {
        super("Lo siento, la asignatura que ha introducido no está registrada");
    }
    
    
}
