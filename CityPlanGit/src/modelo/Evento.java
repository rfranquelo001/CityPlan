package modelo;

import java.util.Date;

public class Evento {

	private String nombreEvento;
	private String resumenEvento;
	private String descripcionEvento;
	private String filtrosEvento;
	private Date fechaEvento;
	private String horaEvento;
	private String localizacionEvento;
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
	
}
