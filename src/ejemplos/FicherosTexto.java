package ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Thomas Freitas
 */
public class FicherosTexto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            File f = new File("files/ficherotexto.txt");
            
//Escrinimos en el archivo con un bufferedwriter
            BufferedWriter  bw = new BufferedWriter(new FileWriter(f));
            String cadena;
            System.out.println("Introducir cadena (* para finalizar)");
            cadena = teclado.nextLine();
            bw.write(cadena);
            while(!cadena.equals("*")){
                cadena = teclado.nextLine();
                bw.write(cadena);
                bw.write("\n");
            }
            bw.close();

//Leemos el contenido del archivo con Buffered Reader.
            BufferedReader br = new BufferedReader(new FileReader(f));
            cadena = br.readLine();
            while (cadena !=null) {                
                System.out.println(cadena);
                cadena=br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
