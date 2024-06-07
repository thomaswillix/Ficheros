package ejerciciosFicherosExtra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio3 {

    private static int numWords;
    private static int numChars;
    private static int numLines = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            BufferedReader br = new BufferedReader(new FileReader("files/parrafo.txt"));
            String linea;

            while ((linea=br.readLine())!= null) {
                numLines++;
                countWords(linea);
            }
            System.out.println("Líneas: " + numLines + "\nPalabras: " + numWords + "\nLetras: " + numChars);
        } catch (IOException ex) {
            System.err.println("Ta mal");
        }catch (IndexOutOfBoundsException e){
            System.err.println("Ta fuera de rango");
        }
    }

    public static void countWords(String str){
        String[] words = str.split(" ");
        for (String s: words) {
            countChars(s);
            numWords++;
        }
    }

    public static void countChars(String str){
        char[] chars = str.toCharArray();
        numChars+= chars.length;
    }
}
