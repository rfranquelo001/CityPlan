package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEvento;
	private String codigoQR;
	private String descripcionEvento;
	private Date fechayHora;
	private String imagenEvento;
	private String localizacionEvento;
	private Comerciante comerciante;
	private List<Filtro> filtros;
	private List<Opinion> opinions;

	public Evento() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFechayHora() {
		return this.fechayHora;
	}

	public void setFechayHora(Date fechayHora) {
		this.fechayHora = fechayHora;
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


	//bi-directional many-to-one association to Comerciante
	@ManyToOne
	@JoinColumn(name="Comerciante_idComerciante")
	public Comerciante getComerciante() {
		return this.comerciante;
	}

	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}


	//bi-directional many-to-many association to Filtro
	@ManyToMany(mappedBy="eventos")
	public List<Filtro> getFiltros() {
		return this.filtros;
	}

	public void setFiltros(List<Filtro> filtros) {
		this.filtros = filtros;
	}


	//bi-directional many-to-one association to Opinion
	@OneToMany(mappedBy="evento")
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