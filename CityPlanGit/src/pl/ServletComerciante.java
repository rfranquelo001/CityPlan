package pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.ClaseEJB;
import dl.Evento;
import dl.Filtro;

/**
 * Servlet implementation class ServletComerciante
 */
@WebServlet("/ServletComerciante")
public class ServletComerciante extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClaseEJB ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletComerciante() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		Evento evento = new Evento();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		List<String> filtros;

		// obtener datos del evento:
		evento.setNombreEvento(request.getParameter("tituloEvento"));
		evento.setResumenEvento(request.getParameter("resumenEvento"));
		evento.setDescripcionEvento(request.getParameter("descripcionEvento"));
		try {
			evento.setFechaEvento(formato.parse(request.getParameter("fechaEvento")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		evento.setHoraEvento(Time.valueOf(request.getParameter("horaEvento")));
		evento.setLocalizacionEvento(request.getParameter("localizacionEvento"));

		List<Filtro> filtrosBD = ejb.getFiltros(); // obtengo listado de filtros de la BBDD
		filtros = Arrays.asList((request.getParameter("filtrosEvento")).split(","));
		// comparar string con nombreFiltro y si coincide asocial el evento al filtro

		// guardar evento

	}

}
