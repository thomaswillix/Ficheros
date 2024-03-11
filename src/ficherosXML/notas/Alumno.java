package ficherosXML.notas;

/**
*
* @author Thomas Freitas   
*/

public class Alumno {

	private String id,nombre;
	private int nota1,nota2,proyecto,practica;

	public Alumno() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota1() {
		return nota1;
	}

	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}

	public int getNota2() {
		return nota2;
	}

	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}

	public int getProyecto() {
		return proyecto;
	}

	public void setProyecto(int proyecto) {
		this.proyecto = proyecto;
	}

	public int getPractica() {
		return practica;
	}

	public void setPractica(int practica) {
		this.practica = practica;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", proyecto="
				+ proyecto + ", practica=" + practica + "]";
	}
	
}
