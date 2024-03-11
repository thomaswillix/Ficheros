package ficherosXML.libreria;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class ManejadorEditoriales extends DefaultHandler {
    ArrayList<Libro> libros = new ArrayList<Libro>();
    Libro l;
    StringBuilder sb = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "Editorial":
                l.setEditorial(sb.toString());
                break;
            case "FPublicacion":
                l.setAnioPublicacion(sb.toString());
                break;
            case "Idioma":
                l.setIdioma(sb.toString());
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
                l.setTematica(attributes.getValue("tematica"));
                break;
            case "Editorial":
            case "FPublicacion":
            case "Idioma":
                sb.delete(0, sb.length());
                break;
        }
    }
    public ArrayList<Libro> getLibros(){return libros;}

}
