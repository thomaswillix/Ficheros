package ficherosSerializables.punto;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thoma
 */
public class Punto implements Serializable{
    private int coordX, coordY;
    private double distOrigen;

    public Punto(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.distOrigen = Math.sqrt(Math.pow(this.coordX, 2) + Math.pow(this.coordY, 2));
    }

    public Punto() {
    }

    public static void almacenarPuntosEnArchivo(File f1, File f2) throws IOException{
        Punto p;
        ArrayList<Punto> lista = new ArrayList<>();
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(f1));
            try {
                while (true) {
                    p = new Punto(dis.readInt(), dis.readInt());
                    lista.add(p);
                }
            } catch (EOFException e) {
                dis.close();
                System.err.println("End of file");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        }
        if (f2.exists()) {
            MiClaseOutput co = new MiClaseOutput(new FileOutputStream(f2, true));
            for (Punto punto : lista) {
                co.writeObject(punto);
            }
            co.close();
        }else{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f2));

            for (Punto punto : lista) {
                oos.writeObject(punto);
            }
            oos.close();

        }
    }

    public static ArrayList<Punto> obtenerArrayListDeArchivo(File f){
        ArrayList<Punto> lista = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            try {
                Punto p = (Punto) ois.readObject();
                lista.add(p);
            } catch (EOFException e) {
                ois.close();
                System.err.println("End of file");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found");
        } catch (IOException ex) {
            Logger.getLogger(Punto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Clase no encontrada");
        }
        return lista;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public double getDistOrigen() {
        return distOrigen;
    }

    public void setDistOrigen(double distOrigen) {
        this.distOrigen = distOrigen;
    }

    @Override
    public String toString() {
        return "Punto{" + "coordX=" + coordX + ", coordY=" + coordY + ", distOrigen=" + distOrigen + '}';
    }

}
