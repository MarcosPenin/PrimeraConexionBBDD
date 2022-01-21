package CRUD.Connection;

import CRUD.Creation.CrearTablas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Conexión a la base de datos integrando el patrón singleton
 */
public class Conexion {

    public static Statement sentencia = null;
    public static Connection conexion = null;
    private static Conexion instance = null;

    public static Conexion getInStance() {

        if (instance == null) {
            instance = new Conexion();
        }else try {
            if(conexion.isClosed()){
                instance = new Conexion();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
    
    private Conexion() {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3307/auxiliar?user=root&password=usbw";

        try {
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }

    }

    public static String close() {
        try {
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Conexión cerrada";
    }

}
