package pl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ClaseEJB;
import dl.Cliente;
import dl.Evento;
import dl.Opinion;

@Named
@SessionScoped
public class OpinionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClaseEJB ejb;
	private Opinion opinion = new Opinion();
	private List<Opinion> listadoOpiniones;
	private int idOpinion;
	private float p1, p2, p3, p4, p5, p6, p7, p8;
	private String textoOpinion;
	private BigDecimal valoracion;
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

	public void setTextoOpinion(String textoOpinion) {
		this.textoOpinion = textoOpinion;
	}

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

	public BigDecimal getValoracion() {
		return valoracion;
	}

	public void setValoracion(Evento ev) {
		float v = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8) / 8;
		valoracion = BigDecimal.valueOf(v);
		opinion.setValoracion(valoracion);
		setValoracionTotal(ev);
		ejb.aniadirOpinion(opinion);
	}

	public void setValoracionTotal(Evento ev) {
		listadoOpiniones = ejb.getOpinionesEvento(ev);
		int numOpiniones = listadoOpiniones.size();
		int i = 0;
		BigDecimal vF, vC; // valoracion Final valoracion Current
		vF = BigDecimal.ZERO;
		vC = BigDecimal.ZERO;
		for (i = 0; i < numOpiniones; i++) {
			vC = listadoOpiniones.get(i).getValoracion();
			vF.add(vC);
		}
		if (!vF.equals(BigDecimal.ZERO)) {
			valoracion = vF.divide(BigDecimal.valueOf(numOpiniones));
			evento.setValoracionTotal(valoracion);
		}
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

	public List<Opinion> getListadoOpiniones(Evento ev) {
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

	public void aniadirOpinion(Cliente cliente, String textoOpinion, BigDecimal valoracion) {
		opinion.setCliente(cliente);
		opinion.setTextoOpinion(textoOpinion);
		opinion.setValoracion(valoracion);
		ejb.aniadirOpinion(opinion);
	}

}
