package ec.ups.edu.appdis.g1.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.ups.edu.appdis.g1.modelo.LoginHistoricos;



@Stateless
public class LoginHDao {

	@PersistenceContext
	private EntityManager em;

	 /*
  	 * metodo que permite crear los historicos de inicio de sesion en la base de datos
  	 */
	public void crearAcceso(LoginHistoricos lh) {
		em.persist(lh);

	}

	/*
  	 * metodo que permite listar los historicos de inicio de sesion en la base de datos por medio de su id
  	 */
	public List<LoginHistoricos> getAcceso(String id) {
		String jpql = "SELECT p FROM LoginHistoricos p "
				+ " WHERE id_socio LIKE :id";
		Query q = em.createQuery(jpql, LoginHistoricos.class);
		q.setParameter("id",id + "%");
		return q.getResultList();
	}
	
}
