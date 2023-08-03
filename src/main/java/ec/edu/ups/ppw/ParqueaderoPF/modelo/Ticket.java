package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="tic_id")
	private int id;

	@Column(name="tic_numero")
	private int numeroTicket;

	@Column(name="tic_puesto")
	private int puesto;

	@Column(name="tic_hora_entrada")
	private String horaEntrada;

	@Column(name="tic_hora_salida")
	private String horaSalida;

	//relaciones
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "placa")
	private Vehiculo vehiculo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroTicket() {
		return numeroTicket;
	}
	public void setNumeroTicket(int numeroTicket) {
		this.numeroTicket = numeroTicket;
	}
	
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", numeroTicket=" + numeroTicket + ", puesto=" + puesto
				+ ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", vehiculo=" + vehiculo + "]";
	}

}
