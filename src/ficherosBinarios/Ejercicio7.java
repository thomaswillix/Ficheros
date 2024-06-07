package ficherosBinarios;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio7 {
    public static void main(String[] args) {
        File input = new File("files/temperaturas.txt");
        File output = new File("files/Septemp.dat");
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            DataOutputStream dos  = new DataOutputStream(new FileOutputStream(output));
            String line ;
            while ((line = br.readLine()) != null){
               separarDatos(line, dos);
            }
            br.close();
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void separarDatos(String line, DataOutputStream dos) throws IOException {
        String[] datos = line.split(" ");
        int dia = Integer.parseInt(datos[0]);
        int temperatura = Integer.parseInt(datos[1]);
        dos.writeInt(dia);
        dos.writeInt(temperatura);
        dos.writeUTF("\n");

    }
}
