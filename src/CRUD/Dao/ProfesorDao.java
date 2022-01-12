/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD.Dao;

import CRUD.Connection.Conexion;
import CRUD.Model.Profesor;
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
public class ProfesorDao {

    static Statement stm = Conexion.sentencia;
    static Connection con = Conexion.conexion;

    public boolean registrar(Profesor profesor) {
        boolean registrar = false;
        String sql = "INSERT INTO profesores (dni,nombre,titulacion) values ('" + profesor.getDni()
                + "','" + profesor.getNombre() + "','" + profesor.getTitulacion() + "')";
        try {
            ControlData.comprobarDni(profesor.getDni());
            stm.execute(sql);
            registrar = true;
        } catch (DniInvalido e) {
            System.out.println("No se ha podido guardar, el DNI no es válido");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se ha podido guardar, ya existe otro registro con ese mismo DNI");
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImpl, método registrar" + e);
        }

        return registrar;
    }

    public List<Profesor> obtener() {

        ResultSet rs = null;

        String sql = "SELECT * FROM PROFESORES";

        List<Profesor> profesores = new ArrayList<Profesor>();

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
            e.printStackTrace();
        }

        return profesores;
    }

    
   public Profesor buscar(String dni){
       Profesor x=null;
       List<Profesor> profesores=obtener();
       for (Profesor y:profesores){
           if(y.getDni().equalsIgnoreCase(dni)){
              x=y;
           }
       }
      return x;
   }
    
    
       public boolean actualizar(String dni,Profesor profesor ) {

        boolean actualizar=false;
        

        String sql="UPDATE PROFESORES SET dni='"
        
        
        String sql2="UPDATE CLIENTE SET id='"+cliente.getId()+"', nombre='"+cliente.getNombre()+"', apellido1='"
                +cliente.getApellido()+"'" +" WHERE dni='"+cliente.getDni()+"'";
        try {
            connect=Conexion.conectar();
            stm=connect.createStatement();
            stm.execute(sql);
            actualizar=true;
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método actualizar");
            e.printStackTrace();
        }		
        return actualizar;
    }
    
    
    
    
    
}
