package dl;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Evento database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
		@NamedQuery(name = "Evento.findEvento", query = "SELECT e.nombreEvento FROM Evento e") })

public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String codigoQR;
	private String descripcionEvento;
	private Date fechaEvento;
	private Time horaEvento;
	private String imagenEvento;
	private String localizacionEvento;
	private String nombreEvento;
	private String resumenEvento;
	private Comerciante comerciante;
	private List<Filtro> filtros;
	private List<Opinion> opinions;

	public Evento() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getCodigoQR() {
		return this.codigoQR;
	}

	public void setCodigoQR(String codigoQR) {
		this.codigoQR = codigoQR;
	}

	public String getDescripcionEvento() {
		return this.descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechaEvento() {
		return this.fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Time getHoraEvento() {
		return this.horaEvento;
	}

	public void setHoraEvento(Time horaEvento) {
		this.horaEvento = horaEvento;
	}

	public String getImagenEvento() {
		return this.imagenEvento;
	}

	public void setImagenEvento(String imagenEvento) {
		this.imagenEvento = imagenEvento;
	}

	public String getLocalizacionEvento() {
		return this.localizacionEvento;
	}

	public void setLocalizacionEvento(String localizacionEvento) {
		this.localizacionEvento = localizacionEvento;
	}

	public String getNombreEvento() {
		return this.nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getResumenEvento() {
		return this.resumenEvento;
	}

	public void setResumenEvento(String resumenEvento) {
		this.resumenEvento = resumenEvento;
	}

	// bi-directional many-to-one association to Comerciante
	@ManyToOne
	@JoinColumn(name = "Comerciante_idComerciante")
	public Comerciante getComerciante() {
		return this.comerciante;
	}

	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}

	// bi-directional many-to-many association to Filtro
	@ManyToMany(mappedBy = "eventos")
	public List<Filtro> getFiltros() {
		return this.filtros;
	}

	public void setFiltros(List<Filtro> filtros) {
		this.filtros = filtros;
	}

	// bi-directional many-to-one association to Opinion
	@OneToMany(mappedBy = "evento")
	public List<Opinion> getOpinions() {
		return this.opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	public Opinion addOpinion(Opinion opinion) {
		getOpinions().add(opinion);
		opinion.setEvento(this);

		return opinion;
	}

	public Opinion removeOpinion(Opinion opinion) {
		getOpinions().remove(opinion);
		opinion.setEvento(null);

		return opinion;
	}

}