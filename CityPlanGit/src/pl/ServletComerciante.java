package pl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dl.Evento;

/**
 * Servlet implementation class ServletComerciante
 */
@WebServlet("/ServletComerciante")
public class ServletComerciante extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

		// obtener datos del evento:
		evento.setNombreEvento(request.getParameter("tituloEvento"));
		evento.setResumenEvento(request.getParameter("resumenEvento"));
		evento.setDescripcionEvento(request.getParameter("descripcionEvento"));
		try {
			evento.setFechaEvento(formato.parse(request.getParameter("fechaEvento")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		evento.setHoraEvento(request.getParameter("horaEvento"));
		evento.setLocalizacionEvento(request.getParameter("localizacionEvento"));
		evento.setFiltros(Arrays.asList((request.getParameter("filtrosEvento")).split(",")));

		// guardar evento

	}

}
