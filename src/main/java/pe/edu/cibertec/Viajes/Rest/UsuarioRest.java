package pe.edu.cibertec.Viajes.Rest;



import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.Viajes.Repository.UsuarioRepository;
import pe.edu.cibertec.Viajes.entity.Usuario;

@RestController
public class UsuarioRest {

	
	@Inject
	private UsuarioRepository usuarioRepository;
	
		
	@RequestMapping(value = "/usuario", 
	method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void add(Usuario usuario) {
	usuarioRepository.save(usuario);
	}
	
}
