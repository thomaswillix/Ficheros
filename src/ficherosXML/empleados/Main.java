package ficherosXML.empleados;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        File f = new File("files/empleados.xml");
        SAXParserFactory spf =SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        Manejador m = new Manejador();
        sp.parse(f, m);
        List<Empleado> lista = m.getLista();

        for (Empleado empleado : lista) {
            System.out.println(empleado.toString());
        }
    }
}
