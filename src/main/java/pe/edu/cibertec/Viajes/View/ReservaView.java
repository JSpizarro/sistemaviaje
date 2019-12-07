package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.swing.event.ChangeEvent;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.DestinoRepository;
import pe.edu.cibertec.Viajes.Repository.HotelRepository;
import pe.edu.cibertec.Viajes.Repository.PagoRepository;
import pe.edu.cibertec.Viajes.Repository.PaquetesviajeRepository;
import pe.edu.cibertec.Viajes.Repository.ReservaRepository;
import pe.edu.cibertec.Viajes.Repository.RestauranteRepository;
import pe.edu.cibertec.Viajes.Repository.TipoviajeRepository;
import pe.edu.cibertec.Viajes.Repository.UsuarioRepository;
import pe.edu.cibertec.Viajes.entity.Destino;
import pe.edu.cibertec.Viajes.entity.Hotel;
import pe.edu.cibertec.Viajes.entity.Pago;
import pe.edu.cibertec.Viajes.entity.Paquetesviaje;
import pe.edu.cibertec.Viajes.entity.Reserva;
import pe.edu.cibertec.Viajes.entity.Restaurante;
import pe.edu.cibertec.Viajes.entity.Tipoviaje;
import pe.edu.cibertec.Viajes.entity.Usuario;

@Component(value = "reservaView")
@ViewScoped
public class ReservaView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ReservaRepository reservaRepository;



	@Inject
	private PaquetesviajeRepository paquetesviajeRepository;

	@Inject
	private DestinoRepository destinoRepository;

	@Inject
	private TipoviajeRepository tipoviajeRepository;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private PagoRepository pagoRepository;

	@Inject
	private RestauranteRepository restauranteRepository;

	@Inject
	private HotelRepository hotelRepository;

	private int idreserva;

	private List<Reserva> reservas;
	private Reserva reserva;

	

	@PostConstruct
	public void init() {
		
		reservas = reservaRepository.findAll();
		reserva = new Reserva();
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public int getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(int idreserva) {
		this.idreserva = idreserva;
	}

	

	public void registrar() {
		boolean exits = reservaRepository.existsById(reserva.getIdreserva());
		Destino des = destinoRepository.findById(reserva.getDestino().getIdDestino()).get();
		reserva.setDestino(des);
		Paquetesviaje pa = paquetesviajeRepository.findById(reserva.getPaquetesviaje().getIdpaquetesViaje()).get();
		reserva.setPaquetesviaje(pa);
		Tipoviaje tipo = tipoviajeRepository.findById(reserva.getTipoviaje().getIdTipoViaje()).get();
		reserva.setTipoviaje(tipo);
		Usuario us = usuarioRepository.findById(reserva.getUsuario().getIdUsuario()).get();
		reserva.setUsuario(us);
		Pago pago = pagoRepository.findById(reserva.getPago().getIdpago()).get();
		reserva.setPago(pago);
		Restaurante res = restauranteRepository.findById(reserva.getRestaurante().getIdrestaurante()).get();
		reserva.setRestaurante(res);
		Hotel hotel = hotelRepository.findById(reserva.getHotel().getIdhotel()).get();
		reserva.setHotel(hotel);
		
		if (exits) {

			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			reservaRepository.save(reserva);
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
			reservaRepository.save(reserva);
		}
		init();
	}

	

	public void eliminar(int id) {
		reservaRepository.deleteById(id);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int id) {
		reserva = reservaRepository.findById(id).get();

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public ReservaRepository getReservaRepository() {
		return reservaRepository;
	}

	public PaquetesviajeRepository getPaquetesviajeRepository() {
		return paquetesviajeRepository;
	}

	public DestinoRepository getDestinoRepository() {
		return destinoRepository;
	}

	public TipoviajeRepository getTipoviajeRepository() {
		return tipoviajeRepository;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public PagoRepository getPagoRepository() {
		return pagoRepository;
	}

	public RestauranteRepository getRestauranteRepository() {
		return restauranteRepository;
	}

	public HotelRepository getHotelRepository() {
		return hotelRepository;
	}

}