package ficherosXML.localidades;

/**
 *
 * @author Thomas Freitas
 */
public class Localidad2 {
    private int id;
    private String continente;
    private String pais;
    private String capital;
    private Habitantes h;

    public Localidad2() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setH(Habitantes h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "Localidad2{" + "id=" + id + ", continente=" + continente + ", pais=" + pais + ", capital=" + capital + ", habitantes=" + "  hombres: "+ h.getHombres() +", mujeres: " + h.getMujeres() + '}';
    }

}
