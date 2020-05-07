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

	@EJB
	private ClaseEJB ejb;
	private Login login = new Login();
	private String tipoUsuario;
	private String usuario;
	private String password;

	boolean clienteCorrecto = false, contraseniaCorrecta = false;

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

	// gestionar desde LogicaNegocio que los datos introducidos OK>>Login succesful

}
