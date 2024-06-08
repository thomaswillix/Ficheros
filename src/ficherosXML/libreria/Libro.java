package ficherosXML.libreria;

/**
 *
 * @author Thomas Freitas
 */
public class Libro {
    private int id;
    private String idioma;
    private String titulo;
    private String autor;
    private String tematica;
    private String editorial;
    private int fPublicacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getfPublicacion() {
        return fPublicacion;
    }

    public void setfPublicacion(int fPublicacion) {
        this.fPublicacion = fPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", idioma=" + idioma + ", titulo=" + titulo + ", autor=" + autor + ", tematica=" + tematica + ", editorial=" + editorial + ", fPublicacion=" + fPublicacion + '}';
    }

}
