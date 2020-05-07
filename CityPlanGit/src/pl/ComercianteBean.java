package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Comerciante;

@Named
@SessionScoped
public class ComercianteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ClaseEJB ejb;
	private Comerciante comerciante = new Comerciante();

	private boolean aniadido;

	public ComercianteBean() {
		aniadido = false;
	}

	public Comerciante getComerciante() {
		return comerciante;
	}

	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}

	public void addComerciante() {
		ejb.aniadirComerciante(comerciante);
		aniadido = true;
	}

	public void deleteComerciante(int idComerciante) {
		ejb.eliminarComerciante(idComerciante);
	}

	public Boolean finalizarRegistroComerciante() {
		return aniadido;
	}

}
