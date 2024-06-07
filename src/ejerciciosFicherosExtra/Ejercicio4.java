package ejerciciosFicherosExtra;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio4 {

    private static Set<Character> vowels = new HashSet<>();
    private static int numLines = 0;

    public static void main(String[] args) {
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');

        Scanner sc = new Scanner(System.in);
        File input = new File("files/texto.txt");
        File output = new File("files/texto_modificado.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            String line;
            while((line = br.readLine())!=null){
                String modifiedLine = insertAsterisks(line);
                bw.write(modifiedLine);
                bw.newLine();
            }
            br.close();
            bw.close();

            br = new BufferedReader(new FileReader(output));
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        } catch (IOException ex) {
            System.err.println("Ta mal");
        }catch (IndexOutOfBoundsException e){
            System.err.println("Ta fuera de rango");
        }
    }
    public static String insertAsterisks(String line) {
        StringBuilder modifiedLine = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (vowels.contains(Character.toLowerCase(c))) {
                modifiedLine.append('*');
            }
            modifiedLine.append(c);
        }
        return modifiedLine.toString();
    }
}
