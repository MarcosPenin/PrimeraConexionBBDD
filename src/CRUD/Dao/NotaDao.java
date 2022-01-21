package CRUD.Dao;

import static CRUD.Dao.MatriculaDao.stm;
import CRUD.IDao.INotaDao;
import CRUD.Model.Matricula;
import CRUD.Model.Nota;
import CRUD.Vista.Mensajes;
import excepciones.NotaRepetidaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author usuario
 */
public class NotaDao implements INotaDao {

    static NotaDao dao = new NotaDao();

    @Override
    public void registrar(Nota nota) {
        String sql = "INSERT INTO notas (idal,idas,fecha,nota) values ('" + nota.getIdal()
                + "','" + nota.getIdas() + "','" + nota.getFecha() + "','" + nota.getNota() + "')";
        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("No se puede guardar esa nota");
        } catch (SQLException e) {
            System.out.println("Error: Clase NotaDao, método registrar" + e);
        }
    }

    @Override
    public void actualizar(Nota nota) {

        String sql = "UPDATE notas SET nota='" + nota.getNota() + "'" + " WHERE idal='" + nota.getIdal() + "' and idas='" + nota.getIdas() + "' and fecha='" + nota.getFecha() + "'";

        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase NotaDao, método actualizar");
        }
    }

    @Override
    public void eliminar(Nota nota
    ) {
        int idal = nota.getIdal();
        int idas = nota.getIdas();
        Date fecha = nota.getFecha();

        String sql = "DELETE FROM notas WHERE idal='" + idal + "' and idas='" + idas + "' and fecha='" + fecha + "'";

        try {
            stm.execute(sql);
            Mensajes.exito();
        } catch (SQLException e) {
            System.out.println("Error: Clase NotaDao, método eliminar");
            e.printStackTrace();
        }
    }

    public List<Nota> obtener() {

        ResultSet rs = null;
        String sql = "SELECT * FROM notas";
        List<Nota> notas = new ArrayList<>();
        try {
            rs = stm.executeQuery(sql);
            while (rs.next()) {

                Nota x = new Nota();
                x.setIdal(rs.getInt(1));
                x.setIdas(rs.getInt(2));
                x.setFecha(rs.getDate(3));
                x.setNota(rs.getFloat(4));
                notas.add(x);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase NotaDao, método obtener");
        }

        return notas;
    }

    public Nota buscar(Matricula matricula, Date fecha) {

        Nota x = null;
        List<Nota> notas = obtener();
        for (Nota y : notas) {
            if (y.getIdal() == matricula.getIdal() && y.getIdas() == matricula.getIdas() && y.getFecha().toString().equals(fecha.toString())) {
                x = y;
            }
        }
        return x;
    }

    public static void comprobarNota(Matricula matricula, Date fecha) throws NotaRepetidaException {
        if (dao.buscar(matricula, fecha) != null) {
            throw new NotaRepetidaException();
        }
    }
}
