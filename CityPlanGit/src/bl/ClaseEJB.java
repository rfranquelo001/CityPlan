package bl;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

import dl.Asociacion;
import dl.Cliente;
import dl.Comerciante;
import dl.Evento;
import dl.Filtro;
import dl.Opinion;

@Path("/negocio")
@Stateless
@LocalBean
public class ClaseEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager em;

	// EVENTOS
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ArrayList<Evento> getEventos() {
		ArrayList<Evento> listaEventos = new ArrayList<Evento>();
		listaEventos = (ArrayList<Evento>) em.createNamedQuery("Evento.findAll").getResultList();
		return listaEventos;
	}

	public void aniadirEvento(Evento ev) {
		em.persist(ev);
		System.out.println("Evento dado de alta:\n\t " + ev.getDescripcionEvento() + "\n\t" + ev.getIdEvento());
	}

	public void eliminarEvento(int idEvento) {
		Evento ev = em.find(Evento.class, idEvento);
		em.remove(ev);
	}

	// CLIENTES
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes = (ArrayList<Cliente>) em.createNamedQuery("Cliente.findAll").getResultList();
		return listaClientes;
	}

	public void aniadirCliente(Cliente cli) {
		em.persist(cli);
		System.out.println("Cliente dado de alta:\n\t " + cli.getNombreCliente() + "\n\t" + cli.getIdCliente());
	}

	public void eliminarCliente(int idCliente) {
		Cliente cli = em.find(Cliente.class, idCliente);
		em.remove(cli);
	}

	// COMERCIANTES
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ArrayList<Comerciante> getComerciantes() {
		ArrayList<Comerciante> listaComerciantes = new ArrayList<Comerciante>();
		listaComerciantes = (ArrayList<Comerciante>) em.createNamedQuery("Comerciante.findAll").getResultList();
		return listaComerciantes;
	}

	public void aniadirComerciante(Comerciante com) {
		em.persist(com);
		System.out.println(
				"Comerciante dado de alta:\n\t " + com.getNombreComerciante() + "\n\t" + com.getIdComerciante());
	}

	public void eliminarComerciante(int idComerciante) {
		Comerciante com = em.find(Comerciante.class, idComerciante);
		em.remove(com);
	}

	// ASOCIACIONES
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ArrayList<Asociacion> getAsociaciones() {
		ArrayList<Asociacion> listaAsociaciones = new ArrayList<Asociacion>();
		listaAsociaciones = (ArrayList<Asociacion>) em.createNamedQuery("Asociacion.findAll").getResultList();
		return listaAsociaciones;
	}

	public void aniadirAsociacion(Asociacion as) {
		em.persist(as);
		System.out.println("Asociacion dada de alta:\n\t " + as.getNombreAsociacion() + "\n\t" + as.getIdAsociacion());
	}

	public void eliminarAsociacion(int idAsociacion) {
		Asociacion as = em.find(Asociacion.class, idAsociacion);
		em.remove(as);
	}

	// FILTROS
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ArrayList<Filtro> getFiltros() {
		ArrayList<Filtro> listaFiltros = new ArrayList<Filtro>();
		listaFiltros = (ArrayList<Filtro>) em.createNamedQuery("Filtro.findAll").getResultList();
		return listaFiltros;
	}

	public void aniadirFiltro(Filtro f) {
		em.persist(f);
		System.out.println("Filtro dado de alta:\n\t " + f.getNombreFiltro() + "\n\t" + f.getIdFiltro());
	}

	public void eliminarFiltro(int idFiltro) {
		Filtro f = em.find(Filtro.class, idFiltro);
		em.remove(f);
	}

	// OPINIONES
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	public ArrayList<Opinion> getOpiniones() {
		ArrayList<Opinion> listaOpiniones = new ArrayList<Opinion>();
		listaOpiniones = (ArrayList<Opinion>) em.createNamedQuery("Opinion.findAll").getResultList();
		return listaOpiniones;
	}

	public void aniadirOpinion(Opinion o) {
		em.persist(o);
		System.out.println("Opinion dada de alta:\n\t " + o.getTextoOpinion() + "\n\t" + o.getIdOpinion());
	}

	public void eliminarOpinion(int idOpinion) {
		Opinion o = em.find(Opinion.class, idOpinion);
		em.remove(o);
	}
}
