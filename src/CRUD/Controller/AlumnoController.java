
package CRUD.Controller;


import CRUD.Dao.AlumnoDao;
import CRUD.Model.Alumno;
import CRUD.Vista.AlumnoDatos;
import CRUD.Vista.AlumnoVista;
import CRUD.Vista.Mensajes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Clase controlador de la clase modelo Alumno. Para cada caso, llama a AlumnoDatos para 
 * pedir los datos que necesida, a AlumnoDao para operar con la base de datos
 * y cuando es necesario a AlumnoVista para mostrar registros.
 */
public class AlumnoController {

    static Scanner sc = new Scanner(System.in);
    static AlumnoVista vista = new AlumnoVista();
    static AlumnoDao dao=new AlumnoDao();

    public static void registrar() {
        int idal = dao.obtenerIdal();
        Alumno alumno = AlumnoDatos.datosRegistrar(idal);
        dao.registrar(alumno);
    }

    public static void buscar() {
       int idal=AlumnoDatos.datosIdal();
       Alumno x= dao.buscar(idal);
       vista.verAlumno(x);
    }

    public static void actualizar() {
        int idal=AlumnoDatos.datosIdal();
        if(dao.buscar(idal)!=null){      
        Alumno alumno=AlumnoDatos.datosActualizar(idal);
        dao.actualizar(alumno);
        }else{
            Mensajes.alumnoNoExiste();
        }
    }

    public static void eliminar() {
        int idal=AlumnoDatos.datosIdal();
        if(dao.buscar(idal)!=null){
               dao.eliminar(idal);        
        }else{
            Mensajes.alumnoNoExiste();
        }         
    }

    public static void obtener() {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        alumnos = dao.obtener();
        vista.verAlumnos(alumnos);
    }
    
    public static void verNotas(){
     int idal=AlumnoDatos.datosIdal();
      dao.verNotas(idal);
    
    
    }
    
    
}
