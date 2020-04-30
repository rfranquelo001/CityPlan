package bl;

import java.util.ArrayList;
import java.util.List;

import dl.Evento;

public class Agenda {

	List<Evento> agenda;

	public Agenda() {
		// constructor
		super();
	}

	public List<Evento> getAgenda() {
		return agenda;
	}

	public void setAgenda(ArrayList<Evento> agenda) {
		this.agenda = agenda;
	}

}
