package ficherosXML.notas;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class Ejercicio2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
		File f = new File("ejemploCreacion.xml");
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		Manejador m = new Manejador();
		sp.parse(f, m);
		List<Alumno> alumnos = m.getLista();
		System.out.println("------------ MEDIA POR ALUMNO ------------");
		double media = 0;
		double[] medias = new double[3];
		for (int i = 0; i < medias.length; i++) {
			media = (double)(alumnos.get(i).getNota1() + alumnos.get(i).getNota2() + alumnos.get(i).getPractica() + alumnos.get(i).getProyecto())/4;
			medias[i] = media;
			System.out.println("Media de " + alumnos.get(i).getNombre() + ":" + media);
		}
		media = 0;
		for (int i = 0; i < medias.length; i++) {
			media += medias[i];
		}
		media /= medias.length;
		System.out.println("\n\nMedia de la clase: " + media);

		// CREACION DEL XML
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element root = doc.createElement("Notas");
		root.setAttribute("MediaCurso", String.valueOf(media));
		doc.appendChild(root);
		for (int i = 0; i < medias.length; i++) {
			Element alumno = doc.createElement("alumno");
			root.appendChild(alumno);
			Element nombre = doc.createElement("nombre");
			nombre.setTextContent(alumnos.get(i).getNombre());
			alumno.appendChild(nombre);
			Element nota = doc.createElement("nota");
			nota.setTextContent(String.valueOf(medias[i]));
			alumno.appendChild(nota);
		}
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		DOMSource ds= new DOMSource(doc);
		StreamResult sr= new StreamResult(new File("medias.xml"));
		StreamResult sr1 = new StreamResult(System.out);
		transformer.transform(ds, sr);
		transformer.transform(ds, sr1);
	}
}
