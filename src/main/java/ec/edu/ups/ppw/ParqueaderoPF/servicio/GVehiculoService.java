package ec.edu.ups.ppw.ParqueaderoPF.servicio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Vehiculo;
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

@Path("vehiculos")
public class GVehiculoService {
	
	@Inject
	private GestionVehiculo gVehiculos;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarVehiculo(Vehiculo vehiculo) {

		
		try {
			gVehiculos.guardarVehiculo(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
					
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
	@Path("/listarVehiculos")
	@Produces("application/json")
	public List<Vehiculo> getAll(){
		
		return gVehiculos.getAll();
	}
	
	@DELETE
	@Path("/{placa}")
	public Response eliminarVehiculo (@PathParam("placa")String placa){
		boolean eliminar = gVehiculos.eliminarVehiculo(placa);
		if (eliminar) {
			return Response.status(Response.Status.OK).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}
}
