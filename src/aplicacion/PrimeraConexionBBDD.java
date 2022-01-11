package aplicacion;

import CRUD.Creation.CrearTablas;
import CRUD.Connection.Conexion;
import CRUD.Dao.ProfesorDao;
import CRUD.Model.Profesor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimeraConexionBBDD {

    public static void main(String[] args) throws IOException {

      
        ResultSet rstAux = null;
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int cont = 0, op = 0;

        Conexion conexion=Conexion.getInStance();
        conexion.conectar();
        CrearTablas.crearTabla(Conexion.sentencia);
                        
                      
        do {
            System.out.println("*****************************");
            System.out.println("MENU");
            System.out.println("1. Inserción de nuevas filas");
            System.out.println("2. Borrar filas");
            System.out.println("3. Modificar filas");
            System.out.println("4. Realizar consultas");
            System.out.println("0. Salir");
            op = Integer.parseInt(lee.readLine());
            switch (op) {
                case 0:
                    System.out.println("SALIENDO");
                    break;
                case 1:
                    Profesor profesor=new Profesor("DNI", "NOMBRE", "TITULACION");
                    ProfesorDao x=new ProfesorDao();
                    x.registrar(profesor);
                    
                    
//                    InsertarFilas.insertarFila(sentencia, rstAux, lee);
                    break;
                case 2:
//                    BorrarFilas.borrarFila(sentencia, rstAux, lee);
                    break;
                case 3:
//                    ModificarFilas.modificarFila(sentencia, rstAux, lee);
                    break;
                case 4:
//                    Consultar.consulta(sentencia, rstAux, lee);
                    break;
            }
        } while (op != 0);
    }

}
