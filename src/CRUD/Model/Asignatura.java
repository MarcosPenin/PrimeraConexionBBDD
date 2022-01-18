
package CRUD.Model;

/**
 *
 * @author usuario
 */
public class Asignatura {

       private int idas;
    private String codigoAsignatura;
    private String nombreCiclo;
   
   public Asignatura(){
       
   }
   
   public Asignatura(int idas, String codigoAsignatura, String nombreCiclo){
       this.idas=idas;
       this.codigoAsignatura=codigoAsignatura;
       this.nombreCiclo=nombreCiclo;
}

    public int getIdas() {
        return idas;
    }

    public void setIdas(int idas) {
        this.idas = idas;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public String getNombreCiclo() {
        return nombreCiclo;
    }

    public void setNombreCiclo(String nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }
         
    @Override
    public String toString(){
        return "Idas: "+ idas + " \tCódigo asignatura: " + codigoAsignatura + "\tNombre ciclo: " + nombreCiclo;
    }
    
}
    
    
