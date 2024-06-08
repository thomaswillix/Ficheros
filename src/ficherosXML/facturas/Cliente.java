package ficherosXML.facturas;

/**
 *
 * @author Thomas Freitas
 */
public class Cliente {
    private int id, unidades;
    private String nombre, nif, fecha, articulo;

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", unidades=" + unidades + ", nombre=" + nombre + ", nif=" + nif + ", fecha=" + fecha + ", articulo=" + articulo + '}';
    }

}
