package bl;

import dl.Cliente;
import dl.Evento;

public class Valoracion {
	private Cliente cliente;
	private Evento evento;
	private int totalValoracion;
	private String respuestasValoracion;

	public Valoracion() {
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

	public int getTotalValoracion() {
		return totalValoracion;
	}

	public void setTotalValoracion(int totalValoracion) {
		this.totalValoracion = totalValoracion;
	}

	public String getRespuestasValoracion() {
		return respuestasValoracion;
	}

	public void setRespuestasValoracion(String respuestasValoracion) {
		this.respuestasValoracion = respuestasValoracion;
	}

}
