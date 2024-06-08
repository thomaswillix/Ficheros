package ficherosXML.facturas;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        File f =  new File("datos.xml");
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp=spf.newSAXParser();
        Manejador m = new Manejador();
        sp.parse(f, m);
        Datos d = m.getD();

        System.out.println(d.toString());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("Facturas");
        doc.appendChild(root);
        for (Cliente c : d.getClientes()) {
            String prod = c.getArticulo(), desc = "SIN INFORMACION", pr = "SIN INFORMACION", uds = String.valueOf(c.getUnidades());
            int udsStock = 0;
            for (Producto p : d.getProductos()) {
                if (p.getId().equals(c.getArticulo())) {
                    desc =  p.getId();
                    pr = String.valueOf(p.getPrecio());
                    udsStock = p.getStock();
                }
            }
            if (c.getUnidades()<=udsStock){
                Element factura = doc.createElement("Factura");
                root.appendChild(factura);
                Attr nif = doc.createAttribute("NIF");
                nif.appendChild(doc.createTextNode(c.getNif()));
                factura.setAttributeNode(nif);

                Element nombre = doc.createElement("Nombre");
                nombre.appendChild(doc.createTextNode(c.getNombre()));
                factura.appendChild(nombre);

                Element descripcion = doc.createElement("Descripcion");


                descripcion.appendChild(doc.createTextNode(desc));
                factura.appendChild(descripcion);

                Element unidades = doc.createElement("Unidades");
                unidades.appendChild(doc.createTextNode(uds));
                factura.appendChild(unidades);

                Element precio = doc.createElement("Precio");
                precio.appendChild(doc.createTextNode(pr));
                factura.appendChild(precio);

                Element total = doc.createElement("Total");
                if(!pr.equals("SIN INFORMACION")) {
                    total.appendChild(doc.createTextNode(String.valueOf(Integer.parseInt(uds)* Integer.parseInt(pr))));
                } else total.appendChild(doc.createTextNode("SIN INFORMACION"));
                factura.appendChild(total);
            }else System.err.println("NO SE HA PODIDO COMPLETAR EL PEDIDO DEL CIENTE  " + c.getNombre()+ " PORQUE NO HABÍAN SUFICIENTES UNIDADES EN STOCK");
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource ds= new DOMSource(doc);
        StreamResult sr= new StreamResult(new File("facturas.xml"));
        StreamResult sr1 = new StreamResult(System.out);
        transformer.transform(ds, sr);
        transformer.transform(ds, sr1);
    }
}
