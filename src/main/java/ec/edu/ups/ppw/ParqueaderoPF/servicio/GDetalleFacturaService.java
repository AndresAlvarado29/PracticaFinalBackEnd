package ec.edu.ups.ppw.ParqueaderoPF.servicio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.DetalleFactura;
import ec.edu.ups.ppw.ParqueaderoPF.negocio.GestionDetalleFactura;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("detalle")
public class GDetalleFacturaService {
@Inject
private GestionDetalleFactura gDetalleFactura;
//servicios
@POST
@Path("crear")
@Produces("application/json")
@Consumes("application/json")
public Response guardarDetalle(DetalleFactura detalleFactura) {
	gDetalleFactura.guardarDetalle(detalleFactura);
	return Response.status(Response.Status.OK).entity(detalleFactura).build();
}
@GET
@Path("all")
@Produces("application/json")
public Response getDetalle() {
	List<DetalleFactura> listado = gDetalleFactura.listar();
	if(gDetalleFactura.listar().isEmpty()) {
		return Response.status(Response.Status.OK).entity("lista vacia").build();
	}else {
		return Response.status(Response.Status.OK).entity(listado).build();
	}
}

}
