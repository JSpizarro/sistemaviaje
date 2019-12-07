package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreserva;

	

	// bi-directional many-to-one association to Destino
	@ManyToOne
	@JoinColumn(name = "destino_id_destino")
	private Destino destino;

	// bi-directional many-to-one association to Hotel
	@ManyToOne
	@JoinColumn(name = "hotel_idhotel")
	private Hotel hotel;

	// bi-directional many-to-one association to Pago
	@ManyToOne
	@JoinColumn(name = "pago_idpago")
	private Pago pago;

	// bi-directional many-to-one association to Paquetesviaje
	@ManyToOne
	@JoinColumn(name = "paquetesviaje_idpaquetes_viaje")
	private Paquetesviaje paquetesviaje;

	// bi-directional many-to-one association to Restaurante
	@ManyToOne
	@JoinColumn(name = "restaurante_idrestaurante")
	private Restaurante restaurante;

	// bi-directional many-to-one association to Tipoviaje
	@ManyToOne
	@JoinColumn(name = "tipoviaje_id_tipo_viaje")
	private Tipoviaje tipoviaje;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "usuario_id_usuario")
	private Usuario usuario;
	
	

	public Reserva() {
		
		this.destino = new Destino();
		this.hotel = new Hotel();
		this.pago = new Pago();
		this.paquetesviaje = new Paquetesviaje();
		this.restaurante = new Restaurante();
		this.tipoviaje = new Tipoviaje();
		this.usuario = new Usuario();
	}

	public int getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	public Destino getDestino() {
		return this.destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Paquetesviaje getPaquetesviaje() {
		return this.paquetesviaje;
	}

	public void setPaquetesviaje(Paquetesviaje paquetesviaje) {
		this.paquetesviaje = paquetesviaje;
	}

	public Restaurante getRestaurante() {
		return this.restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Tipoviaje getTipoviaje() {
		return this.tipoviaje;
	}

	public void setTipoviaje(Tipoviaje tipoviaje) {
		this.tipoviaje = tipoviaje;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	

	
	
	

}