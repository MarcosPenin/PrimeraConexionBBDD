
package excepciones;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaRepetidaException extends Exception {
     public MatriculaRepetidaException() {
        super("Lo siento, ese alumno ya está registrado en la misma asignatura con otro profesor");
    }
}
