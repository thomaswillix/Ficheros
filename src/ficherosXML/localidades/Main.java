package ficherosXML.localidades;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File f = new File("paises.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        Manejador m = new Manejador();
        sp.parse(f, m);
        System.out.println("-------------------- PRIMER PARSEO --------------------");
        List<Localidad> lista1 = m.getLista();
        for (Localidad localidad : lista1) {
            System.out.println(localidad.toString());
        }
        File f2 = new File("paises1.xml");
        Manejador2 m2 = new Manejador2();
        sp.parse(f2, m2);
        System.out.println("-------------------- SEGUNDO PARSEO --------------------");
        List <Localidad2> lista2 = m2.getLista();
        for (Localidad2 localidad : lista2) {
            System.out.println(localidad.toString());
        }
    }
}
