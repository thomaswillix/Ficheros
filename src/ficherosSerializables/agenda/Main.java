package ficherosSerializables.agenda;

import java.io.*;
import java.rmi.ServerError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Contacto> contactos = new ArrayList<>();
    private static File output = new File("agenda.bin");
    private static File deleted = new File("Eliminados.txt");

    public static void main(String[] args) {
        cargarContactos();
        menu();
    }

    private static void cargarContactos() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output));
            Contacto c = new Contacto("Felipe", "Huayanai",654987254, "felipe@gmail.com");
            oos.writeObject(c);
            c = new Contacto("Pepa", "Pera", 654878525, "apepa@ñ.com");
            oos.writeObject(c);
            c = new Contacto("Marga", "Rina", 654758123, "margarina@butter.com");
            oos.writeObject(c);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        do{
            System.out.println("1- Alta de un nuevo contacto\n2- Buscar contacto (Nombre y Apellidos):" +
                    "\n3- Modificar (número o email)\n4- Eliminar contacto (Nombre y Apellidos) " +
                    "-->(Eliminados.txt)\n5- Exit");
            num = sc.nextInt();
            sc.nextLine();
            chooseOperation(sc, num);
        }while (num!=5);
    }

    private static void chooseOperation(Scanner sc, int num) {
        if(num==1){
            newContact(sc);
        } else if (num<5 && num>1){
            System.out.println("Nombre: ");
            String name = sc.nextLine();
            System.out.println("Apellidos: ");
            String surname = sc.nextLine();
            switch (num){
                case 2:
                    System.out.println(searchContact(name, surname)+ "\n");
                    break;
                case 3:
                    modifyContact(name, surname, sc);
                    break;
                case 4:
                    deleteContact(name, surname);
                    break;
            }
        } else if (num==5){
        }else{
            System.out.println("Número mal introducido, por favor introduzcalo de nuevo");
        }
    }

    private static void deleteContact(String name, String surname) {
        // Buscar la persona en la agenda telefónica
        boolean encontrado = false;
        Contacto personaEliminada = null;
        Iterator<Contacto> iter = contactos.iterator();
            while (iter.hasNext()) {
                Contacto persona = iter.next();
                if (persona.getNombre().equals(name) && persona.getApellidos().equals(surname)) {
                    encontrado = true;
                    personaEliminada = persona;

                    iter.remove(); // Eliminar la persona de la agenda
                    break;
                }
            }

        // Guardar la persona eliminada en el archivo "Eliminados.txt"
        if (encontrado) {
            try (FileWriter fw = new FileWriter(deleted, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(personaEliminada.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La persona no se encontró en la agenda.");
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(output));
            output.delete();
            output = new File("agenda.bin");
            for (Contacto c : contactos) {
                oos.writeObject(c);
            }
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void modifyContact(String name, String surname, Scanner sc) {
        String search = name + " " + surname;
        for (Contacto c  : contactos) {
            String con = c.getNombre() + " " + c.getApellidos();
            if (search.equals(con)){
                modify(c, sc);
            }
        }
    }

    private static void modify(Contacto c, Scanner sc) {
        int op;
        do {
            System.out.println("¿Qué quieres modificar?\n1- telefono\n2- email");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    c.setTelefono(sc.nextInt());
                    break;
                case 2:
                    c.setEmail(sc.nextLine());
                    break;
                default:
                    System.out.println("Operación no válida");
            }
        } while (!(op == 1 || op == 2));
    }

    private static void newContact(Scanner sc) {
        System.out.println("--------------------CREACIÓN DE UN NUEVO CONTACTO--------------------\n\n" +
                "Nombre: ");
        String name = sc.nextLine();
        System.out.println("Apellidos: ");
        String surname = sc.nextLine();
        System.out.println("Teléfono: ");
        int phone = sc.nextInt();
        sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        Contacto c = new Contacto(name, surname, phone, email);
        writeContact(c);
    }

    private static void writeContact(Contacto c) {
        try {
            ClaseOutput co = new ClaseOutput(new FileOutputStream(output, true));
            co.writeObject(c);
            co.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String searchContact(String name, String surname) {
        String search = name + " " + surname;
        readContacts();
        for (Contacto c: contactos) {
            String copm = c.getNombre() + " " +c.getApellidos();
            if (copm.equals(search)){
                return "CONTACTO ENCONTRADO: Teléfono: " + c.getTelefono() + ", Email: " + c.getEmail();
            }
        }
        return "CONTACTO NO ENCONTRADO";
    }

    private static void readContacts() {
        contactos.clear();
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(output));
            try {
                while (true) {
                    Contacto c = (Contacto) ois.readObject();
                    contactos.add(c);
                }
            } catch (EOFException e) {
                System.err.println("Final de lectura.");
            }
            ois.close();
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

}
