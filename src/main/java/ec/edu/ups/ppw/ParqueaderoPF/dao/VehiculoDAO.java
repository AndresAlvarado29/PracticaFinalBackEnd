package ec.edu.ups.ppw.ParqueaderoPF.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

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
<<<<<<< HEAD
}
public List<Vehiculo> getAlll(){
	String jpql = "SELECT v FROM Vehiculo v";
=======
	}
	public List<Vehiculo> getAll(){
	String jpql = "SELECT v FROM Vehiculo";
>>>>>>> 4e98f9c836c869c64bcdb7433833b84e62d73b58
	Query q = em.createQuery(jpql);
	return q.getResultList();
	}
}
