package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Cliente;

@Named
@SessionScoped
public class ClienteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ClaseEJB ejb;
	private Cliente cliente = new Cliente();
	private boolean aniadido;

	public ClienteBean() {
		aniadido = false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addCliente() {
		ejb.aniadirCliente(cliente);
		aniadido = true;
	}

	public void deleteCliente(int idCliente) {
		ejb.eliminarCliente(idCliente);
	}

	public Boolean finalizarRegistroCliente() {
		return aniadido;
	}
}