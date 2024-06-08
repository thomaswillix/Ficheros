package ficherosXML.libreria;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class ManejadorEscritores extends DefaultHandler{
    private Libro l;
    private ArrayList<Libro> lista = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "Libro":
                break;
            case "Titulo":
                l.setTitulo(buffer.toString());
                break;
            case "Autor":
                l.setAutor(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Libro":
                l = new Libro();
                l.setId(Integer.parseInt(attributes.getValue("id")));
                lista.add(l);
                break;
            case "Titulo":
            case "Autor":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Libro> getLista() {
        return lista;
    }

}
