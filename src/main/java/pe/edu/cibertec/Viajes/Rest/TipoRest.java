package pe.edu.cibertec.Viajes.Rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.Viajes.Repository.TipoviajeRepository;
import pe.edu.cibertec.Viajes.entity.Tipoviaje;

@RestController
public class TipoRest {

	
	@Inject
	private TipoviajeRepository tipoviajeRepository;
	
	
	@RequestMapping(value = "/tipo", 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tipoviaje> findAll() {
		return tipoviajeRepository.findAll();
	}
	
}
