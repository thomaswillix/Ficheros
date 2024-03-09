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
        File input = new File("texto.txt");
        File output = new File("invertido.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));

            String line;
            while ((line = br.readLine())!= null) {
                String invertedLine = invertLine(line);
                bw.write(invertedLine);
                bw.newLine();
            }
            br.close();
            bw.close();

            br = new BufferedReader(new FileReader(output));
            while ((line = br.readLine())!= null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Ha petao");
        }
    }

    public static String invertLine(String line){
        char[] chars = line.toCharArray();
        String newString = "";
        for(int i = chars.length -1; i >= 0; i--){
            newString += chars[i];
        }
        return newString;
    }
}
