package lessons14;

import java.awt.print.Printable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServerException {
		int count = 0, res = 0;
		DataInputStream inputStream;
		DataOutputStream outputStream;
		PrintWriter printWriter= response.getWriter();;
		inputStream = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(
								"C:/Java/apache-tomcat-7.0.53/webapps/myapp/WEB-INF/count.txt")));

		try {
			res = inputStream.readInt();
		} catch (EOFException e1) {
			res = 0;
		}
		while (true) {
			try {
				count = res;
				res = inputStream.readInt();
			} catch (EOFException e) {
				break;

			}
		}
		inputStream.close();
		count++;
		outputStream = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(
								"C:/Java/apache-tomcat-7.0.53/webapps/myapp/WEB-INF/count.txt")));
		outputStream.writeInt(count);
		outputStream.close();
		String countString = count + "";
		
		printWriter
				.println("<html><head><title>FirstServlet</title><body><h1>This is FirstServletEx2</h1>");
		printWriter.println("<p>Page visited: " + countString
				+ " </body></head></html>");
	}
}
