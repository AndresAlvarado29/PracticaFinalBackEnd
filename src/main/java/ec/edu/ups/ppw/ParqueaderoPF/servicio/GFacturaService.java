package ec.edu.ups.ppw.ParqueaderoPF.servicio;

import java.util.List;

import ec.edu.ups.ppw.ParqueaderoPF.modelo.Factura;
import ec.edu.ups.ppw.ParqueaderoPF.negocio.GestionFactura;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("factura")
public class GFacturaService {
@Inject
private GestionFactura gFactura;
//servicios
@POST
@Path("crear")
@Produces("application/json")
@Consumes("application/json")
public Response guardarFactura(Factura factura) {
	gFactura.guardarFactura(factura);
	return Response.status(Response.Status.OK).entity(factura).build();
}
@GET
@Path("all")
@Produces("application/json")
public Response getCliente() {
	List<Factura> listado = gFactura.listar();
	if(gFactura.listar().isEmpty()) {
		return Response.status(Response.Status.OK).entity("Lista vacia").build();
	}else {
	return Response.status(Response.Status.OK).entity(listado).build();}
}
@GET
@Path("buscarN/{numero}")
@Produces("application/json")
public Factura buscar(@PathParam("numero") String numero) {
	return gFactura.buscar(numero);
} 
@GET
@Path("suma/{costoUnitario}/{iva}")
public String suma(@PathParam("costoUnitario")int costoUnitario,@PathParam("iva") double iva) {
double subtotal=costoUnitario;
double impuestos=subtotal*iva;
double total=subtotal+impuestos;
String r=""+total;
return r;
}
}
