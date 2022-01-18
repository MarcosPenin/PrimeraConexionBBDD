/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.IDao.IAsignaturaDao;
import CRUD.Model.Asignatura;
import CRUD.Model.Matricula;
import CRUD.Model.Profesor;
import CRUD.Vista.AsignaturaVista;
import CRUD.Vista.Mensajes;
import CRUD.Vista.ProfesorVista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                + "','" + asignatura.getCodigoAsignatura() + "','" + asignatura.getCodigoAsignatura() + "')";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se puede guardar esa asignatura");
        } catch (SQLException e) {
            System.out.println("Error: Clase AsignaturaDao, método registrar" + e);
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
            System.out.println("Error: Clase AsignaturaDao, método obtener");
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

        String sql = "UPDATE ASIGNATURAS SET codigoAsignatura='" + asignatura.getCodigoAsignatura() + "', nombreCiclo='"
                + asignatura.getNombreCiclo() + "'" + " WHERE idas='" + asignatura.getIdas() + "'";

        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase AsignaturaDao, método actualizar");
        }
    }

    @Override
    public void eliminar(int idas) {
        String sql = "DELETE FROM ASIGNATURAS WHERE idas='" + idas + "'";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase AsignaturaDao, método eliminar");
            e.printStackTrace();
        }
    }

    public void verProfesores(int idas) {
        boolean flag=false;
        MatriculaDao md = new MatriculaDao();
        ProfesorDao pd = new ProfesorDao();
        ProfesorVista pv = new ProfesorVista();
        List<Matricula> matriculas = md.obtener();
        List<Profesor> profesores = pd.obtener();

        Set<String> listaDni = new HashSet<>();

        for (Matricula x : matriculas) {
            if (x.getIdas() == idas) {
                listaDni.add(x.getDni());
            }
        }
        for (String y : listaDni) {
            for (Profesor z : profesores) {
                if (y.equalsIgnoreCase(z.getDni())) {
                    pv.verProfesor(z);
                    flag=true;
                }
            }

        }
          if(!flag){
            System.out.println("Esa asignatura no tiene registrada ningún profesor");
        }
        
    }

}
