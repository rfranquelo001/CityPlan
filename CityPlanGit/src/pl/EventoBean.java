package pl;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Comerciante;
import dl.Evento;
import dl.Filtro;
import dl.Opinion;

@Named
@RequestScoped
public class EventoBean implements Serializable {

	// recoge los datos introducidos en formularioEvento.xhtml y guarda el nuevo
	// evento en la BBDD

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ClaseEJB ejb;
	private Evento evento = new Evento();
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getCodigoQR() {
		return codigoQR;
	}

	public void setCodigoQR(String codigoQR) {
		this.codigoQR = codigoQR;
	}

	public String getDescripcionEvento() {
		return descripcionEvento;
	}

	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Time getHoraEvento() {
		return horaEvento;
	}

	public void setHoraEvento(Time horaEvento) {
		this.horaEvento = horaEvento;
	}

	public String getImagenEvento() {
		return imagenEvento;
	}

	public void setImagenEvento(String imagenEvento) {
		this.imagenEvento = imagenEvento;
	}

	public String getLocalizacionEvento() {
		return localizacionEvento;
	}

	public void setLocalizacionEvento(String localizacionEvento) {
		this.localizacionEvento = localizacionEvento;
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

	public Comerciante getComerciante() {
		return comerciante;
	}

	public void setComerciante(Comerciante comerciante) {
		this.comerciante = comerciante;
	}

	public List<Filtro> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<Filtro> filtros) {
		this.filtros = filtros;
	}

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	// añadir Evento recogido en el formulario a la BD:
	public void addEventoBD(Evento ev) {

		ejb.aniadirEvento(ev, comerciante.getIdComerciante());
	}

}
