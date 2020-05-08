package pl;

import java.io.Serializable;
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
	private List<Opinion> listadoOpiniones = null;
	// para tener la lista de opiniones para mostrar en
	// detalleEvento.xhtml
	private int idOpinion;
	private float p1, p2, p3, p4, p5, p6, p7, p8;
	private String textoOpinion;
	private float valoracion;
	private Cliente cliente;
	private Evento evento;

	private boolean hayOpinion;

	// datos recogidos del formulario en opinion.xhtml:
	public float getP1() {
		return p1;
	}

	public void setP1(float p1) {
		this.p1 = p1;
	}

	public float getP2() {
		return p2;
	}

	public void setP2(float p2) {
		this.p2 = p2;
	}

	public float getP3() {
		return p3;
	}

	public void setP3(float p3) {
		this.p3 = p3;
	}

	public float getP4() {
		return p4;
	}

	public void setP4(float p4) {
		this.p4 = p4;
	}

	public float getP5() {
		return p5;
	}

	public void setP5(float p5) {
		this.p5 = p5;
	}

	public float getP6() {
		return p6;
	}

	public void setP6(float p6) {
		this.p6 = p6;
	}

	public float getP7() {
		return p7;
	}

	public void setP7(float p7) {
		this.p7 = p7;
	}

	public float getP8() {
		return p8;
	}

	public void setP8(float p8) {
		this.p8 = p8;
	}

	public String getTextoOpinion() {
		return textoOpinion;
	}

	public void setTextoOpinion() {

		opinion.setTextoOpinion(textoOpinion);
		ejb.aniadirOpinion(opinion);
	}
	//////////////////////////////////////////////////////

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		hayOpinion = true;
		this.opinion = opinion;
	}

	public int getIdOpinion() {
		return idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public float getValoracion() {
		return valoracion;
	}

	// pasar datos a la Logica de negocio para que calcule la valoracion del evento
	public void setValoracion() {

		valoracion = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8) / 8;
		opinion.setValoracion(valoracion);
		ejb.aniadirOpinion(opinion);

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

	public List<Opinion> getListadoOpiniones(String ev) {
		// Paso el nombre del evento para que el ejb busque en la BBDD las opiniones a
		// partir del nombre
		listadoOpiniones = ejb.getOpinionesEvento(ev);
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
