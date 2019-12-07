package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the restaurante database table.
 * 
 */
@Entity
@NamedQuery(name="Restaurante.findAll", query="SELECT r FROM Restaurante r")
public class Restaurante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrestaurante;

	private String direccion;

	private String nombre;

	private String precio;

	private String tiposervicio;

	

	public Restaurante() {
	}

	public int getIdrestaurante() {
		return this.idrestaurante;
	}

	public void setIdrestaurante(int idrestaurante) {
		this.idrestaurante = idrestaurante;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTiposervicio() {
		return this.tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	

	

	@Override
	public String toString() {
		return "Restaurante [idrestaurante=" + idrestaurante + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", precio=" + precio + ", tiposervicio=" + tiposervicio  + "]";
	}

	
	
	
	
}