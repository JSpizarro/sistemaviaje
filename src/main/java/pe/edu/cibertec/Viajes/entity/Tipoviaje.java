package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tipoviaje database table.
 * 
 */
@Entity
@NamedQuery(name = "Tipoviaje.findAll", query = "SELECT t FROM Tipoviaje t")
public class Tipoviaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_viaje")
	private int idTipoViaje;

	@Column(name = "tipo_viaje")
	private String tipoViaje;

	public Tipoviaje() {
	}

	public int getIdTipoViaje() {
		return this.idTipoViaje;
	}

	public void setIdTipoViaje(int idTipoViaje) {
		this.idTipoViaje = idTipoViaje;
	}

	public String getTipoViaje() {
		return this.tipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}

	@Override
	public String toString() {
		return "Tipoviaje [idTipoViaje=" + idTipoViaje + ", tipoViaje=" + tipoViaje + "]";
	}

}