package ejerciciosFicherosExtra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("parrafo.txt");
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Ve introduciendo frases en el doc, (para finalizar pulsa un *)");
            String cadena =sc.nextLine();
            while (!(cadena.charAt(0)=='*')) {                
                bw.write(cadena);
                bw.newLine();
                System.out.println("Ve introduciendo frases en el doc, (para finalizar pulsa un *)");
                cadena = sc.nextLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Ha petao");
        }
    }
}
