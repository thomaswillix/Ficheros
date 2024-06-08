package ficherosXML.personas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        File f1 =  new File("personas");
        File f2 =  new File("profesiones");
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp=spf.newSAXParser();

        ManejadorPersonas m1 = new ManejadorPersonas();
        sp.parse(f1, m1);
        ArrayList<Persona> listaPer = m1.getLista();

        ManejadorProfesiones m2=new ManejadorProfesiones();
        sp.parse(f2, m2);
        ArrayList<Profesion> listaPr = m2.getLista();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("PersonasActualizado");
        doc.appendChild(root);
        for (Persona p : listaPer) {
            int j=0;
            String prof;
            while (j<listaPr.size() && listaPr.get(j).getId() != p.getProfesion()) {
                j++;
            }
            if (j==listaPr.size()) {
                prof = "SIN DATOS";
            }else prof= listaPr.get(j).getNombre();

            Element persona = doc.createElement("persona");
            root.appendChild(persona);

            Attr id = doc.createAttribute("id");
            id.appendChild(doc.createTextNode(String.valueOf(p.getId())));
            persona.setAttributeNode(id);

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(p.getNombre()));
            persona.appendChild(nombre);

            Element profesion = doc.createElement("profesion");
            profesion.appendChild(doc.createTextNode(prof));
            persona.appendChild(profesion);

        }
        File f = new File("personasactualizado.xml");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource ds= new DOMSource(doc);
        StreamResult sr= new StreamResult(f);
        StreamResult sr1 = new StreamResult(System.out);
        transformer.transform(ds, sr);
        transformer.transform(ds, sr1);
    }
}
