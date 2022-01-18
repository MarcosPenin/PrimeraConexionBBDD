package CRUD.IDao;

import CRUD.Model.Matricula;
import CRUD.Model.Nota;
import CRUD.Model.Profesor;
import java.util.Date;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface INotaDao {

    public void registrar(Nota nota);

    public List<Nota> obtener();

    public Nota buscar(Matricula matricula, Date fecha);

    public void actualizar(Nota nota);

    public void eliminar(Nota nota);

}
