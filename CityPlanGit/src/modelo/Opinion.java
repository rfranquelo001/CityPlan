package modelo;

public class Opinion {
	private Cliente cliente;
	private Evento evento;
	private String textoOpinion;
	
	public Opinion() {
		super();
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
	public String getTextoOpinion() {
		return textoOpinion;
	}
	public void setTextoOpinion(String textoOpinion) {
		this.textoOpinion = textoOpinion;
	}
	

}
