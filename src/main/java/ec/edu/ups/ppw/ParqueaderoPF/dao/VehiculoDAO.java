package ec.edu.ups.ppw.ParqueaderoPF.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Ticket;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Stateless
public class VehiculoDAO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void create(Vehiculo vehiculo) {
	em.persist(vehiculo);
	}
	public Vehiculo read(String placa) {
		Vehiculo v = em.find(Vehiculo.class, placa);
		return v;
	}
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	public void delete(String placa) {
	Vehiculo v = em.find(Vehiculo.class, placa);
	em.remove(v);

}
	public List<Vehiculo> getAll(){
	String jpql = "SELECT v FROM Vehiculo v";
	Query q = em.createQuery(jpql);
	return q.getResultList();
	}
	
	public Vehiculo findPlaca(String placa) throws Exception {
        Vehiculo v = null;
        try {
            String jpql = "SELECT p FROM Vehiculo p WHERE placa LIKE :placa";
            TypedQuery<Vehiculo> query = em.createQuery(jpql, Vehiculo.class);
            query.setParameter("placa", placa + "%");
            v = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return v;
    }
}
