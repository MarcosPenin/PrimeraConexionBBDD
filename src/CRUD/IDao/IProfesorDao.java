package CRUD.IDao;

import CRUD.Model.Profesor;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IProfesorDao {

    public void registrar(Profesor profesor);

    public List<Profesor> obtener();

    public Profesor buscar(String dni);

    public void actualizar(Profesor profesor);

    public void eliminar(String dni);

}
