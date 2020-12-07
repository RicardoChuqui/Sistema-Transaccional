package ec.ups.edu.appdis.g1.dao;



import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.ups.edu.appdis.g1.modelo.Movimiento;

/**
 *
 * @author Ricardo Chuqui
 */

@Stateless
public class MovimientoDAO {
    
    
    @PersistenceContext
    private EntityManager em;
    
    public void insertMovimiento(Movimiento movimiento)throws Exception{
        em.persist(movimiento);
    }
    
    public Movimiento readMovimiento(int idMovimiento)throws Exception{
        return em.find(Movimiento.class, idMovimiento);
    }
  
    public void updateMovimiento(Movimiento movimiento)throws Exception{
     em.merge(movimiento);
    }
    
    public void deleteMovimiento(int idMovimiento)throws Exception{
     Movimiento m=readMovimiento(idMovimiento);
     em.remove(m);
    }
    
     public List<Movimiento> getMovimientos(String filtro)throws Exception {
        String jpql = "SELECT p FROM CuentaEN p WHERE fechaMovimiento LIKE :filtro";

        Query q = em.createQuery(jpql, Movimiento.class);
        q.setParameter("filtro", filtro + "%");
        return q.getResultList();
    }
    
     public List<Movimiento> listarMovimiento(String idCuenta){
         String jpql = "Select p FROM MovimientoEN p WHERE p.cuenta like '" + idCuenta+"'";
         Query q = em.createQuery(jpql, Movimiento.class);

          return q.getResultList();
     }
    
     public List<Movimiento> listarMovimientoFecha(String idCuenta, Date desde,Date hasta, String tipo){
    	 if(tipo.equals("Todos")) {
    		 return listarMovimiento(idCuenta);
    	 }else {
    		  
         String jpql = "Select p FROM MovimientoEN p WHERE p.cuenta like '" + idCuenta+"' AND p.fechaMovimiento BETWEEN '"+desde+"' AND '"+hasta+"'"
         		+ "AND p.tipoMovimiento LIKE '"+tipo+"'";
         Query q = em.createQuery(jpql, Movimiento.class);

          return q.getResultList();
    	 }
    	
     }
    
     public List<Movimiento> movimientofechas(String idCuenta,Date fecha, Date fecha2, String tipoF){
			System.out.println(idCuenta+fecha+fecha2+tipoF);
			String jpql = "SELECT p FROM MovimientoEN p " + "WHERE 	p.cuenta like '" + idCuenta+"' "
					+ "and fechaMovimiento BETWEEN  :fecha  AND  :fecha2 and tipoMovimiento "
					+ "like :tipoF ";
			Query q = em.createQuery(jpql, Movimiento.class);
			q.setParameter("fecha", fecha);
			q.setParameter("fecha2", fecha2);
			q.setParameter("tipoF", tipoF);
			return q.getResultList();
		}
    
    
}
