package pl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Evento;

@Named
@SessionScoped
public class AgendaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Evento> listaEventos;

	@EJB
	private ClaseEJB ejb;

	public List<Evento> getListaEventos() {
		if (listaEventos == null)
			listaEventos = ejb.getEventos();
		return listaEventos;
	}
}