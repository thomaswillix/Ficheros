package ficherosXML.notas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
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


public class Ejercicio2 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		File f=new File("medias.xml");
		ArrayList<Alumno> lista=new ArrayList<Alumno>();
		lista=LecturaFichero();
		//  MostrarFichero(lista);
		MostrarInformacion(lista);
		CrearFichero(f,lista);

	}

	static ArrayList LecturaFichero() throws SAXException, IOException, ParserConfigurationException{
		File f=new File("notas.xml");
		Manejador m=new Manejador();
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		ArrayList<Alumno> lista=new ArrayList<Alumno>();
		sp.parse(f, m);
		lista=m.getLista();
		return lista;
	}

	static void MostrarFichero(ArrayList<Alumno> lista){

		for(int i=0;i<lista.size();i++)
			System.out.println(lista.get(i).toString());

	}

	static void MostrarInformacion(ArrayList<Alumno> lista){
		double mediaal=0,mediacur=0;

		for(int i=0;i<lista.size();i++){
			mediaal=(lista.get(i).getNota1()+lista.get(i).getNota2()+lista.get(i).getPractica()+lista.get(i).getProyecto())/4.0;
			mediacur=mediacur+mediaal;
			System.out.println(lista.get(i).getNombre()+" "+mediaal);
		}
		System.out.println("La media del curso es "+(mediacur/lista.size()));

	}

	static void CrearFichero(File f,ArrayList<Alumno> lista) throws ParserConfigurationException, TransformerConfigurationException, TransformerException{
		double mc=0;
		DocumentBuilderFactory dbs=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbs.newDocumentBuilder();
		Document d=db.newDocument();

		Element raiz=d.createElement("Notas");
		d.appendChild(raiz);

		for(int i=0;i<lista.size();i++){

			Element alumno=d.createElement("alumno");
			raiz.appendChild(alumno);

			Element nombre=d.createElement("nombre");
			nombre.appendChild(d.createTextNode(lista.get(i).getNombre()));
			alumno.appendChild(nombre);

			Element nota=d.createElement("nota");
			double media=(lista.get(i).getNota1()+lista.get(i).getNota2()+lista.get(i).getPractica()+lista.get(i).getProyecto())/4.0;
			mc=mc+media;
			nota.appendChild(d.createTextNode(String.valueOf(media)));
			alumno.appendChild(nota);

		}
		Attr MC=d.createAttribute("MediaCurso");
		MC.setValue(String.valueOf(mc/lista.size()));
		raiz.setAttributeNode(MC);
		TransformerFactory tf=TransformerFactory.newInstance();
		Transformer t=tf.newTransformer();
		DOMSource ds=new DOMSource(d);
		StreamResult sr=new StreamResult(f);
		t.transform(ds,sr);
	}
}
