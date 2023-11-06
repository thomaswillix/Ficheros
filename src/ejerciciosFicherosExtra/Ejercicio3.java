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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lineas = new ArrayList<String>();
        int cont = 0, numMax, numMin;
        try {
            BufferedReader br = new BufferedReader(new FileReader("parrafo.txt"));
            String frase = br.readLine();
            while (frase!= null) {
                lineas.add(frase);
                frase = br.readLine();
                cont++;
            }
            System.out.println("El texto tiene " + cont + " líneas\nDime un rango de números "
                    + "(Menor, Mayor)y te diré el contenido de las líneas que ocupa");
            numMin = sc.nextInt();
            numMax = sc.nextInt();
            br.close();
            for (int i = numMin; i <= numMax; i++) {
                System.out.println(lineas.get(i-1));
            }

        } catch (IOException ex) {
            System.err.println("Ta mal");
        }catch (IndexOutOfBoundsException e){
            System.err.println("Ta fuera de rango");
        }
    }
}
