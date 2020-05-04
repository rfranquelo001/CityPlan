package pl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class TestsServletRegistro extends Mockito {

	@Ignore
	public void testServletRegistro() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testDoGetHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
		// fail("Not yet implemented");
		System.out.println("Test de recogida de datos del regisro");
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("tipoUsuario")).thenReturn("cliente");
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);

		new ServletRegistro().doPost(request, response);
		verify(request, atLeast(1)).getParameter("tipoUsuario");
		writer.flush();
		assertTrue(stringWriter.toString().contains("My expected string"));
	}

}
