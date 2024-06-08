package ficherosXML.personas;

/**
 *
 * @author Thomas Freitas
 */
public class Persona {
    private int id, profesion;
    private String nombre, fechaNac;

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfesion() {
        return profesion;
    }

    public void setProfesion(int profesion) {
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", profesion=" + profesion + ", nombre=" + nombre + ", fechaNac=" + fechaNac + '}';
    }

}
