package ejerciciosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        File f = new  File("texto.txt");
        File f1 = new File("invertido.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s = br.readLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
            while(br.readLine()!= null){
                bw.write(s);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.err.println("Error de Lectura/Escritura");
        }
        
    }
}
