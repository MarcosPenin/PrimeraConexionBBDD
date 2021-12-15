
package primeraconexionbbdd;

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
       
        //Declaracion de conectores
        /*Connection conexion = null;*/
        Statement sentencia = null;
        ResultSet rstAux = null;
        
        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
        int cont = 0, op = 0;
        
        //Declaracion de driver y url
        String driver= "com.mysql.jdbc.Driver";       
        String url= "jdbc:mysql://localhost:3307/LIBRERIADANI?user=root&password=usbw";
               
        /*No es necesario desde la ultima versión
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontro el driver" + driver);
            System.exit(1);
        }*/
        try {
            Connection conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }
        CrearTablas.crearTabla(sentencia);
        
        
        do{
            System.out.println("*****************************");
            System.out.println("MENU");
            System.out.println("1. Inserción de nuevas filas");
            System.out.println("2. Borrar filas");
            System.out.println("3. Modificar filas");
            System.out.println("4. Realizar consultas");
            System.out.println("0. Salir");
            op=Integer.parseInt(lee.readLine());
            switch(op){
                case 0:
                    System.out.println("SALIENDO");
                    break;
                case 1:
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
        }while(op!=0);
    }

}

        
        
  