package ec.ups.edu.appdis.g1.dao;



import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.ups.edu.appdis.g1.modelo.Cuenta;

/**
 *
 * @author Ricardo Chuqui
 */

@Stateless
public class CuentaDAO {

	@PersistenceContext
	private EntityManager em;

	
	public void insertCuenta(Cuenta cuenta) throws Exception {

		em.persist(cuenta);

	}


	public Cuenta readCuenta(String id) throws Exception {
		return em.find(Cuenta.class, id);
	}

	
	public void updateCuenta(Cuenta cuenta) throws Exception {
		em.merge(cuenta);
	}

	public void deleteCuenta(String idCuenta) throws Exception {
		Cuenta c = readCuenta(idCuenta);
		em.remove(c);
	}


	public List<Cuenta> getCuenta(String filtro) throws Exception {
		String jpql = "SELECT p FROM CuentaEN p WHERE tipoCuenta LIKE :filtro";

		Query q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("filtro", filtro + "%");
		return q.getResultList();
	}


	public void actualizarSaldoCuenta(String idCuenta, double cantidad) throws Exception {

		String jpql = "UPDATE Cuenta p SET p.saldo = p.saldo+" + cantidad + " WHERE idcuenta='" + idCuenta + "'";

		Query query = em.createQuery(jpql);
		query.executeUpdate();

	}


	public void actualizarRetiroCuenta(String idCuenta, double cantidad) throws Exception {

		String jpql = "UPDATE CuentaEN p SET p.saldo = p.saldo-" + cantidad + " WHERE idcuenta='" + idCuenta + "'";

		Query query = em.createQuery(jpql);
		query.executeUpdate();

	}

}
