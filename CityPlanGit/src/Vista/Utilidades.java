package Vista;


public class Utilidades {
	public static final String DOCTYPE = "<!DOCTYPE html>";
	public static final String FIN = "</body>\n</html>";
	public static final String FINHEAD="</head>\n";
	
	public static String headConTitleStyle(String title,String styleSheetFileName) {
		StringBuilder str = new StringBuilder();
		str.append("<html>\n");
		str.append("<head>\n");
		str.append("<meta charset=\"UTF-8\">\n");
		str.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
		str.append("<title>");
		str.append(title);
		str.append("</title>\n");
		str.append("<link rel=\"stylesheet\" href=\"estiloCityPlan.css\">");
		str.append("<link rel=\"stylesheet\" type=\"text/css\" href=");
		str.append(styleSheetFileName);
		str.append(">\n");
		return str.toString();
		}
	public static String scriptHead(String codigoScript) {
		StringBuilder str = new StringBuilder();
		str.append("<script>\n");
		str.append(codigoScript);
		str.append("</script>\n");
		return str.toString();
	}
	public static String headerConMenu() {
		StringBuilder str = new StringBuilder();
		str.append("<body>\n");
		str.append("<header>\n");
		str.append("<h1><b>CityPlan</b></h1>\n");
		str.append("<h2><b>¿Qué hacemos hoy?</b></h2>\n");
		str.append("<nav class=\"menu\">\n");
		str.append("<ul>\n");
		str.append("<li><a href=\"http://cityplantit.byethost24.com/homeMenu.html\">Home</a></li>\n");
		str.append("<li><a href=\"http://cityplantit.byethost24.com/agenda.html\">Agenda</a></li>\n");
		str.append("<li><a href=\"http://cityplantit.byethost24.com/opinion.html\">Opinión</a></li>\n");
		str.append("<li><a href=\"http://cityplantit.byethost24.com/mapa.html\">Mapa</a></li>\n");
		str.append("<li><a href=\"http://cityplantit.byethost24.com/login.html\">Login</a></li>\n");
		str.append("</ul>\n");
		str.append("</nav>\n");
		str.append("</header>\n");
		return str.toString();
	}
	public static String bodyContainer(String contenido) {
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"container\">\n");
		str.append("<div class=\"colMain\">\n");
		str.append(contenido);
		str.append("\n");
		str.append("</div>\n");
		return str.toString();
	}
	public static String bodyFiltrosyFooter() {
		StringBuilder str = new StringBuilder();
		str.append("<div class=\"leftColumn\">\n");
		str.append("<h2>FILTROS</h2>\n");
		str.append("<p class=\"filtros\">HORARIO</p>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Mañana<br>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Tarde<br>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Noche<br>\n");
		str.append("<p class=\"filtros\">EDAD</p>	\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Adultos(+18)<br> <input class=\"opfiltro\" type=\"checkbox\">Entre\n" + 
				"14 y 16 años<br> <input type=\"checkbox\">Infantil<br>\n");
		str.append("<p class=\"filtros\">TIPO</p>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Deporte<br> <input class=\"opfiltro\" type=\"checkbox\">Museos/exposiciones<br>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Cine<br> <input class=\"opfiltro\" type=\"checkbox\">Teatro<br>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Conciertos<br> <input class=\"opfiltro\" type=\"checkbox\">Gastronomía<br>\n");
		str.append("<input class=\"opfiltro\" type=\"checkbox\">Mercados<br>\n");
		str.append("</div>\n");
		str.append("</div>\n");
		str.append("<div class=\"footer\">\n");
		str.append("<h3>CityPlan</h3>\n");
		str.append("</div>\n");
		return str.toString();
	}

}
