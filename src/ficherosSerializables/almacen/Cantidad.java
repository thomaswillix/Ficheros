package ficherosSerializables.almacen;

import java.io.Serializable;

public class Cantidad implements Serializable {
    private int codProducto;
    private int unidades;

    public Cantidad(int codProducto, int unidades) {
        this.codProducto = codProducto;
        this.unidades = unidades;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Almacen{" +
                "codProducto=" + codProducto +
                ", unidades=" + unidades +
                '}';
    }
}
