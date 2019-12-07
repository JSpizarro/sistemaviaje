package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the destino database table.
 * 
 */
@Entity
@NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d")
public class Destino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_destino")
	private int idDestino;

	private String nombre;

	private double precio;

	// bi-directional many-to-one association to Tipoviaje
	@ManyToOne
	@JoinColumn(name = "tipoviaje_id_tipo_viaje")
	private Tipoviaje tipoviaje;

	public Destino() {
		this.tipoviaje = new Tipoviaje();
	}

	public int getIdDestino() {
		return this.idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipoviaje getTipoviaje() {
		return this.tipoviaje;
	}

	public void setTipoviaje(Tipoviaje tipoviaje) {
		this.tipoviaje = tipoviaje;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Destino [idDestino=" + idDestino + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	

	// public Reserva addReserva(Reserva reserva) {
	// getReservas().add(reserva);
	// reserva.setDestino(this);
	//
	// return reserva;
	// }
	//
	// public Reserva removeReserva(Reserva reserva) {
	// getReservas().remove(reserva);
	// reserva.setDestino(null);
	//
	// return reserva;
	// }

}