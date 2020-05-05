package pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bl.ClaseEJB;
import bl.Valoracion;
import dl.Evento;
import dl.Opinion;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	// atiende los datos del formulario de valoracion de opinion.html
	private static final long serialVersionUID = 1L;
	@EJB
	ClaseEJB ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pwGet = response.getWriter();
		pwGet.println(Utilidades.DOCTYPE);
		pwGet.println(Utilidades.headConTitleStyle("Error, solo se puede acceder por POST", "estiloCityPlan.css"));
		response.setContentType("text/html;charset=UTF-8");
		pwGet.println("<body><h2>Este servlet sólo atiende peticiones con POST<h2>");
		pwGet.println(Utilidades.FIN);
		pwGet.close();

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		Evento evento;
		Opinion opinion;
		Valoracion valoracion = new Valoracion();
		float totalValoracion, totalValoracionBD, totValEvento;

		HttpSession session = request.getSession(true);

		// ESTE METODO ME LO CARGARÍA, EN LA BBDD VALORACION SE GUARDA COMO UN CAMPO DE
		// OPINION
		// valoracion.setRespuestasValoracion((request.getParameter("p1") +
		// request.getParameter("p2")
		// + request.getParameter("p3") + request.getParameter("p4") +
		// request.getParameter("p5")
		// + request.getParameter("p6") + request.getParameter("p7") +
		// request.getParameter("p8")));

		// calculo totalValoracion
		// HACE FALTA OBTENER DEL EJB LA VALORACION ACTUAL DEL EVENTO
		evento = ejb.getEvento(request.getParameter("nombreEvento"));
		totalValoracionBD = opinion.getValoracion();
		totalValoracion = valoracion.calculaValoracion(Integer.parseInt(request.getParameter("p1")),
				Integer.parseInt(request.getParameter("p2")), Integer.parseInt(request.getParameter("p3")),
				Integer.parseInt(request.getParameter("p4")), Integer.parseInt(request.getParameter("p5")),
				Integer.parseInt(request.getParameter("p6")), Integer.parseInt(request.getParameter("p7")),
				Integer.parseInt(request.getParameter("p8")), request.getParameter("nombreEvento"));

		// recalculo valoracion del evento:
		// totValEvento=evento.recalculaValoracion(Integer.parseInt("p1"),
		// Integer.parseInt("p2"),
		// Integer.parseInt("p3"), Integer.parseInt("p4"), Integer.parseInt("p5"),
		// Integer.parseInt("p6"), Integer.parseInt("p7"), Integer.parseInt("p8"));
		// evento=ejb.g

		// GUARDAR OPINION y VALORACION
		// ******************************************
		// Problema, obtener idEvento y idCliente
		// ******************************************
		// SCOPES: https://memorynotfound.com/servlet-attributes-example/
		//
		// obtener con el EJB el evento
		// evento=ejb.getEvento();
		// opinion.setCliente(cliente);>>COMO LO HAGO???
		// opinion.setEvento(evento);>>COMO LO HAGO???

		opinion.setTextoOpinion(request.getParameter("textoOpinion"));
		opinion.setValoracion(BigDecimal.valueOf(totalValoracion));

		// valoracion.setCliente(cliente);>>COMO LO HAGO???
		// valoracion.setEvento(evento);>>COMO LO HAGO???

		ejb.aniadirOpinion(opinion);

	}

}
