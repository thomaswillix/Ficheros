package ficherosXML.personas;

/**
 *
 * @author Thomas Freitas
 */
public class Profesion {
    private int id;
    private String nombre, categoria;

    public Profesion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Profesion{" + "id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + '}';
    }

}
