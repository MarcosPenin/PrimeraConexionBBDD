
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
