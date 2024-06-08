package ficherosXML.bolsa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class Main {
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, TransformerConfigurationException, TransformerException {
        File f = new File("files/Bolsa.xml");
        SAXParserFactory spf=SAXParserFactory.newInstance();
        SAXParser sp=spf.newSAXParser();
        ManejadorEmpresas m = new ManejadorEmpresas();
        sp.parse(f, m);
        Bolsa b = m.getB();
        System.out.println("------------------- CONTENIDO DEL ARCHIVO Bolsa.xml -------------------");
        System.out.println(b.toString());

        ManejadorOperaciones m2 = new ManejadorOperaciones();
        File f2 = new File("files/datos.xml");
        sp.parse(f2, m2);
        ArrayList<Operacion> operaciones = m2.getLista();
        ArrayList<Empresa> empresas = b.getEmpresas();
        Empresa e;
        System.out.println("------------------- CONTENIDO DEL ARCHIVO datos.xml -------------------");
        for (Operacion operacion : operaciones) {
            System.out.println(operacion.toString());
            int id = existeEmpresa(empresas, operacion);
            switch(operacion.getId()){
                case 'A':
                    if(id !=-1) System.err.println("La empresa ya existe por lo que no puede ser añadida");
                    else {
                        e = new Empresa();
                        e.setIndice(operacion.getIndice());
                        e.setNombre(operacion.getNombre());
                        e.setSimbolo(operacion.getSimbolo());
                        e.setPrecio(operacion.getPrecio());
                        empresas.add(e);
                    }
                    break;
                case 'M':
                    if (id==-1) System.err.println("La empresa no existe por lo que no se ha podido modificar");
                    else{
                        e = empresas.get(id);
                        e.setNombre(operacion.getNombre());
                        e.setPrecio(operacion.getPrecio());
                    }
                    break;
                case 'B':
                    if(id==-1) System.err.println("La empresa no existe por lo que no se ha podido borrar");
                    else empresas.remove(empresas.get(id));
            }
        }
        System.out.println("------------------- CREACIÓN DEL ARCHIVO bolsaactualizada.xml -------------------");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("Bolsa");
        root.setAttribute("dia", b.getDia());
        root.setAttribute("hora", b.getHora());
        doc.appendChild(root);
        for (int i = 0; i < empresas.size(); i++) {
            e = empresas.get(i);
            Element empresa = doc.createElement("Empresa");
            empresa.setAttribute("indice", e.getIndice());
            root.appendChild(empresa);

            Element nombre = doc.createElement("Nombre");
            nombre.setTextContent(e.getNombre());
            empresa.appendChild(nombre);

            Element simbolo = doc.createElement("Simbolo");
            simbolo.setTextContent(e.getSimbolo());
            empresa.appendChild(simbolo);

            Element precio = doc.createElement("Precio");
            precio.setTextContent(String.valueOf(e.getPrecio()));
            empresa.appendChild(precio);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource ds= new DOMSource(doc);
        StreamResult sr= new StreamResult(new File("files/bolsaactualizada.xml"));
        StreamResult sr1 = new StreamResult(System.out);
        transformer.transform(ds,sr);
        transformer.transform(ds,sr1);
    }

    private static int existeEmpresa(ArrayList<Empresa> empresas, Operacion operacion) {
        for (Empresa empresa : empresas) {
            if (empresa.getNombre().equals(operacion.getNombre())){
                return empresas.indexOf(empresa);
            }
        }
        return -1;
    }
}
