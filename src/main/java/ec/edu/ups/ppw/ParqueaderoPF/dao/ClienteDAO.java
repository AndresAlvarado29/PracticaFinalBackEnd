package ec.edu.ups.ppw.ParqueaderoPF.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@PersistenceContext
private EntityManager em;

public void create(Cliente cliente) {
	em.persist(cliente);
}
public Cliente read(String cedula) {
	Cliente c = em.find(Cliente.class, cedula);
	return c;
}
public void update(Cliente cliente) {
	em.merge(cliente);
}
public void delete(String cedula) {
	Cliente c = em.find(Cliente.class, cedula);
	em.remove(c);
}
public List<Cliente> getAll(){
	String jpql = "SELECT c FROM Cliente c";
	Query q = em.createQuery(jpql);
	return q.getResultList();
}

}
