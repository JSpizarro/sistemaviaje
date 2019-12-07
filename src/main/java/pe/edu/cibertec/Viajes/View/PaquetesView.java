package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.PaquetesviajeRepository;
import pe.edu.cibertec.Viajes.Repository.TipoviajeRepository;
import pe.edu.cibertec.Viajes.entity.Paquetesviaje;
import pe.edu.cibertec.Viajes.entity.Tipoviaje;

@Component(value = "paquetesView")
@ViewScoped
public class PaquetesView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idpaquetesViaje;

	@Inject
	private PaquetesviajeRepository paquetesviajeRepository;

	@Inject
	private TipoviajeRepository tipoviajeRepository;

	private List<Paquetesviaje> paquetesviajes;

	private Paquetesviaje paquetesviaje;


	@PostConstruct
	public void init() {
		paquetesviajes = paquetesviajeRepository.findAll();
		paquetesviaje = new Paquetesviaje();
	}

	public TipoviajeRepository getTipoviajeRepository() {
		return tipoviajeRepository;
	}

	public List<Paquetesviaje> getPaquetesviajes() {
		return paquetesviajes;
	}

	public Paquetesviaje getPaquetesviaje() {
		return paquetesviaje;
	}

	public PaquetesviajeRepository getPaquetesviajeRepository() {
		return paquetesviajeRepository;
	}

	public void registrar() {
		boolean exits = paquetesviajeRepository.existsById(paquetesviaje.getIdpaquetesViaje());
		Tipoviaje tipo = tipoviajeRepository.findById(paquetesviaje.getTipoviaje().getIdTipoViaje()).get();
		paquetesviaje.setTipoviaje(tipo);
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			paquetesviajeRepository.save(paquetesviaje);
		} else {
			addMessage("Sistema", "Se ha registrado satisfactoriamente.");
			paquetesviajeRepository.save(paquetesviaje);
		}
		init();
	}

	public void eliminar(int id) {
		paquetesviajeRepository.deleteById(id);
		addMessage("Sistema", "Se ha eliminado satisfactoriamente.");
		init();
	}

	public void buscar(int id) {
		paquetesviaje = paquetesviajeRepository.findById(id).get();
		

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public int getIdpaquetesViaje() {
		return idpaquetesViaje;
	}

	public void setIdpaquetesViaje(int idpaquetesViaje) {
		this.idpaquetesViaje = idpaquetesViaje;
	}


	
	
	

}
