package ficherosXML.facturas;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class Manejador  extends DefaultHandler{
    private StringBuilder buffer = new StringBuilder();
    private ArrayList<Cliente> listaClientes =  new ArrayList<>();
    private ArrayList<Producto> listaProductos =  new ArrayList<>();
    private Datos d = new Datos();
    private Cliente c;
    private Producto p;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "cliente":
                break;
            case "nombre":
                c.setNombre(buffer.toString());
                break;
            case "NIF":
                c.setNif(buffer.toString());
                break;
            case "fecha":
                c.setFecha(buffer.toString());
                break;
            case "articulo":
                c.setArticulo(buffer.toString());
                break;
            case "unidades":
                c.setUnidades(Integer.parseInt(buffer.toString()));
                break;
            case "producto":
                break;
            case "descripcion":
                p.setDescripcion(buffer.toString());
                break;
            case "precio":
                p.setPrecio(Integer.parseInt(buffer.toString()));
                break;
            case "stock":
                p.setStock(Integer.parseInt(buffer.toString()));
                break;
            case "Clientes":
                d.setClientes(listaClientes);
                break;
            case "Productos":
                d.setProductos(listaProductos);
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "cliente":
                c = new Cliente();
                c.setId(Integer.parseInt(attributes.getValue("id")));
                listaClientes.add(c);
                break;
            case "producto":
                p = new Producto();
                p.setId(attributes.getValue("id"));
                listaProductos.add(p);
                break;
            default:
                buffer.delete(0, buffer.length());
        }
    }

    public Datos getD() {
        return d;
    }

}
