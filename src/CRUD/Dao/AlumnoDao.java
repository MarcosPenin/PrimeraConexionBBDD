
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.IDao.IAlumnoDao;
import CRUD.Model.Alumno;
import CRUD.Model.Nota;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.Mensajes;
import CRUD.Vista.NotaVista;
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
            System.out.println("Error: Clase AlumnoDao, método registrar" + e);
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
            System.out.println("Error: Clase AlumnoDao, método obtener");
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
                System.out.println("Error: Clase AlumnoDao, método actualizar");
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
            System.out.println("Error: Clase AlumnoDao, método eliminar");
            e.printStackTrace();
        }
    }
    
    public void verNotas(int idal){
        boolean flag=false;
        NotaDao nd=new NotaDao();
        NotaVista vd= new NotaVista();
        List<Nota> notas=nd.obtener();     
        for(Nota x:notas){
            if(x.getIdal()==idal){
                vd.verNota(x);
                flag=true;
            }
        } 
         if(!flag){
            System.out.println("Ese alumno no tiene registrada ninguna nota");
        }
        
    }
    

}
