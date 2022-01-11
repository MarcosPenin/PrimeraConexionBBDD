/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.Model.Profesor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a20marcosgp
 */
public class ProfesorDao {

    public boolean registrar(Profesor profesor) {
        boolean registrar = false;

        Statement stm = Conexion.sentencia;
        Connection con = Conexion.conexion;
        String sql = "INSERT INTO profesores (dni,nombre,titulacion,dni) values ('" + profesor.getDni()
                + "','" + profesor.getNombre() + "','" + profesor.getTitulacion() + "')";

        try {
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImpl, método registrar");
            e.printStackTrace();
        }
        return registrar;

    }
}
