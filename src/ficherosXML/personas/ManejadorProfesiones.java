package ficherosXML.personas;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class ManejadorProfesiones extends DefaultHandler{
    private Profesion p;
    private ArrayList<Profesion> lista = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "profesion":
                break;
            case "nombre":
                p.setNombre(buffer.toString());
                break;
            case "categoria":
                p.setCategoria(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "profesion":
                p = new Profesion();
                p.setId(Integer.parseInt(attributes.getValue("id")));
                lista.add(p);
                break;
            case "nombre":
            case "categoria":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Profesion> getLista() {
        return lista;
    }

}
