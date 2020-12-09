package ec.ups.edu.appdis.g1.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.dao.RolDao;
import ec.ups.edu.appdis.g1.modelo.Rol;



@Stateless
public class RolON {

	@Inject
	private RolDao dao;

	/*
  	 * metodo que permite crear un rol  llamando al metodo crearRol de su clase dao
  	 */
	public void crearRol(Rol rol) {
		dao.crearRol(rol);
	}

	/*
  	 * metodo que permite listar los rol  llamando al metodo listaRol de su clase dao
  	 */
	public List<Rol> listaRol() {
		return dao.listaRol();

	}
	
	/*
  	 * metodo que permite retornar un rol por medio de su id llamando al metodo buscar de su clase dao
  	 */
	public Rol buscar(int id) {
		return dao.buscar(id);
	}
	
	/*
  	 * Para eliminar un rol llama al metodo de la clase dao
  	 */
	public void EliminarRol(Rol rol) {
		dao.delete(rol);
	}
}
