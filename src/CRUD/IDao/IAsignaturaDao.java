package CRUD.IDao;

import CRUD.Model.Asignatura;
import CRUD.Model.Profesor;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IAsignaturaDao {

    public void registrar(Asignatura asignatura);

    public List<Asignatura> obtener();

    public Asignatura buscar(int idas);

    public void actualizar(Asignatura asignatura);

    public void eliminar(int idas);

}
