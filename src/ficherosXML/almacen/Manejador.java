package ficherosXML.almacen;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class Manejador extends DefaultHandler{
    private Lote l;
    private Contenido c;
    private ArrayList<Lote> lista = new ArrayList<>();
    private StringBuilder buffer =  new StringBuilder();


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "numcajas":
                l.setNumCajas(Integer.parseInt(buffer.toString()));
                break;
            case "componente":
                c.setComponente(buffer.toString());
                break;
            case "numserie":
                c.setNumSerie(buffer.toString());
                break;
            case "unidades":
                c.setUnidades(Integer.parseInt(buffer.toString()));
                break;
            case "peso":
                l.setPeso(buffer.toString());
                break;
            case "manipulacion":
                l.setManipulacion(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "lote":
                l = new Lote();
                l.setId(Integer.parseInt(attributes.getValue("id")));
                lista.add(l);
                break;
            case "contenido":
                c = new Contenido();
                l.setC(c);
                break;
            case "numcajas":
            case "componente":
            case "numserie":
            case "unidades":
            case "peso":
            case "manipulacion":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public ArrayList<Lote> getLista() {
        return lista;
    }

}