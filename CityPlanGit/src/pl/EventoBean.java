package pl;

import java.io.Serializable;
import java.util.Random;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import bl.CrunchifyQRCode;
import dl.Cliente;
import dl.Comerciante;
import dl.Evento;

@Named
@SessionScoped
public class EventoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Evento evento = new Evento();
	private Cliente cliente = new Cliente();
	private Comerciante comerciante = new Comerciante();
	private String nombreFiltro;
	private String enlace = null;

	@EJB
	private ClaseEJB ejb;

	public Evento getEvento() {
		return evento;
	}

	public Comerciante getComerciante() {
		return comerciante;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String getNombreFiltro() {
		return nombreFiltro;
	}

	public void setNombreFiltro(String nombreFiltro) {
		this.nombreFiltro = nombreFiltro;

	}

	public void addEvento(Evento evento, Comerciante comerciante) {
		setEvento(obtenerEnlaceOpinion(evento));
		ejb.aniadirEvento(evento, comerciante.getIdComerciante(), ejb.getFiltroPorNombre(nombreFiltro).getIdFiltro());
	}

	public Evento obtenerEventoNombre(Evento evento) {
		String nombreEvento = evento.getNombreEvento();
		nombreEvento.replace("+", " ");
		evento = ejb.obtenerEventoPorNombreEJB(nombreEvento);
		return evento;
	}

	public void deleteEvento(int idEvento) {
		ejb.eliminarEvento(idEvento);
	}

	public Evento obtenerEnlaceOpinion(Evento evento) {
		Random r = new Random();
		if (!cliente.equals(null)) {
			int numEnlace = r.nextInt(2000);
			enlace = Integer.toString(numEnlace);
			String[] params = new String[2];
			params[0] = evento.getNombreEvento() + enlace;
			CrunchifyQRCode.main(params);
			evento.setCodigoQR(params[0]);
		}
		return evento;
	}

}