package ficherosXML.bolsa;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class ManejadorEmpresas extends DefaultHandler{
    private Bolsa b;
    private Empresa e;
    private ArrayList<Empresa> lista = new ArrayList<>();
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "Empresa":
                break;
            case "Nombre":
                e.setNombre(buffer.toString());
                break;
            case "Simbolo":
                e.setSimbolo(buffer.toString());
                break;
            case "Precio":
                e.setPrecio(Double.parseDouble(buffer.toString()));
            case "Bolsa":
                b.setEmpresas(lista);
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Bolsa":
                b= new Bolsa();
                b.setDia(attributes.getValue("dia"));
                b.setHora(attributes.getValue("hora"));
                break;
            case "Empresa":
                e = new Empresa();
                e.setIndice(attributes.getValue("indice"));
                lista.add(e);
                break;
            case "Nombre":
            case "Simbolo":
            case "Precio":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public Bolsa getB() {
        return b;
    }

}
