package pl;

import java.io.PrintWriter;

public class VistaPagUsuario implements InterfazVista {

	@Override
	public void imprime(PrintWriter pw) {
		// TODO Auto-generated method stub

	}

	public void verPagFormularioOpinion(PrintWriter pw) {
		String codigoScript = "function msg(){\n" + "	alert(\"¡Gracias por tu valoración!\");\n" + "}\n" + "\n"
				+ "function msgOpinion(){\n" + "	if(document.getElementById(\"message\").value==\"\"){ \n"
				+ "		alert(\"Por favor escribe una breve opinión\");\n" + "	}else{\n"
				+ "		alert(\"¡Gracias por tu opinión!\");\n" + "	}\n" + "}";
		String contenidoFormOpinion = "";
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("Error LogIn", " "));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.scriptHead(codigoScript));
		pw.println(Utilidades.FINHEAD);
		pw.println(Utilidades.bodyContainer(contenidoFormOpinion));
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);

	}

	public void verErrorLogIn(PrintWriter pw) {
		String errorLogIn = "<p>ERROR: Log In incorrecto</p><button onclick=\"goBack()\">Volver</button>";
		String codigoGoBack = "<script>\n" + "function goBack() {\n" + "  window.history.back();\n" + "}\n"
				+ "</script>";
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("Error LogIn", " "));
		pw.println(Utilidades.scriptHead(codigoGoBack));
		pw.println(Utilidades.headerConMenu());
		pw.println(Utilidades.bodyContainer(errorLogIn));
		// MENSAJE DE ERROR DE ACCESO Y UN BOTON DE VUELTA ATRAS!!
		pw.println(Utilidades.bodyFiltrosyFooter());
		pw.println(Utilidades.FIN);
	}

}
