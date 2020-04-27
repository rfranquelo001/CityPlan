package pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Vista.Utilidades;
import bl.Valoracion;
import modelo.Opinion;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pwGet=response.getWriter();
		pwGet.println(Utilidades.DOCTYPE);
		pwGet.println(Utilidades.headConTitleStyle("Error, solo se puede acceder por POST", "estiloCityPlan.css"));
		response.setContentType("text/html;charset=UTF-8");
		pwGet.println("<body><h2>Este servlet sólo atiende peticiones con POST<h2>");
		pwGet.println(Utilidades.FIN);
		pwGet.close();
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		Opinion opinion=new Opinion();
		Valoracion valoracion=new Valoracion();
		int totalValoracion;
		//opinion.setCliente(cliente);>>COMO LO HAGO???
		//opinion.setEvento(evento);>>COMO LO HAGO???
		opinion.setTextoOpinion(request.getParameter("textoOpinion"));
		
		//valoracion.setCliente(cliente);>>COMO LO HAGO???
		//valoracion.setEvento(evento);>>COMO LO HAGO???
		valoracion.setRespuestasValoracion((request.getParameter("p1")+
				request.getParameter("p2")+
				request.getParameter("p3")+
				request.getParameter("p4")+
				request.getParameter("p5")+
				request.getParameter("p6")+
				request.getParameter("p7")+
				request.getParameter("p8")));
		//calculo totalValoracion
		totalValoracion= (Integer.parseInt("p1")+Integer.parseInt("p2")+Integer.parseInt("p3")+
				Integer.parseInt("p4")+Integer.parseInt("p5")+Integer.parseInt("p6")+
				Integer.parseInt("p7")+Integer.parseInt("p8"))/8;
		
		valoracion.setTotalValoracion(totalValoracion);
		
		//guardar opinion
		//guardar valoracion
		
	}

}
