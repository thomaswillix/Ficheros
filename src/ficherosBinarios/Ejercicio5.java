package ficherosBinarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {
    public static void main(String[] args) {
        File output = new File("personas.bin");
        List<Persona> personas = getPersonas();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output));
            for (Persona p2 : personas) {
                oos.writeObject(p2);
            }
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(output));
            while (true) {
                Persona p = (Persona) ois.readObject();
                System.out.println(p.toString());
            }
        }catch (IOException e) {
            System.err.println("Final del fichero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona p = new Persona("Juan", "Pérez", 23, 654534332, "juan.perez@gmail.com",
                "Madrid","Española","Desarrollador de Software");
        personas.add(p);
        p = new Persona("Felipe", "Salas", 54, 695458212, "felipe.salas@gmail.com",
                "Alcorcón","Argentina","Software Engineer");
        personas.add(p);

        p = new Persona("Maria", "Marquez", 12, 654712451, "maria.marquez@gmail.com",
                "Fuenlabrada","Italiana","Designer");
        personas.add(p);
        return personas;
    }
}
