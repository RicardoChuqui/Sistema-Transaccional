package ec.ups.edu.appdis.g1.operacion;





import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.modelo.Cuenta;
import ec.ups.edu.appdis.g1.negocio.GestionBancariaON;
/**
 *
 * @author Ricardo Chuqui
 */



@ManagedBean
@ViewScoped
public class CuentaBean {
    
    @Inject
    private GestionBancariaON on;
    
   private Cuenta newCuenta;
   private List<Cuenta> listaCuenta;
   
  
   

   private Date  fecha=new Date();

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
   

    public Cuenta getNewCuenta() {
        return newCuenta;
    }

    public void setNewCuenta(Cuenta newCuenta) {
        this.newCuenta = newCuenta;
    }

    public List<Cuenta> getListaCuenta() {
        return listaCuenta;
    }

    public void setListaCuenta(List<Cuenta> listaCuenta) {
        this.listaCuenta = listaCuenta;
    }



   private String idCuenta;
   
      public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        System.out.println("ID Cuenta: "+idCuenta);
        this.idCuenta = idCuenta;
        if(idCuenta!=null){
            try {
                newCuenta=on.buscarCuenta(idCuenta);
               
            } catch (Exception ex) {
               System.out.println("Error setIDCuenta[BEAN]"+ex);
            }
        }
        
        
    }
    
   
    
    public void init(){
        try {
            newCuenta=new Cuenta();
            cargarCuentas();
        } catch (Exception ex) {
            System.out.println("Error init [CuentaBean]");
        }
    
    }
   
    
     /*    Cuenta             */
    
    
  
    
   
    
    public String guardarDatosCuenta(){
    
        try {
 
            on.guardarCuenta(newCuenta);
            
            System.out.println("Cuenta Guardada");

        } catch (Exception ex) {
            System.out.println("Guardar Cuenta..."+ex.getMessage());
        }
         return "listarCuentas";
    }
    

    
    
    
    public void cargarCuentas() throws Exception {
        listaCuenta = on.listarCuentas();
    }

    public String eliminarCuenta(String idCuenta){
    
        try {
            on.eliminarCuenta(idCuenta);
        } catch (Exception ex) {
            System.out.println("Error al Eliminar Cuenta [Bean]"+ex);
        }
        return null;
    }
    

    
    public String conpruebaCuentaExistente(String idCuenta){
    
        try {
            
            Cuenta busqueda=on.buscarCuenta(idCuenta);
            
            System.out.println("Encontrado"+busqueda.getIdCuenta());
            System.out.println("Encontrado Pertenece"+busqueda.getSocio().getNombresSocio());
           
        } catch (Exception ex) {
            System.out.println("Error al Buscar:"+ex.getMessage());
                    
        }
         return null;
    }
    
    
    
        public String redirigeCrearMovimiento(String idCuenta){
         
         System.out.println("Redirigir:"+idCuenta);
        return "Movimiento?faces-redirect=true&idCuenta="+idCuenta;
    }
    
       public String redirigeCrearRetiro(String idCuenta){
         
         System.out.println("Redirigir:"+idCuenta);
        return "Retiro?faces-redirect=true&idCuenta="+idCuenta;
    }
    
        
        

       /**
        * Numero de Cuenta
        */
       
       public static long numbGen() {
       while (true) {
           long numb = (long)(Math.random() * 100000000 * 1000000); // had to use this as int's are to small for a 13 digit number.
           if (String.valueOf(numb).length() == 12)
               return numb;
       }
   }
       
     String aleatorio=String.valueOf(numbGen());
       
       public String numero(){
       return aleatorio;
       }

       public String getAleatorio() {
           return aleatorio;
       }

       public void setAleatorio(String aleatorio) {
           this.aleatorio = aleatorio;
       }
       
    
}
