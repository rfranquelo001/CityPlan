package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Cliente;
import dl.Comerciante;

@Named // Acceso al bean utilizando su nombre: registroBean
@ViewScoped // Se crea una vez para cada petición HTTP
public class RegistroBean implements Serializable {

	// Recoge los datos de login.xhtml a partir de usuarioBean comprueba el
	// tipoUsuario y guarda en la BBDD un nuevo cliente o nuevo comerciante

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
	private List<Comerciante> comerciantes;
	private Cliente cliente = new Cliente();
	private Comerciante comerciante = new Comerciante();

	private String tipoUsuario;
	private boolean correcto = false;
	private String usuario;
	private String password;
	private String correoUsuario;
	private String passwordUsuario;
	private String nombreUsuario;
	private String asociacionUsuario;
	private boolean registrado = false;
	// Recoge los datos del login de login.xhtml y
	// comprueba si son válidos( consulta BBDD)
	@EJB
	private ClaseEJB ejb;

	// Verificar que los datos introducidos OK>>Login succesful
	public void valida() {
		if (tipoUsuario.equals("cliente")) {
			correcto = (ejb.verificarCliente(usuario, password));
			if (correcto) {
				cliente = ejb.obtenerClienteConNombre(usuario);
			}
		} else {
			correcto = ejb.verificarComerciante(usuario, password);
			if (correcto) {
				comerciante = ejb.obtenerComercianteConNombre(usuario);
			}
		}
	}

	// Para añadir usuario, miramos el tipoUsuario y registramos como cliente o como
	// comerciante
	public void addUsuario() {
		if (tipoUsuario.equals("cliente")) {
			setRegistroCliente(nombreUsuario, correoUsuario, passwordUsuario);
		} else {
			setRegistroComerciante(nombreUsuario, correoUsuario, passwordUsuario, asociacionUsuario);
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
			setRegistrado(true);
		}
	}

	public void setRegistroComerciante(String nombre, String correo, String contraseña, String asociacionUsuario) {
		if (ejb.obtenerComercianteConNombre(nombre) != null) {

			comerciante.setCorreoComerciante(correo);
			comerciante.setNombreComerciante(nombre);
			comerciante.setPasswordComerciante(contraseña);
			comerciante.setAsociacion(ejb.obtenerAsociacionConCIF(asociacionUsuario));

			ejb.aniadirComerciante(comerciante);
			setRegistrado(true);
		}
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

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setAsociacionUsuario(String asociacionUsuario) {
		this.asociacionUsuario = asociacionUsuario;
	}

	public String getAsociacionUsuario() {
		return asociacionUsuario;
	}

}