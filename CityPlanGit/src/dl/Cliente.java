package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Cliente database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
		@NamedQuery(name = "Cliente.findClientePorNombre", query = "SELECT c FROM Cliente c WHERE c.nombreCliente=:nombreCliente") })

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String correoCliente;
	private String nombreCliente;
	private String passwordCliente;

	public Cliente() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCorreoCliente() {
		return this.correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getPasswordCliente() {
		return this.passwordCliente;
	}

	public void setPasswordCliente(String passwordCliente) {
		this.passwordCliente = passwordCliente;
	}

}