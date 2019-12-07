package pe.edu.cibertec.Viajes.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pago database table.
 * 
 */
@Entity
@NamedQuery(name="Pago.findAll", query="SELECT p FROM Pago p")
public class Pago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpago;

	private String tipo;


	public Pago() {
	}

	public int getIdpago() {
		return this.idpago;
	}

	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pago [idpago=" + idpago + ", tipo=" + tipo + "]";
	}

	

//	public Reserva addReserva(Reserva reserva) {
//		getReservas().add(reserva);
//		reserva.setPago(this);
//
//		return reserva;
//	}
//
//	public Reserva removeReserva(Reserva reserva) {
//		getReservas().remove(reserva);
//		reserva.setPago(null);
//
//		return reserva;
//	}

}