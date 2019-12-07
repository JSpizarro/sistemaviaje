package pe.edu.cibertec.Viajes.View;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import pe.edu.cibertec.Viajes.Repository.UsuarioRepository;
import pe.edu.cibertec.Viajes.entity.Usuario;

@Component(value = "usuarioView")
@ViewScoped
public class UsuarioView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	

	private String nombre;
	@NotEmpty(message = "Usuario en blanco")
	private String usuario;
	@NotEmpty(message = "Contraseña en blanco")
	private String password;

	private Usuario usua;

	

	public Usuario getUsua() {
		return usua;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String login() {
		Usuario us = usuarioRepository.login(usuario, password);
		if (us != null) {
			return "dashboard";
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrecta",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "login";
		}
	}

	

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
