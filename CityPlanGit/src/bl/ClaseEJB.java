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
	private boolean errorCliente = false;
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

	// Evento tiene un comerciante, uno o muchos filtros, una o muchas opiniones
	// No se si así funcionará, pero hay que pasarle el idComerciante
	public void aniadirEvento(Evento ev, int idComerciante) {
		Comerciante com = em.find(Comerciante.class, idComerciante);
		ev.setComerciante(com);
		em.persist(ev);
		System.out.println("Evento dado de alta:\n\t " + ev.getDescripcionEvento() + "\n\t" + ev.getIdEvento());
	}

	public void eliminarEvento(int idEvento) {
		Evento ev = em.find(Evento.class, idEvento);
		em.remove(ev);
	}

	public Evento getEvento(String nombreEvento) {
		Evento ev = new Evento();
		ev = (Evento) em.createNamedQuery("Evento.findEvento");
		return ev;
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

	// Avisamos de error si ya existe un registro con ese email
	public boolean registroCliente(Cliente c) {
		String correo = c.getCorreoCliente();
		Cliente c2 = em.find(Cliente.class, correo); // PUEDE QUE NO ESTE BIEN POR NO BUSCAR PK
		if (c2 == null) {
			aniadirCliente(c);
		} else {
			errorCliente = true;
		}
		return true;
	}

	public Cliente obtenerClienteConNombre(String nombre) {
		Cliente c = em.find(Cliente.class, nombre);
		return c;
	}

	// Para verificar que el nombre y contraseña del LOGIN son correctos
	public boolean verificarCliente(String nombre, String contrasenia) {
		boolean verificado = false;
		Cliente c = em.find(Cliente.class, nombre);
		if (contrasenia.equals(c.getPasswordCliente())) {
			verificado = true;
		}
		return verificado;
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

	public Comerciante obtenerComercianteConNombre(String nombre) {
		Comerciante com = em.find(Comerciante.class, nombre);
		return com;
	}

	// Para verificar que el nombre y contraseña del LOGIN son correctos
	public boolean verificarComerciante(String nombre, String contrasenia) {
		boolean verificado = false;
		Comerciante com = em.find(Comerciante.class, nombre);
		if (contrasenia.equals(com.getPasswordComerciante())) {
			verificado = true;
		}
		return verificado;
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

	public float getValoracionBD() {

		Valoracion val = (Valoracion) em.createNamedQuery("Opinion.Valoracion");
		float valoracionBD = val.getTotalValoracion();
		return valoracionBD;

	}
}
