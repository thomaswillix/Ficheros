package ficherosSerializables.punto;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Thomas Freitas
 */
public class Main {
    public static void main(String[] args) {
        File f1 =  new File("files/puntos.bin");
        File f2 = new File("files/puntos.obj");
        ArrayList<Punto> puntos = new ArrayList<>();
        Punto.almacenarPuntosEnArchivo(f1, f2);
        puntos = Punto.obtenerArrayListDeArchivo(f2);

        for (Punto punto : puntos) {
            System.out.println(punto.toString());
        }

    }
}
