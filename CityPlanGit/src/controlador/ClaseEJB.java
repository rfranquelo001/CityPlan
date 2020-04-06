package controlador;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

import modelo.Agenda;
import modelo.Evento;

@Path("/negocio")
@Stateless
@LocalBean
public class ClaseEJB {
	private Agenda agenda;

	@PersistenceContext
	EntityManager em;

	public ClaseEJB() {
		agenda = new Agenda();
	}

	@SuppressWarnings("unchecked")
	public Agenda getAgenda() {
		ArrayList<Evento> listaEventos = null;
		listaEventos = (ArrayList<Evento>) em.createNamedQuery("Evento.findAll").getResultList();
		agenda.setAgenda(listaEventos);

		return agenda;
	}

	public void addEvento(Evento ev) {
		em.persist(ev);
		System.out.println("Evento dado de alta:\n\t " + ev.getDescripcionEvento() + "\n\t" + ev.getIdEvento());
	}
}
