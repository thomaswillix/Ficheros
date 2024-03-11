package ficherosXML.paises;

/**
 *
 * @author Thomas Freitas
 */
public class Habitante {
    private int hombres;
    private int mujeres;
    
    public Habitante(){
        
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
        return "Habitante{" + "hombres=" + hombres + ", mujeres=" + mujeres + '}';
    }
    
}
