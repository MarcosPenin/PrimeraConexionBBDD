package aplicacion;

import CRUD.Creation.CrearTablas;
import CRUD.Connection.Conexion;
import CRUD.Vista.VerMenu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programa que crea una base de datos para un instituto, permitiendo gestionar
 * altas, bajas y modificaciones de la misma e implementando un patrón MMVC-CRUD-DAO
 *
 * @author github.com/MarcosPenin
 */
public class AppConexionInstituto {

    //El main se conecta a la base de datos, carga la creación de tablas y abre el menú principal   
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInStance();
        CrearTablas.crearTabla(Conexion.sentencia);
        VerMenu.menuPrincipal();
        Conexion.close();

    }
}
