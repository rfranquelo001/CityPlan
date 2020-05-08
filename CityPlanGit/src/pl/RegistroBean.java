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

	private String tipoUsuario;
	private String nombreUsuario;
	private String correo;
	private String password;

	@EJB
	private ClaseEJB ejb;
	private List<Cliente> clientes;
	private List<Comerciante> comerciantes;
	private Cliente cliente;
	private Comerciante comerciante;
	private boolean registrado;

	// Parametros del formulario de registro:
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	// Para añadir usuario, miramos el tipoUsuario y registramos como cliente o como
	// comerciante
	public void addUsuario() {
		if (tipoUsuario.equals("cliente")) {

			setRegistroCliente(nombreUsuario, correo, password);
		} else {
			setRegistroComerciante(nombreUsuario, correo, password);
		}
	}

	// Registrar cliente: comprobamos que el nombre del cliente no está en la BBDD,
	// completamos el objeto cliente con los datos recogidos y ejb añade el nuevo
	// cliente a la BBDD
	public void setRegistroCliente(String nombre, String correo, String contraseña) {

		if (ejb.obtenerClienteConNombre(nombre) != null) {

			cliente.setCorreoCliente(correo);
			cliente.setNombreCliente(nombre);
			cliente.setPasswordCliente(contraseña);

			ejb.aniadirCliente(cliente);
			registrado = true;
		}
	}

	public void setRegistroComerciante(String nombre, String correo, String contraseña) {
		if (ejb.obtenerComercianteConNombre(nombre) != null) {

			comerciante.setCorreoComerciante(correo);
			comerciante.setNombreComerciante(nombre);
			comerciante.setPasswordComerciante(contraseña);

			ejb.aniadirComerciante(comerciante);
			registrado = true;
		}
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

}