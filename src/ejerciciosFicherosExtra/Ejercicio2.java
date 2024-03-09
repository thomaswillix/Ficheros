package ejerciciosFicherosExtra;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        File input = new File("texto.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null){
                counter++;
            }
            br.close();

            Scanner sc = new Scanner(System.in);
            System.out.println("Dime cuántas líneas del texto quieres ver\n" +
                "Ten en cuenta que el texto tiene " + counter + " líneas.");
            int lines;
            do{
                lines  = sc.nextInt();
            }while (!validateLines(lines, counter));

            br = new BufferedReader(new FileReader(input));
            int printedLines = 0;
            while ((line = br.readLine()) != null && printedLines < lines) {
                System.out.println(line);
                printedLines++;
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean validateLines(int lines, int maxLines){
        if (lines > maxLines || lines < 0) {
            System.out.println("Valor fuera del rango (1, " + maxLines + "), por favor introduzca otro.");
            return false;
        }
        return true;
    }
}
