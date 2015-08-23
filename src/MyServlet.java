import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServerException {
		PrintWriter printWriter = response.getWriter();
		printWriter
				.println("<html><head><title>FirstServlet</title><body><h1>This if FirstServlet</h1></body></head></html>");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServerException {
		doGet(request, response);
	}

}
