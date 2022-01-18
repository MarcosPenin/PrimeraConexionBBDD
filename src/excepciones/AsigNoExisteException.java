
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
