package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
//@NamedQuery(name = "Evento.findAll", query = "SELECT e FORM Evento e")

public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idEvento;
	@NotNull
	private String nombreEvento;
	@NotNull
	private String resumenEvento;
	@NotNull
	private String descripcionEvento;
	@NotNull
	private String filtrosEvento;
	@NotNull
	private Date fechaEvento;
	@NotNull
	private String horaEvento;
	@NotNull
	private String localizacionEvento;
	@NotNull
	private Comerciantes organizadorEvento;

	public Evento() {
		super();
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getResumenEvento() {
		return resumenEvento;
	}

	public void setResumenEvento(String resumenEvento) {
		this.resumenEvento = resumenEvento;
	}

	public String getDescripcionEvento() {
		return descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public String getFiltrosEvento() {
		return filtrosEvento;
	}

	public void setFiltrosEvento(String filtrosEvento) {
		this.filtrosEvento = filtrosEvento;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getLocalizacionEvento() {
		return localizacionEvento;
	}

	public void setLocalizacionEvento(String localizacionEvento) {
		this.localizacionEvento = localizacionEvento;
	}

	public String getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}

	public Comerciantes getOrganizadorEvento() {
		return organizadorEvento;
	}

	public void setOrganizadorEvento(Comerciantes organizadorEvento) {
		this.organizadorEvento = organizadorEvento;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

}
