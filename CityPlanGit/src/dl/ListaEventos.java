package dl;

import java.util.ArrayList;
import java.util.List;

public class ListaEventos {
	private List<Evento> eventos;

	public List<Evento> getEventos() {
		if (eventos == null)
			eventos = new ArrayList<Evento>();
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
}
