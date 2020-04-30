package bl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/restProvider")
public class RestProvider {

	@GET
	@Path("/listaEventos")
	@Produces(MediaType.APPLICATION_XML)
	public Agenda listaEventos() {
		Agenda listaEventos = new Agenda();
		return listaEventos;
	}

}
