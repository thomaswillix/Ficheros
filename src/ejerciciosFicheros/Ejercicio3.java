package ejerciciosFicheros;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        File input = new File("files/parrafo.txt");
        File output = new File("files/parrafoSinVocales.txt");

        Set<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        try {
            BufferedReader br =new BufferedReader(new FileReader(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));

            String line;
            while((line = br.readLine())!=null){
                String lineWithoutVowels = eliminateVowels(line,vowels);
                bw.write(lineWithoutVowels);
                bw.newLine();
            }
            br.close();
            bw.close();

            br = new BufferedReader(new FileReader(output));
            while ((line = br.readLine())!= null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String eliminateVowels(String line, Set<Character> vowels){
        StringBuilder sb = new StringBuilder();
        for (char c : line.toCharArray()){
            if(!vowels.contains(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
