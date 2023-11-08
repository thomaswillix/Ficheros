package ficherosXML.creacion;

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

public class Creacion {	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
		DocumentBuilder db =  dbf.newDocumentBuilder(); 
		Document d = db.newDocument();
		Element root =  d.createElement("Raiz");
		d.appendChild(root);
		
		for (int i =1; i <= 5; i++) {
			Element p = d.createElement("NodoPadre_" + i);
			Attr id =  d.createAttribute("id");
			id.setValue(String.valueOf(1));
			p.setAttributeNode(id);
			root.appendChild(p);
			
			
			Element h1 =  d.createElement("Hijo_1");
			Text valor=d.createTextNode(String.valueOf((int)(Math.random()*10)));
			h1.appendChild(valor);
			p.appendChild(h1);
			
			Element h2 =  d.createElement("Hijo_2");
			valor=d.createTextNode(String.valueOf((int)(Math.random()*10)));
			h2.appendChild(valor);
			p.appendChild(h2);
			
			Element h3 =  d.createElement("Hijo_3");
			valor=d.createTextNode(String.valueOf((int)(Math.random()*10)));
			h3.appendChild(valor);
			p.appendChild(h3);

			Element h4 =  d.createElement("Hijo_4");
			valor=d.createTextNode(String.valueOf((int)(Math.random()*10)));
			h4.appendChild(valor);
			p.appendChild(h4);

			Element h5 =  d.createElement("Hijo_5");
			valor=d.createTextNode(String.valueOf((int)(Math.random()*10)));
			h5.appendChild(valor);
			p.appendChild(h5);
		}
		
		TransformerFactory tf =  TransformerFactory.newInstance();
		Transformer t =  tf.newTransformer();
		DOMSource ds = new DOMSource(d);
		
		StreamResult sr =  new StreamResult(new File("prueba.xml"));
		StreamResult sr1 = new StreamResult(System.out);
		
		t.transform(ds, sr);
		t.transform(ds, sr1);
		
	}
}
