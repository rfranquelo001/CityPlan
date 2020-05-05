package dl;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Opinion database table.
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Opinion.findAll", query = "SELECT o FROM Opinion o"),
		@NamedQuery(name = "Opinion.Valoracion", query = "SELECT o.valoracion FROM Opinion o"), })
public class Opinion implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idOpinion;
	private String textoOpinion;
	private BigDecimal valoracion;
	private Cliente cliente;
	private Evento evento;

	public Opinion() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdOpinion() {
		return this.idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public String getTextoOpinion() {
		return this.textoOpinion;
	}

	public void setTextoOpinion(String textoOpinion) {
		this.textoOpinion = textoOpinion;
	}

	public BigDecimal getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(BigDecimal valoracion) {
		this.valoracion = valoracion;
	}

	// bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name = "Cliente_idCliente")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	// bi-directional many-to-one association to Evento
	@ManyToOne
	@JoinColumn(name = "Evento_idEvento")
	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}