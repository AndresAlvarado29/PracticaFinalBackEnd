package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Vehiculo {
	
@Id
@Column(name="veh_placa")
private String placa;

@Column(name="veh_marca")
private String marca;
<<<<<<< HEAD

=======
>>>>>>> fd5b9b8ee5ad9850dd5daa7b9279cc4fd5e6eef0
@Column(name="veh_tipo")
private String tipo;

//relaciones
@OneToOne
@JoinColumn(name="tic_id")
private Ticket ticket;

public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}

<<<<<<< HEAD
public Ticket getTicket() {
	return ticket;
}
public void setTicket(Ticket ticket) {
	this.ticket = ticket;
}
@Override
public String toString() {
	return "Vehiculo [placa=" + placa + ", marca=" + marca + ", tipo=" + tipo + ", ticket=" + ticket + "]";
}

=======
>>>>>>> fd5b9b8ee5ad9850dd5daa7b9279cc4fd5e6eef0

}

