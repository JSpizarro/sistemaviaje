package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.UsuarioRepository;
import pe.edu.cibertec.Viajes.entity.Usuario;


@Component(value = "registroView")
@ViewScoped
public class RegistroView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	private Usuario usuario;

	private List<Usuario> usuarios;
	
	
	@PostConstruct
	public void init() {
		usuarios=usuarioRepository.findAll();
		usuario = new Usuario();
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void registrar() {
		boolean exits = usuarioRepository.existsById(usuario.getIdUsuario());
		if (exits) {
			addMessage("Sistema", "Se ha actualizado satisfactoriamente.");
			usuarioRepository.save(usuario);
		} else {
			
			addMessage("Sistema", "Registro completo"
			+"\n"+"Usuario: "+ usuario.getUsuario()+"\n"+"Contraseña: "+usuario.getPassword());
			
			usuarioRepository.save(usuario);
		}
		init();
	}
	
	public void eliminar(int id) {
		usuarioRepository.deleteById(id);
		addMessage("Sistema", "registro eliminado");
		
		init();
	}

	public void buscar(int id) {
		usuario = usuarioRepository.findById(id).get();
	}
	
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}




	
	





}
