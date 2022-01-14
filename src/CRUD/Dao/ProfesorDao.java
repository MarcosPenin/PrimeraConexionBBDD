/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.IDao.IProfesorDao;
import CRUD.Model.Profesor;
import CRUD.Vista.ProfesorVista;
import excepciones.DniInvalido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.ControlData;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a20marcosgp
 */
public class ProfesorDao implements IProfesorDao {
    static Statement stm = Conexion.sentencia;
    static Connection con = Conexion.conexion;
    static ProfesorVista vista = new ProfesorVista();

    @Override
    public void registrar(Profesor profesor) {
        String sql = "INSERT INTO profesores (dni,nombre,titulacion) values ('" + profesor.getDni()
                + "','" + profesor.getNombre() + "','" + profesor.getTitulacion() + "')";
        try {
            ControlData.comprobarDni(profesor.getDni());
            stm.execute(sql);
            vista.exito();
        } catch (DniInvalido e) {
            System.out.println("No se ha podido guardar, el DNI no es válido");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se ha podido guardar, ya existe otro registro con ese mismo DNI");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImpl, método registrar" + e);
        }
    }

    @Override
    public List<Profesor> obtener() {

        ResultSet rs = null;
        String sql = "SELECT * FROM PROFESORES";
        List<Profesor> profesores = new ArrayList<>();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Profesor x = new Profesor();
                x.setDni(rs.getString(1));
                x.setNombre(rs.getString(2));
                x.setTitulacion(rs.getString(3));
                profesores.add(x);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
        }

        return profesores;
    }

    @Override
    public Profesor buscar(String dni) {
        Profesor x = null;
        List<Profesor> profesores = obtener();
        for (Profesor y : profesores) {
            if (y.getDni().equalsIgnoreCase(dni)) {
                x = y;
            }
        }
        return x;
    }

    @Override
    public void actualizar(String dni, Profesor profesor) {

        String sql = "UPDATE PROFESORES SET nombre='" + profesor.getNombre() + "', titulacion='"
                + profesor.getTitulacion() + "'" + " WHERE dni='" + profesor.getDni() + "'";
        try {
            stm.execute(sql);
            vista.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");          
        }
    }

    @Override
    public void eliminar(String dni) {
        String sql = "DELETE FROM CLIENTE WHERE dni='" + dni + "'";
        try {
            stm.execute(sql);
            vista.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
    }

}
