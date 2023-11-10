package ficherosXML.Ejercicio1;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author Thomas Freitas
 */
public class Manejador extends DefaultHandler {
	private ArrayList<Alumno> lista = new ArrayList<Alumno>();
	private Alumno a;
	private StringBuilder sb = new StringBuilder();

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "Nombre":
			a.setNombre(sb.toString());
			break;
		case "nota1":
			a.setNota1(Integer.parseInt(sb.toString()));
			break;
		case "nota2":
			a.setNota2(Integer.parseInt(sb.toString()));
			break;
		case "proyecto":
			a.setProyecto(Integer.parseInt(sb.toString()));
			break;
		case "practica":
			a.setPractica(Integer.parseInt(sb.toString()));
			break;
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case "Alumno":
			a = new Alumno();
			lista.add(a);
			a.setId(attributes.getValue("id"));
			break;
		case "nombre":
		case "nota1":
		case "nota2":
		case "proyecto":
		case "practica":
			sb.delete(0, sb.length());
			break;
		}
	}
	 public ArrayList<Alumno> getLista(){
	        return lista;
	    }
}
