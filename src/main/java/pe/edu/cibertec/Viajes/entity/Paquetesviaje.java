package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the paquetesviaje database table.
 * 
 */
@Entity
@NamedQuery(name="Paquetesviaje.findAll", query="SELECT p FROM Paquetesviaje p")
public class Paquetesviaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpaquetes_viaje")
	private int idpaquetesViaje;

	@Column(name="descripcion_paquete")
	private String descripcionPaquete;

	@Column(name="nombre_paquete")
	private String nombrePaquete;

	private double precio;

	//bi-directional many-to-one association to Tipoviaje
	@ManyToOne
	@JoinColumn(name="tipoviaje_id_tipo_viaje")
	private Tipoviaje tipoviaje;

	

	public Paquetesviaje() {
		this.tipoviaje=new Tipoviaje();
	}

	public int getIdpaquetesViaje() {
		return this.idpaquetesViaje;
	}

	public void setIdpaquetesViaje(int idpaquetesViaje) {
		this.idpaquetesViaje = idpaquetesViaje;
	}

	public String getDescripcionPaquete() {
		return this.descripcionPaquete;
	}

	public void setDescripcionPaquete(String descripcionPaquete) {
		this.descripcionPaquete = descripcionPaquete;
	}

	public String getNombrePaquete() {
		return this.nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Tipoviaje getTipoviaje() {
		return this.tipoviaje;
	}

	public void setTipoviaje(Tipoviaje tipoviaje) {
		this.tipoviaje = tipoviaje;
	}

	@Override
	public String toString() {
		return "Paquetesviaje [idpaquetesViaje=" + idpaquetesViaje + ", descripcionPaquete=" + descripcionPaquete
				+ ", nombrePaquete=" + nombrePaquete + ", precio=" + precio + ", tipoviaje=" + tipoviaje + "]";
	}

	

}