/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.IDao.IAsignaturaDao;
import CRUD.Model.Alumno;
import CRUD.Model.Asignatura;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.AsignaturaVista;
import CRUD.Vista.Mensajes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AsignaturaDao implements IAsignaturaDao {
    
      static Statement stm = Conexion.sentencia;
    static Connection con = Conexion.conexion;
    static AsignaturaVista vista = new AsignaturaVista();

    public int obtenerIdas() {
        List<Asignatura> asignatura = obtener();
        int idas = 0;

        for (Asignatura y : asignatura) {
            if (y.getIdas() > idas) {
                idas = y.getIdas();
            }
        }
        idas++;
        return idas;
    }

    @Override
    public void registrar(Asignatura asignatura) {
        String sql = "INSERT INTO asignaturas (idas,codigoAsignatura,nombreCiclo) values ('" + asignatura.getIdas()
                + "','" + asignatura.getCodigoAsignatura()+ "','" + asignatura.getCodigoAsignatura()+ "')";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se puede guardar esa asignatura");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImpl, método registrar" + e);
        }
    }

    @Override
    public List<Asignatura> obtener() {

        ResultSet rs = null;
        String sql = "SELECT * FROM ASIGNATURAS";
        List<Asignatura> asignaturas = new ArrayList<>();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Asignatura x = new Asignatura();
                x.setIdas(rs.getInt(1));
                x.setCodigoAsignatura(rs.getString(2));
                x.setNombreCiclo(rs.getString(3));
                asignaturas.add(x);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
        }

        return asignaturas;
    }

    @Override
    public Asignatura buscar(int idas) {
        Asignatura x = null;
        List<Asignatura> asignaturas = obtener();
        for (Asignatura y : asignaturas) {
            if (y.getIdas() == idas) {
                x = y;
            }
        }
        return x;
    }

    @Override
    public void actualizar(Asignatura asignatura) {

        String sql = "UPDATE ASIGNATURAS SET codigoAsignatura='" + asignatura.getCodigoAsignatura()+ "', nombreCiclo='"
                + asignatura.getNombreCiclo()+ "'" + " WHERE idas='" + asignatura.getIdas() + "'";

        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
        }
    }

    @Override
    public void eliminar(int idas) {
        String sql = "DELETE FROM ASIGNATURAS WHERE idas='" + idas + "'";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
    }
    
    
    
    
}
