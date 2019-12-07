package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.DestinoRepository;
import pe.edu.cibertec.Viajes.Repository.TipoviajeRepository;
import pe.edu.cibertec.Viajes.entity.Destino;
import pe.edu.cibertec.Viajes.entity.Tipoviaje;

@Component(value = "destinoView")
@ViewScoped
public class DestinoView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private DestinoRepository destinoRepository;

	@Inject
	private TipoviajeRepository tipoviajeRepository;

	private List<Destino> destinos;

	private Destino destino;

	@PostConstruct
	public void init() {
		destinos = destinoRepository.findAll();
		destino = new Destino();
	}

	public List<Destino> getDestinos() {
		return destinos;
	}

	public Destino getDestino() {
		return destino;
	}

	public TipoviajeRepository getTipoviajeRepository() {
		return tipoviajeRepository;
	}

	public void registrar() {
		boolean exits = destinoRepository.existsById(destino.getIdDestino());
		Tipoviaje tipo = tipoviajeRepository.findById(destino.getTipoviaje().getIdTipoViaje()).get();
		destino.setTipoviaje(tipo);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			destinoRepository.save(destino);
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
			destinoRepository.save(destino);
		}
		init();
	}

	public void eliminar(int id) {
		destinoRepository.deleteById(id);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int id) {
		destino = destinoRepository.findById(id).get();
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}