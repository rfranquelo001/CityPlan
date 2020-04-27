package pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.Comerciantes;

/**
 * Servlet implementation class ServletRegistroCliente
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();

		//miro si es Comerciante ó cliente:
		String tipoUsuario= request.getParameter("tipoUsuario");
		if(tipoUsuario.equals("cliente")) {
			Cliente cliente=new Cliente();
			
			//recoger datos del cliente
			cliente.setNombreCliente(request.getParameter("nombreUsuario"));
			cliente.setApellidoCliente(request.getParameter("apellidoUsuario"));
			cliente.setAliasCliente(request.getParameter("username"));
			cliente.setPasswordCliente(request.getParameter("password"));	
			//guardar cliente
			
		}else {
			Comerciantes comerciante=new Comerciantes();
			//recoger datos del comerciante
			comerciante.setNombreComerciante(request.getParameter("nombreUsuario"));
			comerciante.setApellidoComerciante(request.getParameter("apellidoUsuario"));
			comerciante.setAliasComerciante(request.getParameter("username"));
			comerciante.setPasswordComerciante(request.getParameter("password"));
			//guardar comerciante
		}
	
	}

}