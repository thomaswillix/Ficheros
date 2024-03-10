package ficherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {
    private  static List<Persona> personas = new ArrayList<>();
    public static void main(String[] args) {
        File input = new File("personas.bin");
        File output1 = new File("menores.bin");
        File output2 = new File("adultos.bin");
        File output3 = new File("mayores.bin");
        System.out.println("------------------------INPUT------------------------");
        leer(input);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output1));
            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(output2));
            ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(output3));

            for (Persona p1 : personas) {
                if (p1.edad < 18){
                    oos.writeObject(p1);
                } else if (p1.edad<65) {
                    oos2.writeObject(p1);
                } else {
                    oos3.writeObject(p1);
                }
            }
            oos.close();
            oos2.close();
            oos3.close();

            System.out.println("------------------------PRIMER OUTPUT------------------------");
            leer(output1);
            System.out.println("------------------------SEGUNDO OUTPUT------------------------");
            leer(output2);
            System.out.println("------------------------TERCER OUTPUT------------------------");
            leer(output3);

        } catch (IOException e) {
            System.err.println("Final del fichero");
        }
    }

    private static void leer(File input) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(input));
            try {
                while (true) {
                    Persona p = (Persona) ois.readObject();
                    System.out.println(p.toString());
                    personas.add(p);
                }
            } catch (EOFException e) {
                System.err.println("Final del fichero");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ois.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}