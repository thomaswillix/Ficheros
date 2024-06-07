package ficherosXML.localidades;

/**
 *
 * @author Thomas Freitas
 */
public class Localidad {

    private int id;
    private String continente;
    private String pais;
    private String capital;
    private int habitantes;

    public Localidad() {
    }

    public Localidad(int id, String continente, String pais, String capital, int habitantes) {
        this.id = id;
        this.continente = continente;
        this.pais = pais;
        this.capital = capital;
        this.habitantes = habitantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    @Override
    public String toString() {
        return "Localidad{" + "id=" + id + ", continente=" + continente + ", pais=" + pais + ", capital=" + capital + ", habitantes=" + habitantes + '}';
    }

}
