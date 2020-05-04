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

	// Calcular nuevo valor de la valoración:
	public int calculaValoracion(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {

		totalValoracion = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8) / 8;
		return totalValoracion;

	}

}
