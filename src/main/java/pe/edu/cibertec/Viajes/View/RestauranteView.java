package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.RestauranteRepository;
import pe.edu.cibertec.Viajes.entity.Restaurante;

@Component(value = "restauranteView")
@ViewScoped
public class RestauranteView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private RestauranteRepository restauranteRepository;

	private List<Restaurante> restaurantes;

	private Restaurante restaurante;

	@PostConstruct
	public void init() {
		restaurantes = restauranteRepository.findAll();
		restaurante = new Restaurante();
	}

	public void registrar() {
		boolean exits = restauranteRepository.existsById(restaurante.getIdrestaurante());
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			restauranteRepository.save(restaurante);
		} else {

			addMessage("Sistema", "Registro completo");

			restauranteRepository.save(restaurante);
		}
		init();
	}

	public void eliminar(int id) {
		restauranteRepository.deleteById(id);
		addMessage("Sistema", "registro eliminado");

		init();
	}

	public void buscar(int id) {
		restaurante = restauranteRepository.findById(id).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public RestauranteRepository getRestauranteRepository() {
		return restauranteRepository;
	}

	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

}
