
package CRUD.IDao;


import CRUD.Model.Matricula;
import java.util.List;

/**
 *
 * @author a20marcosgp
 */
public interface IMatriculaDao {

    public void registrar(Matricula matricula);

    public List<Matricula> obtener();

    public Matricula buscar(int idal, int idas);

    public void actualizar(Matricula matricula);

    public void eliminar(Matricula matricula);

}
