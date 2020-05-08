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

	// Recoge los datos de login.xhtml a partir de usuarioBean comprueba el
	// tipoUsuario y guarda en la BBDD un nuevo cliente o nuevo comerciante

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

	// propongo usar este otro metodo, usamos un bean auxiliar: UsuarioBean,
	// generico y luego diferenciamos si es cliente o comerciante y guardamos
	// DUDA hay que pasar cada parametro (nombreUsuario>nombreCliente,
	// passwordUsuario>>passwordCliente...)??
	public void addUsuario(UsuarioBean usuario) {
		if ((usuario.getTipoUsuario()).equals("cliente")) {

			setRegistroCliente(usuario.getUsuario());
		} else {
			setRegistroComerciante(usuario.getUsuario());
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