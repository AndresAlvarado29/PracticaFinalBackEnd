package ec.edu.ups.ppw.ParqueaderoPF.negocio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.dao.DetalleFacturaDAO;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.DetalleFactura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionDetalleFactura {
@Inject
private DetalleFacturaDAO detalleFacturaDAO;

public void guardarDetalle(DetalleFactura detalleFactura) {
detalleFacturaDAO.create(detalleFactura);	
}
public List<DetalleFactura> listar(){
	return detalleFacturaDAO.getAll();
}
}
