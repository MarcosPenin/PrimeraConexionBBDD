/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.IDao;

import CRUD.Model.Alumno;
import CRUD.Model.Profesor;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IAlumnoDao {
        public void registrar(Alumno alumno);
    public List<Alumno> obtener();
    public Alumno buscar(int idal);
    public void actualizar(Alumno alumno);
    public void eliminar(int idal);

    
    
    
}
