package ficherosBinarios;

public class Beca {
    String nom;
    char s;
    int edad;
    int asig;
    boolean resi;
    double rent;
    int cuantiaBeca;

    public Beca(String nom, char s, int edad, int asig, boolean resi, double rent) {
        this.nom = nom;
        this.s = s;
        this.edad = edad;
        this.asig = asig;
        this.resi = resi;
        this.rent = rent;
        this.cuantiaBeca = 1500;
    }
    public int getCuantiaBeca() {
        return cuantiaBeca;
    }

    public void setCuantiaBeca() {
        if(this.rent<=12000){
            cuantiaBeca+=500;
        }
        if(this.edad<23){
            cuantiaBeca+=200;
        }
        if (resi){
            cuantiaBeca+=1000;
        }
        switch(asig){
            case 0:
                cuantiaBeca+=500;
                break;
            case 1:
                cuantiaBeca +=200;
                break;
            default:
                cuantiaBeca = 0;
        }
    }

    @Override
    public String toString() {
        return "Beca{" +
                "nom='" + nom + '\'' +
                ", s=" + s +
                ", edad=" + edad +
                ", asig=" + asig +
                ", resi=" + resi +
                ", rent=" + rent +
                ", cuantiaBeca=" + cuantiaBeca +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getS() {
        return s;
    }

    public void setS(char s) {
        this.s = s;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAsig() {
        return asig;
    }

    public void setAsig(int asig) {
        this.asig = asig;
    }

    public boolean isResi() {
        return resi;
    }

    public void setResi(boolean resi) {
        this.resi = resi;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

}
