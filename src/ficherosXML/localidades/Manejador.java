package ficherosXML.localidades;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class Manejador extends DefaultHandler{
    StringBuilder buffer = new StringBuilder();
    List<Localidad> lista = new ArrayList<>();
    Localidad l;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "Localidad":
                break;
            case "Continente":
                l.setContinente(buffer.toString());
                break;
            case "Pais":
                l.setPais(buffer.toString());
                break;
            case "Capital":
                l.setCapital(buffer.toString());
                break;
            case "Habitantes":
                l.setHabitantes(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Localidad":
                l = new Localidad();
                l.setId(Integer.parseInt(attributes.getValue("numero")));
                lista.add(l);
                break;
            case "Continente":
            case "Pais":
            case "Capital":
            case "Habitantes":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public List<Localidad> getLista() {
        return lista;
    }

}
