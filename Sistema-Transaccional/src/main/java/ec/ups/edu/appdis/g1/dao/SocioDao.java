
 package ec.ups.edu.appdis.g1.dao;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.ups.edu.appdis.g1.modelo.Socio;

/**
 *
 * @author Ricardo Chuqui
 */

@Stateless
public class SocioDao {

	@PersistenceContext
	private EntityManager em;

	public void insertSocio(Socio socio) throws Exception {
		em.persist(socio);
	}
	
	
	public Socio readSocio(String cedulaSocio) throws Exception {
		return em.find(Socio.class, cedulaSocio);
	}
	
	public void updateSocio(Socio socio) throws Exception {
		em.merge(socio);
	}

	public void deleteSocio(String cedula) throws Exception {
		Socio s = readSocio(cedula);
		em.remove(s);
	}

	public List<Socio> getSocios(String filtro) throws Exception {
		String jpql = "SELECT p FROM Socio p WHERE cedulaSocio LIKE :filtro";

		Query q = em.createQuery(jpql, Socio.class);
		q.setParameter("filtro", filtro + "%");
		return q.getResultList();
	}

	public Socio buscarCorreo(String correo)throws Exception {
		Socio c=null;
		try {
			String jpql = "SELECT p FROM Socio p " + "WHERE p.correo LIKE :correo";
		TypedQuery<Socio> query = em.createQuery(jpql, Socio.class);
		query.setParameter("correo", correo);

		 c= query.getSingleResult();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	
	public Socio login(String correo, String clave)throws Exception{
		Socio p = null;
		String jpql = "SELECT p FROM Socio p " + "WHERE p.correo LIKE :correo AND p.clave LIKE :clave";

		TypedQuery<Socio> query = em.createQuery(jpql, Socio.class);
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);
		
   
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
