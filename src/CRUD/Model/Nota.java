/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CRUD.Model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class Nota {
    
   private int idal;
      private int idas;
      private float nota;
     private Date fecha;
    
 public Nota(){}
 
 public Nota(int idal, int idas, float nota,Date fecha){
     this.idal=idal;
     this.idas=idas;
     this.nota=nota;
     this.fecha=fecha;
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
 
    @Override
    public String toString(){
        return "Idal: "+ idal + " \tIdas: " + idas + "\tNota: " + nota+ "\tFecha: "+fecha;
    }


}
