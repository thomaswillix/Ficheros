package ficherosXML.bolsa;

/**
 *
 * @author Thomas Freitas
 */
public class Empresa {
    private String indice;
    private String nombre;
    private String simbolo;
    private double precio;

    public Empresa() {
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Empresa{" + "indice=" + indice + ", nombre=" + nombre + ", simbolo=" + simbolo + ", precio=" + precio + '}';
    }

}
