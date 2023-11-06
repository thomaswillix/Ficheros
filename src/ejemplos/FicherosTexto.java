package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class FicherosTexto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            File f = new File("ficherotexto.txt");
            
//Escribimos en el archivo con FileReader

            /*FileWriter fw = new FileWriter(f);
            char caracter;
            System.out.println("Introducir caracter (* para finalizar)");
            caracter = teclado.next().charAt(0);
            while (caracter!='*') {                
                fw.write(caracter);
                fw.write("\n\r");
                System.out.println("Introducir caracter (* para finalizar)");
                caracter = teclado.next().charAt(0);
            }
            fw.close();
            FileReader fr = new FileReader(f);
            int c =fr.read();
            while (c != -1) {
                System.out.println(c+" " +(char)c);
            }
            fr.close();*/
            
// -------------------------------------------------------------
//Escribimos en el archivo con BufferedReader
            
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            System.out.println("Introducir nombre (FIN PARA ACABAR)");
            String cadena=teclado.nextLine();
            while (!cadena.equalsIgnoreCase("fin")) {
                bw.write(cadena);
                bw.newLine();
                System.out.println("Introducir nombre (FIN PARA ACABAR)");
                cadena=teclado.nextLine();
            }
            bw.close();
            fw.close();
//--------------------------------------------------------------
            
//Leemos el contenido del archivo con Buffered Reader.
            /*FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while (cadena !=null) {                
                System.out.println(cadena);
                cadena=br.readLine();
            }
            br.close();
            fr.close();*/
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
