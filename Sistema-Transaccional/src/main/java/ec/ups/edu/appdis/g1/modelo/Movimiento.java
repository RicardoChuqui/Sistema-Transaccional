package ec.ups.edu.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Ricardo Chuqui
 */


@Entity
public class Movimiento    implements Serializable{
    
   private static final long serialVersionUID = 1L;
   
     
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idMovimiento")
    private int idMovimiento;
    
    @Column (name="fechaMovimiento")
    private Date fechaMovimiento;
    
    @Column (name="tipoMovimiento")
    private String tipoMovimiento;
        
    @Column (name="cantidad")
    private double cantidad;
    
    @ManyToOne 
    @JoinColumn(name="idCuenta")
    private Cuenta cuenta;

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", fechaMovimiento=" + fechaMovimiento + ", tipoMovimiento=" + tipoMovimiento + ", cantidad=" + cantidad + ", cuenta=" + cuenta + '}';
    }

  
  


   
    
}
