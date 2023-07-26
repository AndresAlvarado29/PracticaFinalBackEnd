package ec.edu.ups.ppw.ParqueaderoPF.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class DetalleFacturaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void create(DetalleFactura detalleFactura) {
		em.persist(detalleFactura);
	}
	public DetalleFactura read(int id) {
		DetalleFactura dF=em.find(DetalleFactura.class, id);
		return dF;
	}
	public void update(DetalleFactura detalleFactura) {
		em.merge(detalleFactura);
	}
	public void delete(int id) {
		DetalleFactura dF=em.find(DetalleFactura.class, id);
		em.remove(dF);
	}
	public List<DetalleFactura> getAll(){
		String jpql="SELECT dF FROM DetalleFactura";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
