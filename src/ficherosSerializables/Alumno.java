
package ficherosSerializables;

import java.io.Serializable;

public class Alumno implements Serializable{
   final static private long serialVersionUID=4L;
   private int mat;
   private String nombre;

    public Alumno(int mat, String nombre) {
        this.mat = mat;
        this.nombre = nombre;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" + "mat=" + mat + ", nombre=" + nombre + '}';
    }

      
 }
