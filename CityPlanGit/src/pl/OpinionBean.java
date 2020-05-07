package pl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Cliente;
import dl.Evento;
import dl.Opinion;

@Named
@RequestScoped
public class OpinionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ClaseEJB ejb;
	private Opinion opinion = new Opinion();
	private List<Opinion> listadoOpiniones = new ArrayList<Opinion>();
	// para tener la lista de opiniones para mostrar en
	// detalleEvento.xhtml
	private int idOpinion;
	private String textoOpinion;
	private BigDecimal valoracion;
	private Cliente cliente;
	private Evento evento;

	private boolean hayOpinion;

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	public int getIdOpinion() {
		return idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public String getTextoOpinion() {
		return textoOpinion;
	}

	public void setTextoOpinion(String textoOpinion) {
		this.textoOpinion = textoOpinion;
	}

	public BigDecimal getValoracion() {
		return valoracion;
	}

	public void setValoracion(BigDecimal valoracion) {
		this.valoracion = valoracion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public List<Opinion> getListadoOpiniones() {
		return listadoOpiniones;
	}

	public void setListadoOpiniones(List<Opinion> listadoOpiniones) {
		this.listadoOpiniones = listadoOpiniones;
	}

	public boolean isHayOpinion() {
		return hayOpinion;
	}

	public void setHayOpinion(boolean hayOpinion) {
		this.hayOpinion = hayOpinion;
	}

}
