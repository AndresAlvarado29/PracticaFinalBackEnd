package ec.edu.ups.ppw.ParqueaderoPF.servicio;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Ticket;
import ec.edu.ups.ppw.ParqueaderoPF.modelo.Vehiculo;
import ec.edu.ups.ppw.ParqueaderoPF.negocio.GestionTicket;
import ec.edu.ups.ppw.ParqueaderoPF.negocio.GestionVehiculo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("tickets")
public class GTicketService {
	
	@Inject
	private GestionTicket gTicket;
	
	@GET
	@Path("mistickets")
	@Produces("application/json")
	public Ticket misDatos() {
		Ticket t = new Ticket();
		t.setNumeroTicket(1);
		t.setPuesto(11);
		t.setHoraEntrada(null);
		t.setHoraSalida(null);
		
		return t;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarTicket(Ticket ticket) {
		
		try {
			gTicket.guardarTicket(ticket);
			return Response.status(Response.Status.OK).entity(ticket).build();
					
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar:" + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}	
		
	}
	
	@GET
	@Path("/listarTickets")
	@Produces("application/json")
	public List<Ticket> getAll(){
		
		return gTicket.getAll();
	}
	
	@DELETE
	@Path("/{numero}")
	public Response eliminarTicket (@PathParam("numero")int numero){
		boolean eliminar = gTicket.eliminarTicket(numero);
		if (eliminar) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
	
	@GET
	@Path("buscarTicket/{id}")
	@Produces("application/json")
	public Response buscarTicket(@PathParam("id")int idTicket) {
		
		Ticket t = new Ticket();
		
		try {
			t = gTicket.buscarTicket(idTicket);
			return Response.status(Response.Status.OK).entity(t).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	
	}

}
