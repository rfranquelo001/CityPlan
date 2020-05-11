package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Comerciante database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Comerciante.findAll", query = "SELECT c FROM Comerciante c"),
		@NamedQuery(name = "Comerciante.findComerciantePorNombre", query = "SELECT c FROM Comerciante c WHERE c.nombreComerciante=:nombreComerciante") })

public class Comerciante implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idComerciante;
	private String correoComerciante;
	private String nombreComerciante;
	private String passwordComerciante;
	private Asociacion asociacion;

	public Comerciante() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdComerciante() {
		return this.idComerciante;
	}

	public void setIdComerciante(int idComerciante) {
		this.idComerciante = idComerciante;
	}

	public String getCorreoComerciante() {
		return this.correoComerciante;
	}

	public void setCorreoComerciante(String correoComerciante) {
		this.correoComerciante = correoComerciante;
	}

	public String getNombreComerciante() {
		return this.nombreComerciante;
	}

	public void setNombreComerciante(String nombreComerciante) {
		this.nombreComerciante = nombreComerciante;
	}

	public String getPasswordComerciante() {
		return this.passwordComerciante;
	}

	public void setPasswordComerciante(String passwordComerciante) {
		this.passwordComerciante = passwordComerciante;
	}

	// uni-directional many-to-one association to Asociacion
	@ManyToOne
	@JoinColumn(name = "Asociacion_idAsociacion")
	public Asociacion getAsociacion() {
		return this.asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

}