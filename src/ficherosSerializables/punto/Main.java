package ficherosSerializables.punto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Freitas
 */
public class Main {
    public static void main(String[] args) {
        File f1 =  new File("files/puntos.bin");
        File f2 = new File("files/puntos.obj");
        ArrayList<Punto> puntos = new ArrayList<>();
        try {
            Punto.almacenarPuntosEnArchivo(f1, f2);
            puntos = Punto.obtenerArrayListDeArchivo(f2);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Punto punto : puntos) {
            System.out.println(punto.toString());
        }

    }
}
