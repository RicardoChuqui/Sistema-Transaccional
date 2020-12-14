package ec.ups.edu.appdis.g1.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Poliza implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Id
@Column (name="tipoInversion")	
private String tipoInversion;
@Column(name = "monto")
private double monto;
@Column(name = "tiempo")
private int timpo;
@Column(name = "plazo")
private int plazo;
@ManyToOne 
@JoinColumn(name="idCuenta")
private Cuenta cuenta;

public String getTipoInversion() {
	return tipoInversion;
}
public void setTipoInversion(String tipoInversion) {
	this.tipoInversion = tipoInversion;
}
public double getMonto() {
	return monto;
}
public void setMonto(double monto) {
	this.monto = monto;
}
public int getTimpo() {
	return timpo;
}
public void setTimpo(int timpo) {
	this.timpo = timpo;
}
public int getPlazo() {
	return plazo;
}
public void setPlazo(int plazo) {
	this.plazo = plazo;
}
public Cuenta getCuenta() {
	return cuenta;
}
public void setCuenta(Cuenta cuenta) {
	this.cuenta = cuenta;
}

}
