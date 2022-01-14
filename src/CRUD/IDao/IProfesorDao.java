/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    public void actualizar(String dni, Profesor profesor);
    public void eliminar(String dni);

}
