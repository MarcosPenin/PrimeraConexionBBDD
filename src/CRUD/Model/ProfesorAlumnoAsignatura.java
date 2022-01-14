/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Model;

/**
 *
 * @author usuario
 */
public class ProfesorAlumnoAsignatura {

    private int idal;
    private int idas;

    public ProfesorAlumnoAsignatura() {
    }

    public ProfesorAlumnoAsignatura(int idal, int idas) {
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
        return "Idas: " + idas + " \tIdal: " + idal;
    }

}
