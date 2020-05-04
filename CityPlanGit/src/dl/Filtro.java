package dl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Filtro database table.
 * 
 */
@Entity
@NamedQuery(name = "Filtro.findAll", query = "SELECT f FROM Filtro f")
//METER QUERY EN FUNCION DEL NOMBRE
public class Filtro implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idFiltro;
	private String nombreFiltro;
	private List<Evento> eventos;

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

	// bi-directional many-to-many association to Evento
	@ManyToMany
	@JoinTable(name = "Filtro_has_Evento", joinColumns = {
			@JoinColumn(name = "Filtro_idFiltro") }, inverseJoinColumns = { @JoinColumn(name = "Evento_idEvento") })
	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

}