package ec.ups.edu.appdis.g1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.ups.edu.appdis.g1.modelo.Poliza;


public class PolizaDAO {
	@PersistenceContext
	private EntityManager em;
	
public boolean insert(Poliza entity) throws SQLException {
		
		String sql = " INSERT INTO Poliza (tipoinversion, monto, plazo, tiempo, idcuenta)" 
	   + "VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = (PreparedStatement) em.createQuery(sql);
		
		ps.setString(1, entity.getTipoInversion());
		ps.setDouble(2, entity.getMonto());
		ps.setInt(3, entity.getPlazo());
		ps.setInt(4, entity.getTimpo());
		//ps.setCuenta(2);
		ps.executeUpdate();
		
		
		ps.close();
		return true;
	}
	
}



