package ec.edu.ups.ppw.ParqueaderoPF.negocio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.dao.FacturaDAO;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Factura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFactura {
@Inject
private FacturaDAO facturaDAO;


public void guardarFactura(Factura factura) {
	facturaDAO.create(factura);
}
public List<Factura> listar(){
	return facturaDAO.getAll();
}
//buscar
public Factura buscar(String numero) {
	for (Factura facturas : facturaDAO.getAll()) {
		if(numero.equals(facturas.getNumeroFactura())) {
			facturas.setEstado("Anulado");
			return facturas;
		}else {
			System.out.println("no existe ese numero");
		}
	}
	return null;
}
}
