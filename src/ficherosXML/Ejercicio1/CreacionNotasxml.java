package ficherosXML.Ejercicio1;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
*
* @author Thomas Freitas
*/

public class CreacionNotasxml {
	
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder();
		Document d =  db.newDocument();
		Element c = d.createElement("Curso");
		d.appendChild(c);
		
		for (int i = 0; i <= 3 ; i++) {
			Element al = d.createElement("alumno");

			switch (i) {
				case 1: {
					Attr id =d.createAttribute("id");
					id.setValue("jj");
					al.setAttributeNode(id);
					c.appendChild(al);
					
					Element nom = d.createElement("nombre");
					Text valor = d.createTextNode("Juan Carlos Jimenez");
					nom.appendChild(valor);
					al.appendChild(nom);
					
					Element nt1 = d.createElement("nota1");
					valor =  d.createTextNode(String.valueOf("5"));
					nt1.appendChild(valor);
					al.appendChild(nt1);
					
					Element nt2 = d.createElement("nota2");
					valor = d.createTextNode(String.valueOf("7"));
					nt2.appendChild(valor);
					al.appendChild(nt2);
					
					Element pto=  d.createElement("proyecto");
					valor = d.createTextNode(String.valueOf("8"));
					pto.appendChild(valor);
					al.appendChild(pto);
					
					Element pra =  d.createElement("practica");
					valor = d.createTextNode(String.valueOf("9"));
					pra.appendChild(valor);
					al.appendChild(nt2);
					break;
				}
				case 2: {
					Attr id =d.createAttribute("id");
					id.setValue("cp");
					al.setAttributeNode(id);
					c.appendChild(al);
					
					Element nom = d.createElement("nombre");
					Text valor = d.createTextNode("Christian Perez");
					nom.appendChild(valor);
					al.appendChild(nom);
					
					Element nt1 = d.createElement("nota1");
					valor =  d.createTextNode(String.valueOf("7"));
					nt1.appendChild(valor);
					al.appendChild(nt1);
					
					Element nt2 = d.createElement("nota2");
					valor = d.createTextNode(String.valueOf("8"));
					nt2.appendChild(valor);
					al.appendChild(nt2);
					
					Element pto=  d.createElement("proyecto");
					valor = d.createTextNode(String.valueOf("7"));
					pto.appendChild(valor);
					al.appendChild(pto);
					
					Element pra =  d.createElement("practica");
					valor = d.createTextNode(String.valueOf("4"));
					pra.appendChild(valor);
					al.appendChild(nt2);
					break;
				}
				case 3: {
					Attr id =d.createAttribute("id");
					id.setValue("sf");
					al.setAttributeNode(id);
					c.appendChild(al);
					
					Element nom = d.createElement("nombre");
					Text valor = d.createTextNode("Sonia Fernandez");
					nom.appendChild(valor);
					al.appendChild(nom);
					
					Element nt1 = d.createElement("nota1");
					valor =  d.createTextNode(String.valueOf("6"));
					nt1.appendChild(valor);
					al.appendChild(nt1);
					
					Element nt2 = d.createElement("nota2");
					valor = d.createTextNode(String.valueOf("9"));
					nt2.appendChild(valor);
					al.appendChild(nt2);
					
					Element pto=  d.createElement("proyecto");
					valor = d.createTextNode(String.valueOf("10"));
					pto.appendChild(valor);
					al.appendChild(pto);
					
					Element pra =  d.createElement("practica");
					valor = d.createTextNode(String.valueOf("10"));
					pra.appendChild(valor);
					al.appendChild(nt2);
					break;
				}
			}
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
