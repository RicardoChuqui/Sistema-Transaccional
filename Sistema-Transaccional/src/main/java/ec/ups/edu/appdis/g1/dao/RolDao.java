package ec.ups.edu.appdis.g1.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.ups.edu.appdis.g1.modelo.Rol;



@Stateless
public class RolDao {

	@PersistenceContext
	private EntityManager em;
	
	public void crearRol(Rol rol) {
		em.persist(rol);
	}
	
	public List<Rol> listaRol() {
		String jpql = "SELECT r FROM Rol r";

		Query q = em.createQuery(jpql, Rol.class);

		return q.getResultList();
	}
	
	
	public Rol buscar(int id) {
		return em.find(Rol.class, id);
	}
	
	public void delete(Rol p) {
		//p = buscar(id);
		em.remove(p);
	}
	
}
