package ficherosXML.empleados;

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
    private List<Empleado> empleados = new ArrayList<Empleado>();
    private Empleado e;
    private StringBuilder buffer = new StringBuilder();
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "Empleado":
                break;
            case "nombre":
                e.setNombre(buffer.toString());
                break;
            case "edad":
                e.setEdad(Integer.parseInt(buffer.toString()));
                break;
            case "sexo":
                e.setSexo(buffer.toString());
                break;
            case "categoria":
                e.setCategoria(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Empleado":
                e = new Empleado();
                e.setId(Integer.parseInt(attributes.getValue("id")));
                empleados.add(e);
                break;
            case "nombre":
            case "edad":
            case "sexo":
            case "categoria":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public List<Empleado> getLista() {
        return empleados;
    }


}
