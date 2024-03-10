package ficherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio4 {
    private  static List<Beca> becas = new ArrayList<>();

    public static void main(String[] args) {
        File input = new File("datosbeca.bin");
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(input));

            while(true){
                String nom = dis.readUTF();
                char s = dis.readChar();
                int edad = dis.readInt();
                int asig = dis.readInt();
                boolean resi = dis.readBoolean();
                double rent = dis.readDouble();
                Beca b = new Beca(nom,s,edad,asig,resi,rent);
                becas.add(b);
            }
        }  catch (EOFException e) {
            System.err.println("End of file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Beca b: becas) {
            b.setCuantiaBeca();
            System.out.println("DATOS DE LA BECA: " + b);
        }
    }
}
