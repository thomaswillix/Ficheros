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
            try {
                while (true) {
                    Persona p = (Persona) ois.readObject();
                    System.out.println(p.toString());
                }
            } catch (EOFException e) {
                System.err.println("Final del fichero");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();
        Persona p = new Persona("Juana", "De Arco", 21, 654882111, "juana.sasss@gmail.com",
                "Burgos","Francesa","Database Administrator");
        personas.add(p);
        p = new Persona("Gregorio", "Gómez", 19, 658457854, "gg.dd@gmail.com",
                "Madrid","Venezolano","Líder de proyectos");
        personas.add(p);

        p = new Persona("Manuela", "López", 45, 698548521, "manu.lopez@gmail.com",
                "Madrid","Portuguesa","Software Engineer");
        personas.add(p);
        p = new Persona("Juan", "José", 16, 658457854, "jj.jj@gmail.com",
                "Madrid","Colombiano","Líder de proyectos");
        personas.add(p);

        p = new Persona("Justo", "López", 65, 698548521, "justo.lopez@gmail.com",
                "Madrid","Alemana","Contable");
        personas.add(p);
        return personas;
    }
}
