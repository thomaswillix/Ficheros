package ficherosXML.notas;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Thomas Freitas
 */
public class Manejador extends DefaultHandler {
	ArrayList<Alumno> lista=new ArrayList<Alumno>();
	Alumno al;
	StringBuilder sb=new StringBuilder();

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		sb.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName){

			case "nombre":al.setNombre(sb.toString());
				break;
			case "nota1": al.setNota1(Integer.parseInt(sb.toString()));
				break;
			case "nota2":al.setNota2(Integer.parseInt(sb.toString()));
				break;
			case "practica":al.setPractica(Integer.parseInt(sb.toString()));
				break;
			case "proyecto": al.setProyecto(Integer.parseInt(sb.toString()));
				break;
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(qName){
			case "alumno": al=new Alumno();
				lista.add(al);
				al.setId(attributes.getValue("id"));
				break;
			case "nombre":
			case "nota1":
			case "nota2":
			case "practica":
			case "proyecto": sb.delete(0, sb.length());
				break;
		}
	}

	public ArrayList<Alumno> getLista(){
		return lista;
	}
}
