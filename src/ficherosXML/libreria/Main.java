package ficherosXML.libreria;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class Main {

    public static HashMap<Integer, Libro> libreria = new HashMap<>();

    public static void main(String[] args) throws ParserConfigurationException, ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        File f = new File("files/editoriales.xml");
        File f2 = new File("files/escritores.xml");
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp=spf.newSAXParser();
        ManejadorEditoriales m=new ManejadorEditoriales();
        sp.parse(f, m);
        ArrayList<Libro> lista = m.getLista();

        System.out.println("---------------------LISTA DE EDITORIALES.XML---------------------");
        for (Libro l: lista) {
            System.out.println(l.toString());
        }
        ManejadorEscritores m2 = new ManejadorEscritores();
        sp.parse(f2, m2);
        ArrayList<Libro> lista1 = m2.getLista();

        System.out.println("---------------------LISTA DE ESCRITORES.XML---------------------");
        for (Libro l: lista1) {
            System.out.println(l.toString());
        }

        for (Libro l: lista) {
            l.setAutor("SIN INFORACION");
            l.setTitulo("SIN INFORMACION");
            libreria.put(l.getId(), l);
        }

        for (Libro l1: lista1) {
            int id = l1.getId();
            l1.setTematica("SIN INFORMACION");
            l1.setIdioma("SIN INFORMACION");
            l1.setEditorial("SIN INFORMACION");
            l1.setfPublicacion(0);
            if (libreria.containsKey(id)){
                libreria.get(id).setTitulo(l1.getTitulo());
                libreria.get(id).setAutor(l1.getAutor());
            } else{
                libreria.put(id, l1);
            }
        }
        //CREACION DEL XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("Libreria");
        doc.appendChild(root);
        for (Libro l : libreria.values()) {
            Element libro = doc.createElement("Libro");
            root.appendChild(libro);

            Attr id = doc.createAttribute("id");
            id.appendChild(doc.createTextNode(String.valueOf(l.getId())));
            libro.setAttributeNode(id);

            Attr idioma = doc.createAttribute("idioma");
            idioma.appendChild(doc.createTextNode(l.getIdioma()));
            libro.setAttributeNode(idioma);

            Element titulo = doc.createElement("Titulo");
            titulo.appendChild(doc.createTextNode(l.getTitulo()));
            libro.appendChild(titulo);

            Element autor = doc.createElement("Autor");
            autor.appendChild(doc.createTextNode(l.getAutor()));
            libro.appendChild(autor);

            Element tematica = doc.createElement("Tematica");
            tematica.appendChild(doc.createTextNode(l.getTematica()));
            libro.appendChild(tematica);

            Element editorial = doc.createElement("Editorial");
            editorial.appendChild(doc.createTextNode(l.getEditorial()));
            libro.appendChild(editorial);

            Element fPublicacion = doc.createElement("FPublicacion");
            fPublicacion.appendChild(doc.createTextNode(String.valueOf(l.getfPublicacion())));
            libro.appendChild(fPublicacion);

        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource ds = new DOMSource(doc);

        StreamResult sr = new StreamResult(new File("files/libreria.xml"));
        StreamResult sr1 = new StreamResult(System.out);

        t.transform(ds, sr);
        t.transform(ds, sr1);

    }
}
