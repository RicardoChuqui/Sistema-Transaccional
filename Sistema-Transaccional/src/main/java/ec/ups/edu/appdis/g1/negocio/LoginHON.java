package ec.ups.edu.appdis.g1.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.dao.LoginHDao;
import ec.ups.edu.appdis.g1.modelo.LoginHistoricos;



@Stateless
public class LoginHON {

	@Inject
	private LoginHDao dao;
	
	/*
  	 * metodo que permite crear historico de sesion llamando al metodo crearAcceso de su clase dao
  	 */
	public void crearHlogin(LoginHistoricos lh) {
		dao.crearAcceso(lh);
	}
	
	/*
  	 * metodo que permite listar los historico de sesion llamando al metodo getAcceso de su clase dao
  	 */
	public List<LoginHistoricos> getHistoricos(String cedula){
		return dao.getAcceso(cedula);
	}
}
