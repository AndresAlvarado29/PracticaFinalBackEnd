package ec.edu.ups.ppw.ParqueaderoPF.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Ticket;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TicketDAO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void create(Ticket ticket) {
	em.persist(ticket);
	}
	public Ticket read(int numero) {
	Ticket t = em.find(Ticket.class, numero);
	return t;
	}
	public void update(Ticket ticket) {
	em.merge(ticket);
	}
	public void delete(int numero) {
	Ticket t = em.find(Ticket.class, numero);
	em.remove(t);

	}

public List<Ticket> getAll() {

	String jpql="SELECT t FROM Ticket t";
	Query q = em.createQuery(jpql);
	return q.getResultList();
	}
	
}
