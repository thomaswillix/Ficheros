package ficherosXML.almacen;

/**
 *
 * @author Thomas Freitas
 */
public class Lote {
    private int id, numCajas;
    private Contenido c;
    private String peso, manipulacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCajas() {
        return numCajas;
    }

    public void setNumCajas(int numCajas) {
        this.numCajas = numCajas;
    }

    public Contenido getC() {
        return c;
    }

    public void setC(Contenido c) {
        this.c = c;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getManipulacion() {
        return manipulacion;
    }

    public void setManipulacion(String manipulacion) {
        this.manipulacion = manipulacion;
    }

    @Override
    public String toString() {
        return "Lote{" + "id=" + id + ", numCajas=" + numCajas + ", c=" + c.toString() + ", peso=" + peso + ", manipulacion=" + manipulacion + '}';
    }


}
