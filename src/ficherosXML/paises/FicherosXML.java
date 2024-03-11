package ficherosXML.paises;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class FicherosXML {
    public static void main(String[] args) throws ParserConfigurationException, 
            SAXException, IOException{
        File f =  new File("paises1.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp =  spf.newSAXParser();
        Manejador m = new Manejador();
        sp.parse(f, m);
        
        ArrayList<Localidad> lista = m.getLista();
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
    
}
