package ficherosBinarios;

import java.io.Serializable;

public class Persona implements Serializable {

    String nombre;
    String apellidos;
    int edad;
    int telefono;
    String email;
    String ciudad;
    String nacionalidad;
    String profesion;

    public Persona(String nombre, String apellidos, int edad, int telefono, String email, String ciudad, String nacionalidad, String profesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.nacionalidad = nacionalidad;
        this.profesion = profesion;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }
}
