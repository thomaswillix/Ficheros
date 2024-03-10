package ficherosSerializables.supermercado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Thomas Freitas
 */
public class Cliente implements Serializable, Comparable<Cliente>{
    final static private long serialVersionUID=4L;
    String dniClient;
    String nombre;
    String direccion;
    LocalDate fechaIngreso; //Fecha en la que se dio de alta como cliente habitual

    public Cliente(String dniClient, String nombre, String direccion, LocalDate fechaIngreso) {
        this.dniClient = dniClient;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
    }
    public Cliente(String dniClient, String nombre, String direccion) {
        this.dniClient = dniClient;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaIngreso = null;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String dniClient) {
        this.dniClient = dniClient;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.dniClient);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.direccion);
        hash = 41 * hash + Objects.hashCode(this.fechaIngreso);
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
        final Cliente other = (Cliente) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dniClient=" + dniClient + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaIngreso=" + fechaIngreso + '}';
    }

    @Override
    public int compareTo(Cliente o) {
        int codOtro = Integer.parseInt(o.dniClient.substring(0, 8));
        int cod = Integer.parseInt(this.dniClient.substring(0, 8));
        if (cod < codOtro) {
            return -1;
        } else if(cod == codOtro){
            return 0;
        } else{
            return 1;
        }
    }
    
}
