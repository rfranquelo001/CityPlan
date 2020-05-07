package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Cliente;
import dl.Comerciante;
import dl.Evento;
import dl.Filtro;

@Named
@ViewScoped // Igual tenemos que poner session para que mantenga los filtros del usuario
			// dado de alta y logeado
public class AgendaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ClaseEJB ejb;
	// private List<Evento> listaEventos;

	public List<Evento> getListaEventos() {
		List<Evento> listaEventos = ejb.getEventos();
		String holi = listaEventos.get(0).getNombreEvento();
		String holi2 = listaEventos.get(1).getNombreEvento();
		System.out.println(holi);
		System.out.println(holi2);
		System.out.println("holi\n holi\n holi\n holi\n holi\n holi\n holi\n");
		return listaEventos;
	}

	// No se si nos hace falta el Lazy Get, por si acaso lo dejo hecho
	/*
	 * public List<Evento> getListaEventos() { if(listaEventos==null) { listaEventos
	 * = ejb.getEventos(); } return listaEventos; }
	 */

	public List<Cliente> getListaClientes() {
		ArrayList<Cliente> listaClientes = ejb.getClientes();
		return listaClientes;
	}

	public List<Comerciante> getListaComerciantes() {
		ArrayList<Comerciante> listaComerciantes = ejb.getComerciantes();
		return listaComerciantes;
	}

	public List<Filtro> getListaFiltros() {
		ArrayList<Filtro> listaFiltros = ejb.getFiltros();
		return listaFiltros;
	}

}