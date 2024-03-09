package ejerciciosFicheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio1 {
      public static void main(String[] args) {
            File f = new File("parrafo.txt"); // Nombre del archivo de entrada corregido
            File f1 = new File("letras.txt");

            try {
                HashMap<Character, Integer> letras = new HashMap<>();
                FileReader fr = new FileReader(f);
                int character = fr.read();
                while (character != -1) {
                    char letra = (char) character;
                    if (Character.isLetter(letra)) { // Asegurarse de contar solo letras
                        if (letras.containsKey(letra)) {
                            int valor = letras.get(letra);
                            valor++;
                            letras.put(letra, valor);
                        } else {
                            letras.put(letra, 1);
                        }
                    }
                    character = fr.read();
                }
                fr.close();

                BufferedWriter bw = new BufferedWriter(new FileWriter(f1));
                for (char letra : letras.keySet()) {
                    bw.write(letra + " " + letras.get(letra) + "\n"); // Separar letra y conteo con un espacio
                }
                bw.close();

                // Mostrar el archivo resultante
                BufferedReader br = new BufferedReader(new FileReader(f1));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.err.println("Archivo no encontrado");
            } catch (IOException ex) {
                System.err.println("Error de Lectura/Escritura");
            }
      }
}
