package lessons13;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ex13 {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;


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
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getChildNodes();
		NodeList nodeList2;
		NamedNodeMap attributies;
		Element root2;
		for (int i = 0; i < nodeList.getLength(); i++) {
			if (nodeList.item(i) instanceof Element) {
				root2 = (Element) nodeList.item(i);
				nodeList2 = root2.getChildNodes();
				System.out.println();
				for (int j = 0; j < nodeList2.getLength(); j++) {
					if (nodeList2.item(j) instanceof Element) {
						System.out.print(nodeList2.item(j).getTextContent());
						attributies = root2.getAttributes();
						for (int k = 0; k < attributies.getLength(); k++) {
							System.out.print(" "
									+ attributies.item(k).getTextContent()
									+ " ");
						}
					}
				}
			}
		}
	}
}
