package ejerciciosFicherosExtra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/**
 *
 * @author alumno
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        File f = new File("parrafo.txt");
        File f1 = new File("letras.txt");
        HashMap<Character, Integer> veces = new HashMap<Character, Integer>();
        String frase;

        veces.put('a', 0);
        veces.put('b', 0);
        veces.put('c', 0);
        veces.put('d', 0);
        veces.put('e', 0);
        veces.put('f', 0);
        veces.put('g', 0);
        veces.put('h', 0);
        veces.put('i', 0);
        veces.put('j', 0);
        veces.put('k', 0);
        veces.put('l', 0);
        veces.put('m', 0);
        veces.put('n', 0);
        veces.put('ñ', 0);
        veces.put('o', 0);
        veces.put('p', 0);
        veces.put('q', 0);
        veces.put('r', 0);
        veces.put('s', 0);
        veces.put('t', 0);
        veces.put('u', 0);
        veces.put('v', 0);
        veces.put('w', 0);
        veces.put('x', 0);
        veces.put('y', 0);
        veces.put('z', 0);

        int letra;
        try {
            FileReader fr = new FileReader(f);
            letra = fr.read();
            while (letra != -1) {
                if (veces.containsKey((char) letra)) {
                    veces.put((char) letra, veces.get((char)letra) + 1);
                    letra = fr.read();
                } else {
                    letra = fr.read();
                }
                letra = fr.read();
            }
            fr.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
            for (char clave : veces.keySet()) {
                int valor = veces.get(clave);
                frase = "La letra: " + clave + ", sale " + valor + "\n";
                bw.write(frase);
            }
            bw.close();
        } catch (Exception e) {
        }
    }
}
