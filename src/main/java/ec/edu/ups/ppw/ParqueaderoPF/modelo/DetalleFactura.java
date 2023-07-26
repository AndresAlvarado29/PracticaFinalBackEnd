package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DetalleFactura {
@Id
@GeneratedValue
@Column(name="det_id")
private int id;
@Column(name="det_cantidad")
private double cantidad;
@Column(name="det_detalle")
private String detalle;
@Column(name="det_costo_u")
private double costoUnitario;
@Column(name="det_costo_t")
private double costoTotal;
//relaciones
@OneToOne
@JoinColumn(name="tic_id")
private Ticket ticket;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public double getCantidad() {
	return cantidad;
}
public void setCantidad(double cantidad) {
	this.cantidad = cantidad;
}
public String getDetalle() {
	return detalle;
}
public void setDetalle(String detalle) {
	this.detalle = detalle;
}
public double getCostoUnitario() {
	return costoUnitario;
}
public void setCostoUnitario(double costoUnitario) {
	this.costoUnitario = costoUnitario;
}
public double getCostoTotal() {
	return costoTotal;
}
public void setCostoTotal(double costoTotal) {
	this.costoTotal = costoTotal;
}
public Ticket getTicket() {
	return ticket;
}
public void setTicket(Ticket ticket) {
	this.ticket = ticket;
}


}
