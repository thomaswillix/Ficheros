package ficherosSerializables.supermercado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Thomas Freitas
 */
public class Compra implements Serializable{
    Date fechaCompra;
    String dniClient;
    int codigoProducto; //hace ref al int codugoProducto de la clase Producto
    int udsCompradas;
    LocalDate fechaCaducidad;

    public Compra(Date fechaCompra, String dniClient, int codigoProducto, int udsCompradas, LocalDate fechaCaducidad) {
        this.fechaCompra = fechaCompra;
        this.dniClient = dniClient;
        this.codigoProducto = codigoProducto;
        this.udsCompradas = udsCompradas;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getUdsCompradas() {
        return udsCompradas;
    }

    public void setUdsCompradas(int udsCompradas) {
        this.udsCompradas = udsCompradas;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.fechaCompra);
        hash = 17 * hash + Objects.hashCode(this.dniClient);
        hash = 17 * hash + this.codigoProducto;
        hash = 17 * hash + this.udsCompradas;
        hash = 17 * hash + Objects.hashCode(this.fechaCaducidad);
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
        final Compra other = (Compra) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "fechaCompra=" + fechaCompra + ", dniClient=" + dniClient + ", codigoProducto=" + codigoProducto + ", udsCompradas=" + udsCompradas + ", fechaCaducidad=" + fechaCaducidad + '}';
    }
    
}
