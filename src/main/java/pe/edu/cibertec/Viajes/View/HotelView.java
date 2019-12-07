package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.HotelRepository;
import pe.edu.cibertec.Viajes.entity.Hotel;

@Component(value = "hotelView")
@ViewScoped
public class HotelView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private HotelRepository hotelRepository;

	private List<Hotel> hoteles;

	private Hotel hotel;
	
	
	
	@PostConstruct
	public void init() {
		hoteles = hotelRepository.findAll();
		hotel = new Hotel();
	}
	
	
	

	public HotelRepository getHotelRepository() {
		return hotelRepository;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void registrar() {
		boolean exits = hotelRepository.existsById(hotel.getIdhotel());
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			hotelRepository.save(hotel);
		} else {

			addMessage("Sistema", "Registro completo");

			hotelRepository.save(hotel);
		}
		init();
	}

	
	public void eliminar(int id) {
		hotelRepository.deleteById(id);
		addMessage("Sistema", "registro eliminado");

		init();
	}

	public void buscar(int id) {
		hotel = hotelRepository.findById(id).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
