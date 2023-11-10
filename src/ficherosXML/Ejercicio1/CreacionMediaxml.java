package ficherosXML.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class CreacionMediaxml {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File f = new File("notas.xml");
		SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp =  spf.newSAXParser();
        Manejador m = new Manejador();
        sp.parse(f, m);
		
        ArrayList<Alumno> lista = m.getLista();
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
		
//		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
//		DocumentBuilder db =  dbf.newDocumentBuilder();
//		Document d =  db.newDocument();
//		Element n = d.createElement("Notas");
//		double me = 0;
//		
//		
//		
//		Attr media = d.createAttribute(String.valueOf(me));
//		n.appendChild(media);
//		d.appendChild(n);
//		
		
	}
}
