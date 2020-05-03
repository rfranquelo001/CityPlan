package bl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dl.Evento;

@Path("/restProvider")
public class RestProvider {

	@GET
	@Path("/listaEventos")
	@Produces(MediaType.APPLICATION_XML)
	public List<Evento> listaEventos() {
		Agenda listaEventos = new Agenda();
		return listaEventos.getAgenda();
	}

}
