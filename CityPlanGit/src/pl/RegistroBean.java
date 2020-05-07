package pl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Cliente;
import dl.Comerciante;

@Named // Acceso al bean utilizando su nombre: registroBean
@RequestScoped // Se crea una vez para cada petición HTTP
public class RegistroBean {
	@EJB
	private ClaseEJB ejb;
	private List<Cliente> clientes;
	private List<Comerciante> comerciantes;
	private Cliente cliente;
	private Comerciante comerciante;
	private boolean registradoCliente;
	private boolean registradoComerciante;

	// Para poder obtener los clientes para hacer el registro
	public List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = ejb.getClientes();
		}
		return clientes;
	}

	// Para poder obtener los comerciantes para hacer el registro
	public List<Comerciante> getComerciantes() {
		if (comerciantes == null) {
			comerciantes = ejb.getComerciantes();
		}
		return comerciantes;
	}

	// Tomar la decisión de registrar uno u otro parece más sencilla desde el xhtml,
	// seleccionando un action u otro
	// Sino, se puede hacer que el elegir uno u otro nos de el valor y la función
	// quedaría así
	public void realizarRegistro(boolean tipoUsuario) {
		if (tipoUsuario) { // true --> cliente
			setRegistroCliente(cliente.getNombreCliente());
		} else {
			setRegistroComerciante(comerciante.getNombreComerciante());
		}
	}

	public void setRegistroCliente(String nombre) {
		if (ejb.obtenerClienteConNombre(nombre) != null) {
			ejb.aniadirCliente(cliente);
			registradoCliente = true;
		}
	}

	public void setRegistroComerciante(String nombre) {
		if (ejb.obtenerComercianteConNombre(nombre) != null) {
			ejb.aniadirComerciante(comerciante);
			registradoComerciante = true;
		}
	}

}