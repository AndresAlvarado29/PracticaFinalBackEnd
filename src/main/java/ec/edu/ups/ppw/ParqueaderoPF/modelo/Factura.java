package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura {
@Id
@GeneratedValue
@Column(name="fac_id")
private int id;
@Column(name="fac_numero")
private String numeroFactura;
@Column(name="fac_fecha")
private Date fecha;
@Column(name="fac_subtotal")
private double subtotal;
@Column(name="fac_iva")
private double iva;
@Column(name="fac_total")
private double total;
@Column(name="fac_estado")
private String estado;
//relaciones
@OneToOne
@JoinColumn(name="cli_cedula")
private Cliente cliente;
@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
@JoinColumn(name="fac_id")
private List<DetalleFactura> detalles;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNumeroFactura() {
	return numeroFactura;
}
public void setNumeroFactura(String numeroFactura) {
	this.numeroFactura = numeroFactura;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public double getIva() {
	return iva;
}
public void setIva(double iva) {
	this.iva = iva;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
public List<DetalleFactura> getDetalles() {
	return detalles;
}
public void setDetalles(List<DetalleFactura> detalles) {
	this.detalles = detalles;
}
public void addDetalle(DetalleFactura detalle) {
	detalles.add(detalle);
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}

}
