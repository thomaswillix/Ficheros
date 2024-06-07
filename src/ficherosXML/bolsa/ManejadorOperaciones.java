package ficherosXML.bolsa;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class ManejadorOperaciones extends DefaultHandler {
    private ArrayList<Operacion> lista = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();
    private Operacion o;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "Operacion":
                break;
            case "Indice":
                o.setIndice(buffer.toString());
                break;
            case "Nombre":
                o.setNombre(buffer.toString());
                break;
            case "Simbolo":
                o.setSimbolo(buffer.toString());
                break;
            case "Precio":
                o.setPrecio(Double.parseDouble(buffer.toString()));
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Operacion":
                o = new Operacion();
                o.setId(attributes.getValue("id").charAt(0));
                lista.add(o);
                break;
            case "Indice":
            case "Nombre":
            case "Simbolo":
            case "Precio":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Operacion> getLista() {
        return lista;
    }

}
