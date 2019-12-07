package pe.edu.cibertec.Viajes.Rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.Viajes.entity.Destino;

@RestController
public class DestinosRestController {

	
	@Inject
	private DestinoService destinoService;
	

	
	@GetMapping("/destino")
//	@RequestMapping(value = "/destino", 
//	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Destino> findAllDestinos(){
		return destinoService.getAll();
	}
	
	
	
//	@GetMapping("/destino/{id}")
	@RequestMapping(value = "/destinos/{id}", 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Destino getOne(@PathVariable(value="id")int id){
		return destinoService.get(id);
	}
	
	
	
//	@PostMapping("/destino")
	@RequestMapping(value = "/destino", 
	method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void add(Destino destino) {
//	destinoRepository.save(destino);
	destinoService.post(destino);
	}
	
	
	
	@PutMapping("/destino/{id}")
	public void update(Destino destino,@PathVariable(value="id")int id) {
		destinoService.put(destino, id);
	}
	
	
	@DeleteMapping("/destino/{id}")
	public void delete(@PathVariable(value="id")int id) {
		destinoService.delete(id);
	}
}
