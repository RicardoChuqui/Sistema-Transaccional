package ec.ups.edu.appdis.g1.modelo;

public class Poliza {
private String tipoInversion;
private double monto;
private int timpo;
private int plazo;
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
