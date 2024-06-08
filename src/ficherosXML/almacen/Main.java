package ficherosXML.almacen;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        File f =  new File("files/Almacen.xml");
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp=spf.newSAXParser();
        Manejador m =  new Manejador();
        sp.parse(f, m);
        ArrayList<Lote> lista =  m.getLista();

        //Creación del xml
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root =  doc.createElement("Resumen");
        doc.appendChild(root);
        for (Lote lote : lista) {
            Element articulo  =  doc.createElement("Articulo");
            root.appendChild(articulo);
            Attr nombre =  doc.createAttribute("nombre");
            nombre.appendChild(doc.createTextNode(lote.getC().getComponente()));
            articulo.setAttributeNode(nombre);

            Element cajas = doc.createElement("cajas");
            cajas.appendChild(doc.createTextNode(String.valueOf(lote.getNumCajas())));
            articulo.appendChild(cajas);

            Element total = doc.createElement("total");
            total.appendChild(doc.createTextNode(String.valueOf(lote.getNumCajas() * lote.getC().getUnidades())));
            articulo.appendChild(total);

            Element peso = doc.createElement("peso");
            peso.appendChild(doc.createTextNode(lote.getPeso()));
            articulo.appendChild(peso);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource ds= new DOMSource(doc);
        StreamResult sr= new StreamResult(new File("files/resumen.xml"));
        StreamResult sr1 = new StreamResult(System.out);
        transformer.transform(ds, sr);
        transformer.transform(ds, sr1);

    }
}