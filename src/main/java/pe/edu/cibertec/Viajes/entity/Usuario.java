package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	private String apellido;

	private int dni;

	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	private String password;

	private int ruc;

	private String usuario;

	

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRuc() {
		return this.ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email
				+ ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", nombreEmpresa=" + nombreEmpresa
				+ ", password=" + password + ", ruc=" + ruc + ", usuario=" + usuario + "]";
	}

//	public Reserva addReserva(Reserva reserva) {
//		getReservas().add(reserva);
//		reserva.setUsuario(this);
//
//		return reserva;
//	}
//
//	public Reserva removeReserva(Reserva reserva) {
//		getReservas().remove(reserva);
//		reserva.setUsuario(null);
//
//		return reserva;
//	}

	
	
	
	
}