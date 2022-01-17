/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.IDao;

import CRUD.Model.Nota;
import CRUD.Model.Profesor;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface INotaDao {
 
        public void registrar(Nota nota);
    public List<Nota> obtener();
    public Nota buscar(String dni);
    public void actualizar(String dni, Nota nota);
    public void eliminar(String dni);
    
    
}
