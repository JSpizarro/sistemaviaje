package pe.edu.cibertec.Viajes.Rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.Viajes.Repository.PaquetesviajeRepository;
import pe.edu.cibertec.Viajes.entity.Paquetesviaje;

@RestController
public class PaquetesService {

	@Inject
	private PaquetesviajeRepository paquetesviajeRepository;
	
	
	@GetMapping("/paquetes")
//	@RequestMapping(value = "/destino", 
//	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Paquetesviaje> findAllDestinos(){
		return paquetesviajeRepository.findAll();
	}
	
}
