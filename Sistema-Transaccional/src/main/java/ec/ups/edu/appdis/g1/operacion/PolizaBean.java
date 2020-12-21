package ec.ups.edu.appdis.g1.operacion;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.modelo.Cuenta;
import ec.ups.edu.appdis.g1.modelo.Poliza;
import ec.ups.edu.appdis.g1.negocio.GestionBancariaON;

@ManagedBean
@ViewScoped
public class PolizaBean {
	  @Inject
	    private GestionBancariaON on;
	    
	   private Poliza newPoliza;
	   private List<Poliza> listaPoliza;
	public GestionBancariaON getOn() {
		return on;
	}
	public void setOn(GestionBancariaON on) {
		this.on = on;
	}
	public Poliza getNewPoliza() {
		return newPoliza;
	}
	public void setNewPoliza(Poliza newPoliza) {
		this.newPoliza = newPoliza;
	}
	public List<Poliza> getListaPoliza() {
		return listaPoliza;
	}
	public void setListaPoliza(List<Poliza> listaPoliza) {
		this.listaPoliza = listaPoliza;
	}
	   
}
