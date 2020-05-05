package bl;

import dl.Cliente;
import dl.Evento;

public class Valoracion {
	private Cliente cliente;
	private Evento evento;
	private float totalValoracion;
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

	public float getTotalValoracion() {
		return totalValoracion;
	}

	public void setTotalValoracion(float totalValoracion) {
		this.totalValoracion = totalValoracion;
	}

	public String getRespuestasValoracion() {
		return respuestasValoracion;
	}

	public void setRespuestasValoracion(String respuestasValoracion) {
		this.respuestasValoracion = respuestasValoracion;
	}

	// Calcular nuevo valor de la valoración:
	// NO ESTÁ DEL TODO BIEN, FALTA METER UN PARÁMETRO CON LA VALORACIÓN ANTERIOR Y
	// EL NÚMERO DE VALORACIONES EXISTENTES
	public float calculaValoracion(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, String nombreEvento) {
		float totalValoracionActual = (p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8) / 8;
		//totalValoracionBD es el valor almacenado en la tabla Evento en la BD, accedo a él a traves de 
		float totalValoracionBD=
			
					
			return totalValoracion;
		}

}
