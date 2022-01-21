package CRUD.Vista;

import CRUD.Model.Matricula;
import java.util.List;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaVista {

    /**
     * Imprime todas las matrículas registradas
     *
     * @param matriculas
     */
    public void verMatriculas(List<Matricula> matriculas) {
        for (Matricula x : matriculas) {
            System.out.println("Datos de la matrícula: " + x.toString());
        }
    }

    /**
     * Imprime una matrícula concreta
     *
     * @param matricula
     */
    public void verMatricula(Matricula matricula) {

        if (matricula != null) {
            System.out.println("Datos de la matrícula: " + matricula.toString());
        } else {
            System.out.println("La matrícula buscada no existe");
        }
    }
}
