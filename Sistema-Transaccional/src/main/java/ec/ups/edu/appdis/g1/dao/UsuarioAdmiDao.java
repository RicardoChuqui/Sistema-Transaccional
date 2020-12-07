package ec.ups.edu.appdis.g1.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.ups.edu.appdis.g1.modelo.UsuarioAdministrativo;



@Stateless
public class UsuarioAdmiDao {

	@PersistenceContext
	private EntityManager em;

	public void crearUsuarioAdmin(UsuarioAdministrativo admi) {
		em.persist(admi);
	}

	public List<UsuarioAdministrativo> listaUAdmi(String nombre) {

		String jpql = "SELECT p FROM UsuarioAdministrativo p WHERE nombre LIKE :nombre";
		// System.out.println(jpql);

		Query q = em.createQuery(jpql, UsuarioAdministrativo.class);

		q.setParameter("nombre", nombre + "%");
		return q.getResultList();

	}

	public UsuarioAdministrativo buscarUAdmin(int id) throws Exception {
		return em.find(UsuarioAdministrativo.class, id);
	}

	public void deleteUAdmi(int id) throws Exception {
		// UsuarioAdministrativo s = em.find(UsuarioAdministrativo.class, id);
		String jpql = "DELETE FROM UsuarioAdministrativo p WHERE p.idusuario = :id";
		Query query = em.createQuery(jpql);
		query.setParameter("id", id);
		int deletedCount = query.executeUpdate();
		// em.remove(s);
		System.out.println("entities deleted: " + deletedCount);
	}
	
	public UsuarioAdministrativo buscarUsuarioAdmi(String usuario) throws Exception {
		UsuarioAdministrativo c = null;
		try {
			String jpql = "SELECT p FROM UsuarioAdministrativo p " + "WHERE p.usuario LIKE :usuario";
			TypedQuery<UsuarioAdministrativo> query = em.createQuery(jpql, UsuarioAdministrativo.class);
			query.setParameter("usuario", usuario);

			c = query.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	public UsuarioAdministrativo login(String usuario, String contrasena) throws Exception {
		UsuarioAdministrativo p = null;
		String jpql = "SELECT p FROM UsuarioAdministrativo p "
				+ "WHERE p.usuario LIKE :usuario AND p.contrasena LIKE :contrasena";

		TypedQuery<UsuarioAdministrativo> query = em.createQuery(jpql, UsuarioAdministrativo.class);
		query.setParameter("usuario", usuario);
		query.setParameter("contrasena", contrasena);

		try {
			p = query.getSingleResult();
			System.out.println("Encontrado");

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return p;

	}
}
