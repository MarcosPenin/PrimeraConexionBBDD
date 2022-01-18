package CRUD.Model;

/**
 *
 * @author usuario
 */
public class Alumno {

    private int idal;
    private String codigoAlumno;
    private String nombre;

    public Alumno() {

    }

    public Alumno(int idal, String codigoAlumno, String nombre) {
        this.idal = idal;
        this.codigoAlumno = codigoAlumno;
        this.nombre = nombre;

    }

    public int getIdal() {
        return idal;
    }

    public void setIdal(int idal) {
        this.idal = idal;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Idal: " + idal + " \tCódigo alumno: " + codigoAlumno + "\tNombre: " + nombre;
    }

}
