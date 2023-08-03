package ec.edu.ups.ppw.ParqueaderoPF.negocio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.dao.TicketDAO;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Ticket;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionTicket {

	@Inject
	private TicketDAO daoTicket;
	
	public void guardarTicket(Ticket ticket) throws Exception {
		
		if(daoTicket.read(ticket.getNumeroTicket()) == null) {
			try {
				daoTicket.create(ticket);
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoTicket.update(ticket);
			}catch(Exception e) {
				e.printStackTrace();
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public List<Ticket> getAll(){
		return daoTicket.getAll();
	}
	
	public boolean eliminarTicket(int numTicket) {
		try {
			daoTicket.delete(numTicket);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Ticket buscarTicket(int idTiket) {
		
		return daoTicket.read(idTiket);
	}
	
}
