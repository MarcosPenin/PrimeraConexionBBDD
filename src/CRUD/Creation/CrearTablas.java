package CRUD.Creation;

import java.sql.*;

/**
 *
 * @author
 */
public class CrearTablas {

    public static void crearTabla(Statement sentencia) {
        try {
//            sentencia.execute("DROP DATABASE IF EXISTS INSTITUTO;");
            sentencia.execute("CREATE DATABASE IF NOT EXISTS INSTITUTO;");
            sentencia.execute("USE INSTITUTO;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS PROFESORES"
                    + "(dni VARCHAR(30) NOT NULL,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "titulacion VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (dni))"
                    + "ENGINE INNODB;");
        
            sentencia.execute("CREATE TABLE IF NOT EXISTS ALUMNOS"
                    + "(idal int(4) NOT NULL AUTO_INCREMENT,"
                    + "codigoAlumno VARCHAR(4) UNIQUE NOT NULL,"
                    + "nombre varchar(30),"
                    + "PRIMARY KEY (idal))"
                    + "ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS ASIGNATURAS"
                    + "(idas int(4) NOT NULL AUTO_INCREMENT,"
                    + "codigoAsignatura VARCHAR(4) NOT NULL UNIQUE,"
                    + "nombreCiclo varchar(30),"
                    + "PRIMARY KEY(idas))"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS PROFESORESALUMNOSASIGNATURAS"
                    + "(dni VARCHAR(30) NOT NULL,"
                    + "idal int(4) NOT NULL,"
                    + "idas int(4) NOT NULL,"
                    + "PRIMARY KEY(idal,idas),"                
                    + "FOREIGN KEY(idal) REFERENCES ALUMNOS(idal),"
                    + "FOREIGN KEY (idas) REFERENCES ASIGNATURAS(idas),"
                    + "FOREIGN KEY (dni) REFERENCES PROFESORES (dni))"                  
                    + "ENGINE INNODB;");
  
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS NOTAS"
                    + "(idal int not null,"
                    + "idas int not null,"
                    + "fecha date not null,"
                    + "nota float not null,"
                    + "PRIMARY KEY (idal,idas,fecha),"
                    + "FOREIGN KEY(idal) REFERENCES ALUMNOS(idal),"
                    + "FOREIGN KEY (idas) REFERENCES ASIGNATURAS(idas))"
                    + "ENGINE INNODB;");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }
    }
}
