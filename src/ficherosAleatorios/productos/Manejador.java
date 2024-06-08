package ficherosAleatorios.productos;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class Manejador extends DefaultHandler{
    private Operacion o;
    private ArrayList<Operacion> lista = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "operacion":
                o = new Operacion();
                o.setOperacion(attributes.getValue("op"));
                lista.add(o);
                break;
            case "codigo":
            case "campo":
            case "cantidad":
            case "precio":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "operacion":
                break;
            case "codigo":
                o.setCodigo(Integer.parseInt(buffer.toString()));
                break;
            case "campo":
                o.setCampo(buffer.toString());
                break;
            case "cantidad":
                o.setCantidad(Integer.parseInt(buffer.toString()));
                break;
            case "precio":
                o.setPrecio(Double.parseDouble(buffer.toString()));
                break;
        }
    }

    public ArrayList<Operacion> getLista() {
        return lista;
    }

}
