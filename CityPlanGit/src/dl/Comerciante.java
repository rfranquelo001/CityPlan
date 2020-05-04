package dl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the Comerciante database table.
 * 
 */
@Entity
@NamedQuery(name = "Comerciante.findAll", query = "SELECT c FROM Comerciante c")
//METER QUERY EN FUNCION DEL NOMBRE
public class Comerciante implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idComerciante;
	private String correoComerciante;
	private String nombreComerciante;
	private String passwordComerciante;
	private Asociacion asociacion;
	private List<Evento> eventos;

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

	// bi-directional many-to-one association to Asociacion
	@ManyToOne
	@JoinColumn(name = "Asociacion_idAsociacion")
	public Asociacion getAsociacion() {
		return this.asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	// bi-directional many-to-one association to Evento
	@OneToMany(mappedBy = "comerciante")
	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setComerciante(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setComerciante(null);

		return evento;
	}

}