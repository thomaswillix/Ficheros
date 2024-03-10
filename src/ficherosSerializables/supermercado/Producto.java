package ficherosSerializables.supermercado;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Thomas Freitas
 */
public class Producto implements Serializable {

    int codigoProducto;
    String descripcion;
    double precioUnitario;
    int unidadesVendidas; //En lo que llevamos de anio

    public Producto(int codigoProducto, String descripcion, double precioUnitario, int unidadesVendidas) {
        setCodigoProducto(codigoProducto);
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.unidadesVendidas = unidadesVendidas;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        Scanner sc = new Scanner(System.in);
        while (!validar(codigoProducto)) {
            System.out.println("Ese número no es válido");
            codigoProducto = sc.nextInt();
        }
        this.codigoProducto = codigoProducto;
    }

    private boolean validar(int codigoProducto) {
        String cod = Integer.toString(codigoProducto);
        String a = "0";
        switch(cod.length()){
            case 5:
                a.concat(cod);
                break;
            case 6:
                a = cod;
                break;
            default:
                return false;
        }
        
        int seccion = Integer.valueOf(a.substring(0, 1));
        int prod = Integer.valueOf(a.substring(5, 6));

        if (seccion > 10 || seccion < 1) {
            return false;
        } else if (prod > 25 || prod < 1) {
            return false;
        } else {
            return true;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codigoProducto;
        hash = 89 * hash + Objects.hashCode(this.descripcion);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.precioUnitario) ^ (Double.doubleToLongBits(this.precioUnitario) >>> 32));
        hash = 89 * hash + this.unidadesVendidas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return true;
    }

    @Override
    public String toString() {
        String codigoProString = "";
        if (codigoProducto < 10) {
            codigoProString = "00000" + codigoProducto;
        } else if (codigoProducto >= 10 && codigoProducto < 100) {
            codigoProString = "0000" + codigoProducto;
        }
        return "Producto{" + "codigoProducto=" + codigoProString + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + ", unidadesVendidas=" + unidadesVendidas + '}';
    }

}
