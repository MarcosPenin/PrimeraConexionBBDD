
package excepciones;

/**
 *
 * @author a20marcosgp
 */
public class AlumNoExisteException extends Exception {
 
    public AlumNoExisteException() {
        super("Lo siento, el alumno que ha introducido no está registrado");
    }
    
    
}
