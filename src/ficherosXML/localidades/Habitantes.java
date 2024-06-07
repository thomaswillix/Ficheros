package ficherosXML.localidades;

/**
 *
 * @author Thomas Freitas
 */
public class Habitantes {
    private int hombres;
    private int mujeres;

    public Habitantes() {
    }

    public int getHombres() {
        return hombres;
    }

    public void setHombres(int hombres) {
        this.hombres = hombres;
    }

    public int getMujeres() {
        return mujeres;
    }

    public void setMujeres(int mujeres) {
        this.mujeres = mujeres;
    }

    @Override
    public String toString() {
        return "Habitantes{" + "hombres=" + hombres + ", mujeres=" + mujeres + '}';
    }

}
