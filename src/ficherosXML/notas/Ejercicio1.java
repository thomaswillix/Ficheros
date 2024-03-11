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
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
        File f = new File("notas.txt");
        File f2 = new File("notas.xml");

        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.newDocument();
        Element raiz = d.createElement("Curso");
        d.appendChild(raiz);
        String cadena;
        String[] valores;

        cadena = br.readLine();
        while (cadena != null) {
            valores = cadena.split(" ");

            Element alumno = d.createElement("alumno");
            raiz.appendChild(alumno);

            Attr id = d.createAttribute("id");
            id.setValue(valores[0]);
            alumno.setAttributeNode(id);

            Element nombre = d.createElement("nombre");
            nombre.appendChild(d.createTextNode(valores[1]));
            alumno.appendChild(nombre);

            Element nota1 = d.createElement("nota1");
            nota1.appendChild(d.createTextNode(valores[2]));
            alumno.appendChild(nota1);

            Element nota2 = d.createElement("nota2");
            nota2.appendChild(d.createTextNode(valores[3]));
            alumno.appendChild(nota2);

            Element proyecto = d.createElement("proyecto");
            proyecto.appendChild(d.createTextNode(valores[4]));
            alumno.appendChild(proyecto);

            Element practica = d.createElement("practica");
            practica.appendChild(d.createTextNode(valores[5]));
            alumno.appendChild(practica);

            cadena = br.readLine();
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource ds = new DOMSource(d);
        StreamResult sr = new StreamResult(System.out);
        t.transform(ds, sr);
        StreamResult sr1 = new StreamResult(f2);
        t.transform(ds, sr1);
    }
}
