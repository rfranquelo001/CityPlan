package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Vista.Utilidades;
import Vista.VistaPagUsuario;
import modelo.Cliente;
import modelo.Comerciantes;

/**
 * Servlet implementation class ServletLogIn
 */
@WebServlet("/ServletLogIn")
public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogIn() {
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
		String tipoUsuario;
		String usuario;
		String password;
		VistaPagUsuario vistaPag= new VistaPagUsuario();
		
		//miro si es Comerciante ó cliente:
			tipoUsuario= request.getParameter("tipoUsuario");
			usuario=request.getParameter("usuario");
			password=request.getParameter("psw");
			
			if(tipoUsuario.equals("cliente")) {
				Cliente cliente=new Cliente();
				//>>¿COMO HAGO? creo un b¡objeto y busco el nombre en la BBDD y despues comparo con el password??
				//comparar datos del cliente
				if(usuario!=cliente.getAliasCliente()||password!=cliente.getPasswordCliente()) {
					vistaPag.verErrorLogIn(pw," ");//Falta poner el mensaje de error de acceso
				}else {
					
				}
				
			}else {
				Comerciantes comerciante=new Comerciantes();
				//comparar datos del comerciante
				if(usuario!=comerciante.getAliasComerciante()||password!=comerciante.getPasswordComerciante()) {
					vistaPag.verErrorLogIn(pw, " ");//Falta poner el mensaje de error de acceso
				}else {
					
				}
				
			}
	}

}
