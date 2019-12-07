package pe.edu.cibertec.Viajes.Rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.Viajes.Repository.ReservaRepository;
import pe.edu.cibertec.Viajes.entity.Reserva;

@RestController
public class ReservasRestController {

	@Inject
	private ReservaRepository reservaRepository;
	
	
	
	
	@RequestMapping(value = "/reserva", 
	method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}

	
	@RequestMapping(value = "/reservas/{id}", 
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reserva getOne(@PathVariable(value = "id") int id) {
		return reservaRepository.findById(id).get();
	}
	
	
	
	
	@RequestMapping(value = "/reserva", 
	method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void add(Reserva reserva) {
		reservaRepository.save(reserva);
	}
	
	
	@PutMapping("/reserva/{id}")
	public void update(Reserva reserva,@PathVariable(value="id")int id) {
		reservaRepository.findById(id).ifPresent((x)->{
			reserva.setIdreserva(id);
			reservaRepository.save(reserva);
		});
	}
	
	
	@DeleteMapping("/reserva/{id}")
	public void delete(@PathVariable(value="id")int id) {
		reservaRepository.deleteById(id);
	}

}
