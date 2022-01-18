
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
