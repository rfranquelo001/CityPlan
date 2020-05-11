package dl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Filtro database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Filtro.findAll", query = "SELECT f FROM Filtro f"),
		@NamedQuery(name = "Filtro.findPorNombre", query = "SELECT f FROM Filtro f WHERE f.nombreFiltro=:nombreFiltro") })
public class Filtro implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idFiltro;
	private String nombreFiltro;

	public Filtro() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdFiltro() {
		return this.idFiltro;
	}

	public void setIdFiltro(int idFiltro) {
		this.idFiltro = idFiltro;
	}

	public String getNombreFiltro() {
		return this.nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro;
	}

}