package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.PagoRepository;
import pe.edu.cibertec.Viajes.entity.Pago;

@Component(value = "pagoView")
@ViewScoped
public class PagoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private PagoRepository pagoRepository;
	
	private List<Pago> pagos;
	private Pago pago;
	
	
	@PostConstruct
	public void init() {
		pagos = pagoRepository.findAll();
		pago = new Pago();
	}


	public PagoRepository getPagoRepository() {
		return pagoRepository;
	}


	public Pago getPago() {
		return pago;
	}


	public List<Pago> getPagos() {
		return pagos;
	}
	
	
	
	
	

}
