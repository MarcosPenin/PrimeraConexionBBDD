
package CRUD.Vista;

import CRUD.Model.Matricula;
import java.util.List;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaVista {
       public void verMatriculas(List<Matricula> matriculas) {
        for (Matricula x : matriculas) {
            System.out.println("Datos de la matrícula: " + x.toString());
        }
    }

    public void verMatricula(Matricula matricula) {

        if (matricula != null) {
            System.out.println("Datos de la matrícula: " + matricula.toString());
        } else {
            System.out.println("La matrícula buscada no existe");
        }
}}
