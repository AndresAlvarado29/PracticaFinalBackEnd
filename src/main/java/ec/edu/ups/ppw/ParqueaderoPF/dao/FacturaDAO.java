package ec.edu.ups.ppw.ParqueaderoPF.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Cliente;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.DetalleFactura;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@PersistenceContext
private EntityManager em;

public void create(Factura factura) {
	em.persist(factura);
}
public Factura read(int id) {
	Factura f=em.find(Factura.class, id);
	return f;
}
public void update(Factura factura) {
	em.merge(factura);
}
public void delete(int id) {
	Factura f=em.find(Factura.class, id);
	em.remove(f);
}
public List<Factura> getAll(){
	String jpql="SELECT f FROM Factura f";
	Query q = em.createQuery(jpql);
	return q.getResultList();
}
public void agregarDetalle(DetalleFactura detalle) {
	Factura f = new Factura();
	f.addDetalle(detalle);
	}
public void agregarCliente(Cliente cliente) {
    Factura f = new Factura();
    f.setCliente(cliente);
}
}
