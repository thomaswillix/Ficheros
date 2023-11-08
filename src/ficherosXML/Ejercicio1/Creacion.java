package ficherosXML.Ejercicio1;


import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Creacion {
	
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder();
		Document d =  db.newDocument();
		Element c = d.createElement("Curso");
		d.appendChild(c);
		
		for (int i = 0; i <= 3 ; i++) {
			Element al = d.createElement("Alumno");
		}
		TransformerFactory tf =  TransformerFactory.newInstance();
		Transformer t =  tf.newTransformer();
		DOMSource ds = new DOMSource(d);
		
		StreamResult sr =  new StreamResult(new File("notas.xml"));
		StreamResult sr1 = new StreamResult(System.out);
		
		t.transform(ds, sr);
		t.transform(ds, sr1);
		
	}
}
