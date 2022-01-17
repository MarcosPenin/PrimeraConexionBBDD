package aplicacion;

import CRUD.Creation.CrearTablas;
import CRUD.Connection.Conexion;
import CRUD.Vista.VerMenu;


public class PrimeraConexionBBDD {

    public static void main(String[] args) {
        Conexion conexion = Conexion.getInStance();
        conexion.conectar();
        CrearTablas.crearTabla(Conexion.sentencia);
        VerMenu.menuPrincipal();       
    } 


}
