
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
