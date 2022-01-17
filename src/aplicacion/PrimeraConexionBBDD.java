package aplicacion;

import CRUD.Creation.CrearTablas;
import CRUD.Connection.Conexion;
import CRUD.Controller.ProfesorController;
import CRUD.Dao.ProfesorDao;
import CRUD.Model.Profesor;
import CRUD.Vista.VerMenu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.Menu;

public class PrimeraConexionBBDD {

    public static void main(String[] args) throws IOException {
        Conexion conexion = Conexion.getInStance();
        conexion.conectar();
        CrearTablas.crearTabla(Conexion.sentencia);
        VerMenu.menuPrincipal();
        
    } 


}
