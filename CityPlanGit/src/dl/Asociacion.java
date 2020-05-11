package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Asociacion database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Asociacion.findAll", query = "SELECT a FROM Asociacion a"),
		@NamedQuery(name = "Asociacion.findAsociacionPorCIF", query = "SELECT a FROM Asociacion a WHERE a.cif=:cif") })

public class Asociacion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAsociacion;
	private String cif;
	private String nombreAsociacion;

	public Asociacion() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdAsociacion() {
		return this.idAsociacion;
	}

	public void setIdAsociacion(int idAsociacion) {
		this.idAsociacion = idAsociacion;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombreAsociacion() {
		return this.nombreAsociacion;
	}

	public void setNombreAsociacion(String nombreAsociacion) {
		this.nombreAsociacion = nombreAsociacion;
	}

}