package pl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.ClaseEJB;
import dl.Cliente;
import dl.Comerciante;

/**
 * Servlet implementation class ServletLogIn
 */
@WebServlet("/ServletLogIn")
public class ServletLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClaseEJB ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogIn() {
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
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String tipoUsuario;
		String usuario;
		String password;
		VistaPagUsuario vistaPag = new VistaPagUsuario();
		int k;
		boolean clienteCorrecto = false, contraseniaCorrecta = false;

		// OBTENER DATOS
		tipoUsuario = request.getParameter("tipoUsuario");
		usuario = request.getParameter("usuario");
		password = request.getParameter("psw");

		/*
		 * //OBTENER LISTA DE CLIENTES - FORMA 1 Cliente cliente = new Cliente();
		 * List<Cliente> clientesBD= ejb.getClientes(); List<String> clientesBDString =
		 * new ArrayList<String>(); // creo un listado de string de los clientes de la
		 * BBDD for (k = 0; k < clientesBD.size(); k++) {// obtengo los nombres de los
		 * clientes en la nueva Lista clientesBDString.add(k,
		 * clientesBD.get(k).getNombreCliente()); }
		 */

		/*
		 * //OBTENER LISTA DE COMERCIANTES Comerciante comerciante = new Comerciante();
		 * List<Comerciante> comerciantesBD= ejb.getComerciantes(); List<String>
		 * comerciantesBDString = new ArrayList<String>(); // creo un listado de string
		 * de los clientes de la BBDD for (k = 0; k < comerciantesBD.size(); k++) {//
		 * obtengo los nombres de los clientes en la nueva Lista
		 * comerciantesBDString.add(k, comerciantesBD.get(k).getNombreComerciante()); }
		 */

		// CASO DE QUE SE TRATE DE UN CLIENTE
		if (tipoUsuario.equals("cliente")) {
			// COMPROBAR CLIENTE EXISTENTE - FORMA 2
			Cliente cliente2 = ejb.obtenerClienteConNombre(usuario);
			/*
			 * //CONTRASTAR QUE EL CLIENTE ESTÉ EN LA BASE DE DATOS
			 * for(k=0;k<clientesBDString.size(); k++) { if
			 * (usuario.equals(clientesBDString.get(k))) { clienteCorrecto=true; } }
			 */
			// CONTRASTAR EXISTENCIA DE CLIENTE Y CONTRASEÑA CORRECTA
			if (cliente2 != null) {
				contraseniaCorrecta = ejb.verificarCliente(usuario, password);
			} else {
				vistaPag.verErrorLogIn(pw, " ");// Falta poner el mensaje de error de acceso
			}
		} else if (tipoUsuario.equals("comerciante")) {
			// COMPROBAR COMERCIANTE EXISTENTE - FORMA 2
			Comerciante comerciante2 = ejb.obtenerComercianteConNombre(usuario);
			// CONTRASTAR EXISTENCIA DE COMERCIANTE Y CONTRASEÑA CORRECTA
			if (comerciante2 != null) {
				contraseniaCorrecta = ejb.verificarComerciante(usuario, password);
			} else {
				vistaPag.verErrorLogIn(pw, " ");// Falta poner el mensaje de error de acceso
			}
		}

		if (contraseniaCorrecta) {
			// MARCAR SESSION SCOPED PARA QUE SE MANTENGA LA SESIÓN CON ESE USUARIO Y
			// CONTRASEÑA
		}
	}

}
