
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.IDao.IProfesorDao;
import CRUD.Model.Asignatura;
import CRUD.Model.Matricula;
import CRUD.Model.Profesor;
import CRUD.Vista.AsignaturaVista;
import CRUD.Vista.Mensajes;
import CRUD.Vista.ProfesorVista;
import excepciones.DniInvalido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.ControlData;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            Mensajes.exito();
        } catch (DniInvalido e) {
            System.out.println("No se ha podido guardar, el DNI no es válido");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se ha podido guardar, ya existe otro registro con ese mismo DNI");
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesorDao, método registrar" + e);
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
            System.out.println("Error: Clase ProfesorDao, método obtener");
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
    public void actualizar(Profesor profesor) {

        String sql = "UPDATE PROFESORES SET nombre='" + profesor.getNombre() + "', titulacion='"
                + profesor.getTitulacion() + "'" + " WHERE dni='" + profesor.getDni() + "'";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesorDao, método actualizar");
        }
    }

    @Override
    public void eliminar(String dni) {
        String sql = "DELETE FROM PROFESORES WHERE dni='" + dni + "'";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase ProfesorDao, método eliminar");
            e.printStackTrace();
        }
    }   
    

    public void verAsignaturas(String dni) {

        boolean flag=false;
        MatriculaDao md = new MatriculaDao();
        AsignaturaDao ad = new AsignaturaDao();
        AsignaturaVista vs = new AsignaturaVista();
        List<Matricula> matriculas = md.obtener();
        List<Asignatura> asignaturas = ad.obtener();

        Set<Integer> codAsignaturas = new HashSet<>();

        for (Matricula x : matriculas) {
            if (x.getDni().equalsIgnoreCase(dni)) {
                codAsignaturas.add(x.getIdas());
            }
        }

        for (Integer y : codAsignaturas) {
            for (Asignatura z : asignaturas) {
                if (y == z.getIdas()) {
                    vs.verAsignatura(z);
                    flag=true;
                }
            }
        }
        if(!flag){
            System.out.println("Ese profesor no tiene registrada ninguna asignatura");
        }
    }

}
