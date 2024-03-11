package ficherosXML.libreria;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ManejadorEscritores extends DefaultHandler{

    ArrayList<Libro> libros = new ArrayList<>();
    Libro l;
    StringBuilder sb = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "Titulo":
                l.setTitulo(sb.toString());
                break;
            case "Autor":
                l.setAutor(sb.toString());
                break;
        }
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "Libro":
                l = new Libro();
                libros.add(l);
                l.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case "Titulo":
            case "Autor":
                sb.delete(0, sb.length());
                break;
        }
    }

    public ArrayList<Libro> getLibros() {return libros;}
}
