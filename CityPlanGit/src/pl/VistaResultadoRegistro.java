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
		pw.println(Utilidades.bodyContainer(userOK));
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
		pw.println(Utilidades.bodyContainer(userExiste));
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);
	}

	public void comercianteOK(PrintWriter pw) {
		String comercianteOK = "<p>COMERCIANTE AÑADIDO SATISFACTORIAMENTE</p><button onclick=\"goBack()\">Volver</button>";

		String codigoGoBack = "<script>\n" + "function goBack() {\n" + "  window.history.back();\n" + "}\n"
				+ "</script>";

		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("COMERCIANTE AÑADIDO", " "));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.scriptHead(codigoGoBack));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.bodyContainer(comercianteOK));
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);
	}

	public void comercianteExiste(PrintWriter pw) {
		String comercianteExiste = "<p>EL COMERCIANTE YA EXISTE</p><button onclick=\"goBack()\">Volver</button>";

		String codigoGoBack = "<script>\n" + "function goBack() {\n" + "  window.history.back();\n" + "}\n"
				+ "</script>";

		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("COMERCIANTE EXISTE", " "));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.scriptHead(codigoGoBack));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.bodyContainer(comercianteExiste));
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);
	}

}
