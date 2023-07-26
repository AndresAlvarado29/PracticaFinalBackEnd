package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
@Id
@Column(name="cli_cedula")
private String cedula;
@Column(name="cli_nombre")
private String nombre;
@Column(name="cli_apellido")
private String apellido;
@Column(name="cli_celular")
private String celular;
@Column(name="cli_correo")
private String correo;
@Column(name="cli_direccion")
private String direccion;
//relaciones
@OneToMany(fetch = FetchType.EAGER)
@JoinColumn(name="cli_cedula")
private List<Vehiculo> vehiculos;
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getCelular() {
	return celular;
}
public void setCelular(String celular) {
	this.celular = celular;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}

}

