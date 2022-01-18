
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
