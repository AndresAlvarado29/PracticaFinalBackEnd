package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
@Id
@GeneratedValue
@Column(name="tic_id")
private int id;
@Column(name="tic_fecha")
private Date fecha;
@Column(name="tic_puesto")
private int puesto;
@Column(name="tic_hora_entrada")
private Date horaEntrada;
@Column(name="tic_hora_salida")
private Date horaSalida;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public int getPuesto() {
	return puesto;
}
public void setPuesto(int puesto) {
	this.puesto = puesto;
}
public Date getHoraEntrada() {
	return horaEntrada;
}
public void setHoraEntrada(Date horaEntrada) {
	this.horaEntrada = horaEntrada;
}
public Date getHoraSalida() {
	return horaSalida;
}
public void setHoraSalida(Date horaSalida) {
	this.horaSalida = horaSalida;
}

}
