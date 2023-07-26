package ec.edu.ups.ppw.ParqueaderoPF.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {
@Id
@Column(name="veh_placa")
private String placa;
@Column(name="veh_marca")
private String marca;
@Column(name="veh_modelo")
private String modelo;
@Column(name="veh_color")
private String color;
@Column(name="veh_tipo")
private String tipo;
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
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}

}

