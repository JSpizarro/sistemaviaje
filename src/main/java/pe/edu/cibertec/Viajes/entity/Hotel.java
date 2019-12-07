package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhotel;

	private String direccion;

	private String nombre;

	private double precio;

	private int telefono;

	private String tipoH;

	private String tiposervicio;

	public Hotel() {
	}

	public int getIdhotel() {
		return this.idhotel;
	}

	public void setIdhotel(int idhotel) {
		this.idhotel = idhotel;
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

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTiposervicio() {
		return this.tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	

	public String getTipoH() {
		return tipoH;
	}

	public void setTipoH(String tipoH) {
		this.tipoH = tipoH;
	}

	@Override
	public String toString() {
		return "Hotel [idhotel=" + idhotel + ", direccion=" + direccion + ", nombre=" + nombre + ", precio=" + precio
				+ ", telefono=" + telefono + ", tipoH=" + tipoH + "]";
	}

	// public Reserva addReserva(Reserva reserva) {
	// getReservas().add(reserva);
	// reserva.setHotel(this);
	//
	// return reserva;
	// }
	//
	// public Reserva removeReserva(Reserva reserva) {
	// getReservas().remove(reserva);
	// reserva.setHotel(null);
	//
	// return reserva;
	// }

}