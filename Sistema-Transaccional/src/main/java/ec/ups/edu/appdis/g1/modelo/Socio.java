
package ec.ups.edu.appdis.g1.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ricardo Chuqui
 */
@Entity
public class Socio implements Serializable {

    private static final long serialVersionUID = 1L;

//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column (name="idSocio")
//    private int idSocio;
    @Id
    @Column(name = "cedulaSocio")
    private String cedulaSocio;

    @Column(name = "nombreSocio")
    private String nombresSocio;

    @Column(name = "apellidoSocio")
    private String apelidosSocio;

    @Column(name = "edadSocio")
    private int edadSocio;

    @Column(name = "provinciaSocio")
    private String provinciaSocio;

    @Column(name = "ciudadSocio")
    private String ciudadSocio;

    @Column(name = "direccionSocio")
    private String direccionSocio;

    @Column(name = "telefonoSocio")
    private String telefonoFijoSocio;

    @Column(name = "celularSocio")
    private String cedularSocio;
    
    @Column(name = "correoSocio")
	private String correo;
	
    @Column(name = "claveSocio")
    private String clave;

    @Column(name = "estadoCivilSocio")
    private String estadoCiviilSocio;

    @OneToOne(mappedBy = "socio")
    private Cuenta cuenta;

    @OneToMany(mappedBy = "socio",fetch = FetchType.EAGER)
	private List<LoginHistoricos> loginh;
    
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public List<LoginHistoricos> getLoginh() {
		return loginh;
	}

	public void setLoginh(List<LoginHistoricos> loginh) {
		this.loginh = loginh;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCedulaSocio() {
        return cedulaSocio;
    }

    public void setCedulaSocio(String cedulaSocio) {
        this.cedulaSocio = cedulaSocio;
    }

    public String getNombresSocio() {
        return nombresSocio;
    }

    public void setNombresSocio(String nombresSocio) {
        this.nombresSocio = nombresSocio;
    }

    public String getApelidosSocio() {
        return apelidosSocio;
    }

    public void setApelidosSocio(String apelidosSocio) {
        this.apelidosSocio = apelidosSocio;
    }

    public int getEdadSocio() {
        return edadSocio;
    }

    public void setEdadSocio(int edadSocio) {
        this.edadSocio = edadSocio;
    }

    public String getProvinciaSocio() {
        return provinciaSocio;
    }

    public void setProvinciaSocio(String provinciaSocio) {
        this.provinciaSocio = provinciaSocio;
    }

    public String getCiudadSocio() {
        return ciudadSocio;
    }

    public void setCiudadSocio(String ciudadSocio) {
        this.ciudadSocio = ciudadSocio;
    }

    public String getDireccionSocio() {
        return direccionSocio;
    }

    public void setDireccionSocio(String direccionSocio) {
        this.direccionSocio = direccionSocio;
    }

    public String getTelefonoFijoSocio() {
        return telefonoFijoSocio;
    }

    public void setTelefonoFijoSocio(String telefonoFijoSocio) {
        this.telefonoFijoSocio = telefonoFijoSocio;
    }

    public String getCedularSocio() {
        return cedularSocio;
    }

    public void setCedularSocio(String cedularSocio) {
        this.cedularSocio = cedularSocio;
    }

    public String getEstadoCiviilSocio() {
        return estadoCiviilSocio;
    }

    public void setEstadoCiviilSocio(String estadoCiviilSocio) {
        this.estadoCiviilSocio = estadoCiviilSocio;
    }

}
