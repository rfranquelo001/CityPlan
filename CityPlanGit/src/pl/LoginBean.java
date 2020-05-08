package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import bl.Login;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	// Recoge los datos del login de login.xhtml y
	// comprueba si son válidos( consulta BBDD)
	@EJB
	private ClaseEJB ejb;
	private Login login = new Login();// >>PENDIENTE DE ELIMINAR??

	private String tipoUsuario;
	private String usuario;
	private String password;

	private boolean correcto = false;

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Verificar que los datos introducidos OK>>Login succesful
	public void valida() {
		if (tipoUsuario.equals("cliente")) {
			correcto = ejb.verificarCliente(usuario, password);
		} else {
			correcto = ejb.verificarComerciante(usuario, password);
		}

	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

}
