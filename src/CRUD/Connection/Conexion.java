package CRUD.Connection;

import CRUD.Creation.CrearTablas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a20marcosgp
 */
public class Conexion {

    public static Statement sentencia = null;
    public static Connection conexion = null;
    private static Conexion instance = null;

    public static Conexion getInStance() {

        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public static Connection conectar() {

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

        return conexion;
    }
}
