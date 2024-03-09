package ejerciciosFicheros;

import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        File f = new File("parrafo.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            int cont = 0;
            String linea;
            while ((linea = br.readLine()) != null){
                cont ++;
            }
            System.out.println(cont);

            System.out.println("El archivo parrafo.txt tiene " +  cont + " líneas" +
                    "\nDime qué línea quieres que se vea impresa por pantalla.");

            Scanner sc = new Scanner(System.in);
            int num;

            do {
                System.out.println("Número de línea: ");
                num = sc.nextInt();
            } while (!validarRespuesta(num, cont));

            br = new BufferedReader(new FileReader(f));
            int cont2 = 0;
            while((linea = br.readLine()) != null){
                cont2++;
                if (cont2 == num) {
                    System.out.println(linea);
                    break; // Salir del bucle después de encontrar la línea deseada
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validarRespuesta(int num, int valorMax) {
        if (num > valorMax || num < 0) {
            System.out.println("Valor fuera del rango (1, " + valorMax + "), por favor introduzca otro.");
            return false;
        }
        return true;
    }
}
