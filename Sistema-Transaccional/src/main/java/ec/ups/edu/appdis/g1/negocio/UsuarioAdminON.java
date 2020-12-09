package ec.ups.edu.appdis.g1.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.appdis.g1.dao.UsuarioAdmiDao;
import ec.ups.edu.appdis.g1.modelo.UsuarioAdministrativo;




@Stateless
public class UsuarioAdminON {

	@Inject
	private UsuarioAdmiDao uddao;
	
	/*
  	 * Para crear un usuario administrativo 
  	 */
	public void crearUsuarioAdmi(UsuarioAdministrativo admi) {
		uddao.crearUsuarioAdmin(admi);
	}
	
	/*
  	 * Metodo para listar usuarios listaUadmi de la clase dao
  	 */
	public List<UsuarioAdministrativo> listarUAdmi() throws Exception{
		return uddao.listaUAdmi("%");
	}

	/*
  	 * metodo que permite eliminar un usuario administrativo por medio de su clave primaria llamando al metodo delete de la clase dao
  	 */
	public void eliminarUAdmi(int id) throws Exception {
        uddao.deleteUAdmi(id);;
    }
	
	/*
  	 * metodo que permite retornar un usuario administrativo por medio de su correo y clave llamando al metodo login de la clase dao
  	 */
	
	public UsuarioAdministrativo buscarUsuarioAdmi(String usuario,String clave)throws Exception {
		return uddao.login(usuario, clave);
		
	}
	
	/*
  	 * metodo que permite retornar un usuario administrativo por medio de su clave primaria llamando al metodo buscar de la clase dao
  	 */
	public UsuarioAdministrativo UsuarioAdmi(int id)throws Exception {
		return uddao.buscarUAdmin(id);
		
	}	
	
	/*
  	 * metodo que permite retornar un usuario administrativo por medio de su usuario llamando al metodo BuscarUsuario de la clase dao
  	 */
	public UsuarioAdministrativo BuscarUsuario(String usuario) throws Exception{
		return uddao.buscarUsuarioAdmi(usuario);
	}
}
