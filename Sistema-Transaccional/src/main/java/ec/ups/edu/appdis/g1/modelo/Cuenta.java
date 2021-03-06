

package ec.ups.edu.appdis.g1.modelo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Chuqui
 */


@Entity
public class Cuenta implements Serializable{
    
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column (name="idCuenta")
    private String idCuenta;
  
    @Column (name="tipoCuenta")
    private String tipoCuenta;
    
    @Column (name="fechaRegistroCuenta")
    private Date fechaRegistroCuenta;
    
     
     @OneToOne 
     @JoinColumn(name="cedulaSocio")
    //@JoinColumn(name="idSocio")
   //  @Column (name="CedulaFK")
    private Socio socio;
     
     @Column(name="saldo")
     private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Date getFechaRegistroCuenta() {
        return fechaRegistroCuenta;
    }

    public void setFechaRegistroCuenta(Date fechaRegistroCuenta) {
        this.fechaRegistroCuenta = fechaRegistroCuenta;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "idCuenta=" + idCuenta + ", tipoCuenta=" + tipoCuenta + ", fechaRegistroCuenta=" + fechaRegistroCuenta + ", socioen=" + socio + ", saldo=" + saldo + '}';
    }

  
  
}
