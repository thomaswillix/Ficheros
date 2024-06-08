package ficherosXML.personas;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class ManejadorPersonas extends DefaultHandler{
    private Persona p;
    private ArrayList<Persona> lista = new ArrayList<Persona>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "persona":
                break;
            case "nombre":
                p.setNombre(buffer.toString());
                break;
            case "fecha_nac":
                p.setFechaNac(buffer.toString());
                break;
            case "profesion":
                p.setProfesion(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "persona":
                p = new Persona();
                p.setId(Integer.parseInt(attributes.getValue("id")));
                lista.add(p);
                break;
            case "nombre":
            case "fecha_nac":
            case "profesion":
                buffer.delete(0, buffer.length());
        }
    }

    public ArrayList<Persona> getLista() {
        return lista;
    }

}
