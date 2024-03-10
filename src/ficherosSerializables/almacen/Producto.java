package ficherosSerializables.almacen;

import java.io.Serializable;

public class Producto implements Serializable {
    private int codigo;
    private String nombre;
    private int existencias;
    private double precio;

    public Producto(int codigo, String nombre, int existencias, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.existencias = existencias;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", existencias=" + existencias +
                ", precio=" + precio +
                '}';
    }
}
