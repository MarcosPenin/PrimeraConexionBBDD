/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Dao;

import CRUD.Connection.Conexion;
import static CRUD.Dao.ProfesorDao.stm;
import CRUD.IDao.IAlumnoDao;
import CRUD.IDao.IProfesorDao;
import CRUD.Model.Alumno;
import CRUD.Model.Profesor;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.Mensajes;
import CRUD.Vista.ProfesorVista;
import excepciones.DniInvalido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilidades.ControlData;

/**
 *
 * @author usuario
 */
public class AlumnoDao implements IAlumnoDao {

    static Statement stm = Conexion.sentencia;
    static Connection con = Conexion.conexion;
    static AlumnoVista vista = new AlumnoVista();

    public int obtenerIdal() {
        List<Alumno> alumnos = obtener();
        int idal = 0;

        for (Alumno y : alumnos) {
            if (y.getIdal() > idal) {
                idal = y.getIdal();
            }
        }
        idal++;
        return idal;
    }

    @Override
    public void registrar(Alumno alumno) {
        String sql = "INSERT INTO alumnos (idal,codigoAlumno,nombre) values ('" + alumno.getIdal()
                + "','" + alumno.getCodigoAlumno() + "','" + alumno.getNombre() + "')";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se puede guardar ese alumno");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImpl, método registrar" + e);
        }
    }

    @Override
    public List<Alumno> obtener() {

        ResultSet rs = null;
        String sql = "SELECT * FROM ALUMNOS";
        List<Alumno> alumnos = new ArrayList<>();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Alumno x = new Alumno();
                x.setIdal(rs.getInt(1));
                x.setCodigoAlumno(rs.getString(2));
                x.setNombre(rs.getString(3));
                alumnos.add(x);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
        }

        return alumnos;
    }

    @Override
    public Alumno buscar(int idal) {
        Alumno x = null;
        List<Alumno> alumnos = obtener();
        for (Alumno y : alumnos) {
            if (y.getIdal() == idal) {
                x = y;
            }
        }
        return x;
    }

    @Override
    public void actualizar(Alumno alumno) {

        String sql = "UPDATE ALUMNOS SET codigoAlumno='" + alumno.getCodigoAlumno() + "', nombre='"
                + alumno.getNombre() + "'" + " WHERE idal='" + alumno.getIdal() + "'";

            try {
                stm.execute(sql);
                Mensajes.exito();
            } catch (SQLException e) {
                System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            }
        }
    

    @Override
    public void eliminar(int idal
    ) {
        String sql = "DELETE FROM ALUMNOS WHERE idal='" + idal + "'";

        
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método eliminar");
            e.printStackTrace();
        }
    }

}
