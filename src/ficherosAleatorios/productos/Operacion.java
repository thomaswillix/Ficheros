package ficherosAleatorios.productos;

/**
 *
 * @author Thomas Freitas
 */
public class Operacion {
    private String operacion, campo;
    private int codigo, cantidad;
    double precio;

    public Operacion() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Operacion{" + "operacion=" + operacion + ", campo=" + campo + ", codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
