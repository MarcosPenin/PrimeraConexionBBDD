
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.IDao.IMatriculaDao;
import CRUD.Model.Matricula;
import CRUD.Vista.MatriculaVista;
import CRUD.Vista.Mensajes;
import excepciones.AlumNoExisteException;
import excepciones.AsigNoExisteException;
import excepciones.MatriculaRepetidaException;
import excepciones.OtroProfesorException;
import excepciones.ProfNoExisteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author a20marcosgp
 */
public class MatriculaDao implements IMatriculaDao{
 
     static Statement stm = Conexion.sentencia;
    static Connection con = Conexion.conexion;
    static MatriculaVista vista = new MatriculaVista();
    static Scanner sc=new Scanner(System.in);
    
     
     public static void comprobarDni(String dni) throws ProfNoExisteException {
        ProfesorDao pd = new ProfesorDao();
        if ((pd.buscar(dni)) == null) {
            throw new ProfNoExisteException();
        } else {          
        }
    }

    public static void comprobarIdal(int idal) throws AlumNoExisteException {      
        AlumnoDao ad = new AlumnoDao();
        if ((ad.buscar(idal)) == null) {
             throw new AlumNoExisteException();
        } 
    }

    public static void comprobarIdas(int idas) throws AsigNoExisteException {
        AlumnoDao ad = new AlumnoDao();
        if ((ad.buscar(idas)) == null) {
           throw new AsigNoExisteException();
        } 
    }

    public static void comprobarCoherencia(Matricula matricula) throws MatriculaRepetidaException {
        MatriculaDao md = new MatriculaDao();
        if (md.buscar(matricula.getIdal(), matricula.getIdas()) != null) {
            throw new MatriculaRepetidaException();
        }
    }
    
    public void comprobarProfesor(String dni,int idas) throws OtroProfesorException{
        List<Matricula> matriculas=obtener();
        for(Matricula x:matriculas){
            if(x.getIdas()==idas&&x.getDni()!=dni){
                throw new OtroProfesorException();
            }
        }}
        
    
    @Override
    public void registrar(Matricula matricula) {
        String sql = "INSERT INTO profesoresalumnosasignaturas (dni,idal,idas) values ('" + matricula.getDni()
                + "','" + matricula.getIdal()+ "','" + matricula.getIdas()+ "')";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se puede guardar esa matrícula");
        } catch (SQLException e) {
            System.out.println("Error: Clase MatriculaDao, método registrar" + e);
        }
    }

    @Override
    public  List<Matricula> obtener() {

        ResultSet rs = null;
        String sql = "SELECT * FROM profesoresalumnosasignaturas";
        List<Matricula> matriculas = new ArrayList<>();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {
             
                Matricula x = new Matricula();
                x.setDni(rs.getString(1));
                x.setIdal(rs.getInt(2));
                x.setIdas(rs.getInt(3));
                matriculas.add(x);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase MatriculaDao, método obtener");
        }
 

        return matriculas;
    }

    @Override
    public Matricula buscar(int idal,int idas) {
        Matricula x = null;
        List<Matricula> matriculas = obtener();
        for (Matricula y : matriculas) {
            if (y.getIdal() == idal && y.getIdas()==idas) {
                x = y;
            }
        }
        return x;
    }

    @Override
    public void actualizar(Matricula matricula) {

        String sql = "UPDATE profesoresalumnosasignaturas SET dni='" + matricula.getDni()+ "'" + " WHERE idal='" + matricula.getIdal() + "' and idas='"+matricula.getIdas()+"'";

            try {
                stm.execute(sql);
                Mensajes.exito();
            } catch (SQLException e) {
                System.out.println("Error: Clase MatriculaDao, método actualizar");
            }
        }
    

    @Override
    public void eliminar(Matricula matricula
    ) {
        int idal=matricula.getIdal();
        int idas=matricula.getIdas();        
        
        String sql = "DELETE FROM profesoresalumnosasignaturas WHERE idal='" + idal + "' and idas='"+idas+"'";

        
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase MatriculaDao, método eliminar");
            e.printStackTrace();
        }
    } 
    }
    
    
    

