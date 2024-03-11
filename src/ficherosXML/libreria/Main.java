package ficherosXML.libreria;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static HashMap<Integer, Libro> libreria = new HashMap<>();
    public static void main(String[] args) {
        //LECTURA DE LOS XML PARSEANDO CON SPF
        File f = new File("editoriales.xml");
        File f1 = new File("escritores.xml");
        SAXParserFactory spf  = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            ManejadorEditoriales med = new ManejadorEditoriales();
            sp.parse(f, med);
            ArrayList<Libro> lista = med.getLibros();
            System.out.println("---------------------LISTA DE EDITORIALES.XML---------------------");
            for (Libro l: lista) {
                System.out.println(l.toString());
            }
            SAXParser sp1 = spf.newSAXParser();
            ManejadorEscritores mes = new ManejadorEscritores();
            sp1.parse(f1,mes);
            ArrayList<Libro> lista1 = mes.getLibros();
            System.out.println("---------------------LISTA DE ESCRITORES.XML---------------------");
            for (Libro l: lista1) {
                System.out.println(l.toString());
            }

            for (Libro l: lista) {
                libreria.put(l.getId(), l);
            }
            for (Libro l1: lista1) {
                if (libreria.containsKey(l1.getId())){
                    libreria.get(l1.getId()).setTitulo(l1.getTitulo());
                    libreria.get(l1.getId()).setAutor(l1.getAutor());
                } else{
                    libreria.put(l1.getId(), l1);
                    libreria.get(l1.getId()).setTitulo(l1.getTitulo());
                    libreria.get(l1.getId()).setAutor(l1.getAutor());
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        //CREACION DEL DOCUMENTO CON DBF
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ArrayList<Libro> books = new ArrayList<Libro>(libreria.values());
        for (Libro b:
             books) {
            System.out.println(b.toString());
        }
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.newDocument();
            Element root = d.createElement("Libreria");
            d.appendChild(root);
            for (Libro book : books) {
                Element l = d.createElement("Libro");
                Attr id = d.createAttribute("id");
                id.setValue(String.valueOf(book.getId()));
                l.setAttributeNode(id);
                Attr idioma = d.createAttribute("idioma");
                idioma.setValue(book.getIdioma());
                l.setAttributeNode(idioma);
                root.appendChild(l);

                Element tit = d.createElement("Titulo");
                tit.setNodeValue(book.getTitulo());
                l.appendChild(tit);

                Element aut = d.createElement("Autor");
                aut.setNodeValue(book.getAutor());
                l.appendChild(aut);

                Element tem = d.createElement("Tematica");
                tem.setNodeValue(book.getTematica());
                l.appendChild(tem);

                Element ed = d.createElement("Editorial");
                ed.setNodeValue(book.getEditorial());
                l.appendChild(ed);

                Element fPub = d.createElement("FPublicacion");
                fPub.setNodeValue(book.getAnioPublicacion());
                l.appendChild(fPub);
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(d);

            StreamResult sr = new StreamResult(new File("Libreria.xml"));
            StreamResult sr1 = new StreamResult(System.out);

            t.transform(ds, sr);
            t.transform(ds, sr1);

        } catch (ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
