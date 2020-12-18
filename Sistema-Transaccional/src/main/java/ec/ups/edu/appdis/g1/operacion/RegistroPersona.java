package ec.ups.edu.appdis.g1.operacion;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.appdis.g1.modelo.Rol;
import ec.ups.edu.appdis.g1.modelo.UsuarioAdministrativo;
import ec.ups.edu.appdis.g1.negocio.RolON;
import ec.ups.edu.appdis.g1.negocio.UsuarioAdminON;



@WebServlet("/persona")
public class RegistroPersona extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = -3785458131672848839L;

	@Inject
	private UsuarioAdminON onadmi;

	@Inject
	private RolON onrol;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("<h1>SISTEMA TRANSACCIONAL</h1>");


		UsuarioAdministrativo admi = new UsuarioAdministrativo();

		admi.setNombre("Adminitrador");
		admi.setApellido("Administrador");
		admi.setUsuario("admin");
		admi.setContrasena("cuenca");

		UsuarioAdministrativo admi2 = new UsuarioAdministrativo();

		admi2.setNombre("Selena");
		admi2.setApellido("Gomez");
		admi2.setUsuario("sgomez");
		admi2.setContrasena("cuenca");

		Rol rol1 = new Rol();
		rol1.setNombre("Gerente");

		Rol rol2 = new Rol();
		rol2.setNombre("Cajero");

		Rol rol3 = new Rol();
		rol3.setNombre("Jefe de Credito");

		

		onrol.crearRol(rol1);
		onrol.crearRol(rol2);
		onrol.crearRol(rol3);

		admi.setRol(rol1);
		admi2.setRol(onrol.buscar(2));

		onadmi.crearUsuarioAdmi(admi);
		onadmi.crearUsuarioAdmi(admi2);

	}

}
