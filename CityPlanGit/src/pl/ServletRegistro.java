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
 * Servlet implementation class ServletRegistroCliente
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClaseEJB ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegistro() {
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
		VistaResultadoRegistro resReg = new VistaResultadoRegistro();
		// miro si es Comerciante ó cliente:
		String tipoUsuario = request.getParameter("tipoUsuario");
		if (tipoUsuario.equals("cliente")) {
			Cliente cliente = new Cliente();

			// recoger datos del cliente
			cliente.setNombreCliente(request.getParameter("nombreUsuario"));
			cliente.setPasswordCliente(request.getParameter("password"));
			// comprobar que no existe un cliente con el mismo nombre
			Cliente cliente2 = ejb.obtenerClienteConNombre(cliente.getNombreCliente());
			if (cliente2 == null) {
				// guardar cliente
				ejb.aniadirCliente(cliente);
				resReg.usuarioOK(pw); // se muestra MENSAJE DE USUARIO AÑADIDO SATISFACTORIAMENTE
			} else {
				resReg.usuarioExiste(pw);// se muestra MENSAJE DE ESE USUARIO YA EXISTE
			}

		} else {
			Comerciante comerciante = new Comerciante();
			// recoger datos del comerciante
			comerciante.setNombreComerciante(request.getParameter("nombreUsuario"));
			comerciante.setPasswordComerciante(request.getParameter("password"));

			// comprobar que no existe un comerciante con el mismo nombre
			Comerciante comerciante2 = ejb.obtenerComercianteConNombre(comerciante.getNombreComerciante());
			if (comerciante2 == null) {
				// guardar comerciante
				ejb.aniadirComerciante(comerciante);
				resReg.comercianteOK(pw);// muestra MENSAJE DE COMERCIANTE AÑADIDO SATISFACTORIAMENTE
			} else {
				resReg.comercianteExiste(pw);// MOSTRAR MENSAJE DE ESE COMERCIANTE YA EXISTE
			}
		}

	}

}