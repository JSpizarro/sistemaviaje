package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.TipoviajeRepository;
import pe.edu.cibertec.Viajes.entity.Tipoviaje;

@Component(value = "tipoView")
@ViewScoped
public class TipoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Tipoviaje tipoviaje;

	private List<Tipoviaje> tipoviajes;

	@Inject
	private TipoviajeRepository tipoviajeRepository;

	@PostConstruct
	public void init() {
		tipoviajes = tipoviajeRepository.findAll();
		tipoviaje = new Tipoviaje();
	}

	public Tipoviaje getTipoviaje() {
		return tipoviaje;
	}

	public TipoviajeRepository getTipoviajeRepository() {
		return tipoviajeRepository;
	}

	public List<Tipoviaje> getTipoviajes() {
		return tipoviajes;
	}
	
	
	public void registrar() {
		boolean exits = tipoviajeRepository.existsById(tipoviaje.getIdTipoViaje());
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			tipoviajeRepository.save(tipoviaje);
		} else {
			
			addMessage("Sistema", "Registro completo");
			
			tipoviajeRepository.save(tipoviaje);
		}
		init();
	}
	
	public void eliminar(int id) {
		tipoviajeRepository.deleteById(id);
		addMessage("Sistema", "registro eliminado");
		
		init();
	}

	public void buscar(int id) {
		tipoviaje = tipoviajeRepository.findById(id).get();
	}
	
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
