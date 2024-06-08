package ficherosXML.facturas;

import java.util.ArrayList;

/**
 *
 * @author Thomas Freitas
 */
public class Datos {
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;

    public Datos() {
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LISTA DE CLIENTES: \n");
        clientes.forEach(c -> sb.append(c.toString()).append("\n"));
        sb.append("LISTA DE PRODUCTOS: \n");
        productos.forEach(p -> sb.append(p.toString()).append("\n"));
        return sb.toString();
    }

}
