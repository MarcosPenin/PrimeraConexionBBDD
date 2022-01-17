/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.IDao;

import CRUD.Model.Alumno;
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
