package ficherosXML.notas;


import java.io.*;

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

/**
 * @author Thomas Freitas
 */

public class Ejercicio1 {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root=doc.createElement("Curso");
        doc.appendChild(root);
        for (int i = 0; i < 3; i++) {
            Element e = doc.createElement("alumno");
            root.appendChild(e);
            Attr id = doc.createAttribute("id");
            Element nombre = doc.createElement("nombre");
            Element nota1 = doc.createElement("nota1");
            Element nota2 = doc.createElement("nota2");
            Element proyecto = doc.createElement("proyecto");
            Element practica = doc.createElement("practica");
            switch(i){
                case 0:
                    id.setValue("jj");
                    nombre.setTextContent("Juan Carlos");
                    nota1.setTextContent("5");
                    nota2.setTextContent("7");
                    proyecto.setTextContent("8");
                    practica.setTextContent("9");
                    break;
                case 1:
                    id.setValue("cp");
                    nombre.setTextContent("Christian Perez");
                    nota1.setTextContent("7");
                    nota2.setTextContent("8");
                    proyecto.setTextContent("7");
                    practica.setTextContent("4");
                    break;
                case 2:
                    id.setValue("sf");
                    nombre.setTextContent("Sonia Fernandez");
                    nota1.setTextContent("6");
                    nota2.setTextContent("9");
                    proyecto.setTextContent("10");
                    practica.setTextContent("10");
                    break;
            }
            e.setAttributeNode(id);
            e.appendChild(nombre);
            e.appendChild(nota1);
            e.appendChild(nota2);
            e.appendChild(proyecto);
            e.appendChild(practica);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource ds= new DOMSource(doc);
        StreamResult sr= new StreamResult(new File("ejemploCreacion.xml"));
        StreamResult sr1 = new StreamResult(System.out);
        transformer.transform(ds, sr);
        transformer.transform(ds, sr1);
    }

}
