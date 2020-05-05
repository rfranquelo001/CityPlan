package pl;

import java.io.PrintWriter;

public class VistaResultadoRegistro implements InterfazVista {

	@Override
	public void imprime(PrintWriter pw) {
		// TODO Auto-generated method stub

	}

	public void usuarioOK(PrintWriter pw) {
		String userOK = "<p>USUARIO AÑADIDO SATISFACTORIAMENTE</p><button onclick=\"goBack()\">Volver</button>";

		String codigoGoBack = "<script>\n" + "function goBack() {\n" + "  window.history.back();\n" + "}\n"
				+ "</script>";

		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("USUARIO AÑADIDO", " "));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.scriptHead(codigoGoBack));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.bodyContainer(userOK)); // MENSAJE DE ERROR DE ACCESO Y UN BOTON DE VUELTA ATRAS
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);
	}

	public void usuarioExiste(PrintWriter pw) {
		String userExiste = "<p>EL USUARIO YA EXISTE</p><button onclick=\"goBack()\">Volver</button>";

		String codigoGoBack = "<script>\n" + "function goBack() {\n" + "  window.history.back();\n" + "}\n"
				+ "</script>";

		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("USUARIO EXISTE", " "));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.scriptHead(codigoGoBack));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.bodyContainer(userExiste)); // MENSAJE DE ERROR DE ACCESO Y UN BOTON DE VUELTA ATRAS
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);
	}

}
