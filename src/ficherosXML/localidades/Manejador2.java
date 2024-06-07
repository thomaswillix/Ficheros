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
public class Manejador2 extends DefaultHandler{
    List<Localidad2> lista = new ArrayList<Localidad2>();
    StringBuilder buffer = new StringBuilder();
    Localidad2 l;
    Habitantes h;

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
                l.setH(h);
                break;
            case "mujeres":
                h.setMujeres(Integer.parseInt(buffer.toString()));
                break;
            case "hombres":
                h.setHombres(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Localidad":
                l = new Localidad2();
                l.setId(Integer.parseInt(attributes.getValue("numero")));
                lista.add(l);
                break;
            case "Continente":
            case "Pais":
            case "Capital":
            case "mujeres":
            case "hombres":
                buffer.delete(0, buffer.length());
                break;
            case "Habitantes":
                h = new Habitantes();
                break;
        }
    }

    public List<Localidad2> getLista() {
        return lista;
    }

}
