package CRUD.Model;

/**
 *
 * @author usuario
 */
public class Matricula {

    private String dni;
    private int idal;
    private int idas;

    public Matricula() {
    }

    public Matricula(String dni, int idal, int idas) {
        this.dni = dni;
        this.idal = idal;
        this.idas = idas;
    }

    public int getIdal() {
        return idal;
    }

    public void setIdal(int idal) {
        this.idal = idal;
    }

    public int getIdas() {
        return idas;
    }

    public void setIdas(int idas) {
        this.idas = idas;
    }

    @Override
    public String toString() {
        return "Dni profesor: " + getDni() + "\tIdas: " + idas + " \tIdal: " + idal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
