package lessons13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.transform.Transform;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class Ex14 {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;
		StreamResult streamResult = null;

		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File f = new File("C:/Java/workspace/PVTCourses/src/lessons13/Ex11.xml");
		try {
			document = builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File stylesheet = new File(
				"C:/Java/workspace/PVTCourses/src/lessons13/Ex11xsl.xsl");
		StreamSource streamSource = new StreamSource(stylesheet);
		Transformer t = null;
		try {
			t = TransformerFactory.newInstance().newTransformer(streamSource);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		try {
			try {
				streamResult = new StreamResult(new FileOutputStream(
						"E14xsl.html"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			t.transform(new DOMSource(document.getDocumentElement()),
					streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
