package ficherosXML.almacen;

/**
 *
 * @author Thomas Freitas
 */
public class Contenido {
    private String componente, numSerie;
    private int unidades;

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Contenido{" + "componente=" + componente + ", numSerie=" + numSerie + ", unidades=" + unidades + '}';
    }

}