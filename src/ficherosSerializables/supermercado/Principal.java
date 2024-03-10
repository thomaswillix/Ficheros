package ficherosSerializables.supermercado;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Freitas
 */
public class Principal {

    private static ArrayList<Cliente> clis = new ArrayList<Cliente>();
    private static Cliente c;
    public static void main(String[] args) {
        //DECLARTACIÓN DEL ARCHIVO
        File f = new File("clientes.dat");
        //TRY-CATCH DE LECTURA/ESCRITURA
        try {
            //COMPROBACIÓN DE QUE EXISTA O NO EL ARCHIVO
            if (!f.exists()) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.close();
            }
            //DECLARACIÓN DEL CLASEOUTPUT (ESCRITURA)
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            //DECLARACIÓN DE LA LISTA DE CLIENTES (LO SOBREESCRIBIREMOS) Y ESCRITURA DE LOS OBJETOS
            cargarClientes();
            for (Cliente c: clis) {
                oos.writeObject(c);
            }
            oos.close();
            //DECLARACIÓN DEL OIS Y LECTURA DE LOS OBJETOS
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            try {
                while (true) {
                    c = (Cliente) ois.readObject();
                    System.out.println(c.toString());
                }
            } catch (EOFException e) {
            }
            ois.close();

        } catch (EOFException e) {
            System.err.println("sacabao");
        } catch (ClassNotFoundException ex) {
            System.err.println("Clase no encontrada");
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cargarClientes() {
        LocalDate d = LocalDate.of(2022, 12, 31);
        c = new Cliente("18754257G", "Juan", "Calle Andromeda 23 5ºC", d);
        clis.add(c);
        d = LocalDate.of(2022, 01, 05);
        c = new Cliente("54682465F", "Pepe", "Calle Barcelona 23 4ºD", d);
        clis.add(c);
        c = new Cliente("98765214B", "Maria", "Calle Canarias 3 9ºF");
        clis.add(c);
        d = LocalDate.of(2022, 06, 24);
        c = new Cliente("84512741C", "Roberto", "Calle Canarias 3 9ºA", d);
        clis.add(c);
        c = new Cliente("62145184R", "Juana", "Avenida de la Onu 8 4ºA");
        clis.add(c);
    }
}
