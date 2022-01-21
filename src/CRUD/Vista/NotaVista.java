package CRUD.Vista;

import CRUD.Model.Matricula;
import CRUD.Model.Nota;
import java.util.List;

/**
 *
 * @author usuario
 */
public class NotaVista {

    /**
     * Imprime todas las notas registradas
     *
     * @param notas
     */
    public void verNotas(List<Nota> notas) {
        for (Nota x : notas) {
            System.out.println("Datos de la nota: " + x.toString());
        }
    }

    /**
     * Imprime un profesor en concreto
     *
     * @param nota
     */
    public void verNota(Nota nota) {

        if (nota != null) {
            System.out.println("Datos de la matrícula: " + nota.toString());
        } else {
            System.out.println("La matrícula buscada no existe");
        }
    }
}
