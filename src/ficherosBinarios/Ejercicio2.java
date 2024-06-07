package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio2 {
    private static final String PATRON_MATRICULA = "[0-9]{4}[A-Z]{3}";
    private static String marc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a hacer un coche, para ello dime los datos por separado\n"
                + "Comencemos por la matrícula: ");
        String mat = sc.nextLine().trim().toUpperCase();

        while (!validarMatricula(mat)) {
            System.out.println("Introduzca de nuevo su matrícula");
            mat = sc.nextLine();
        }

        int n =0;
        System.out.println("Definamos la marca de tu vehículo: \n"
                + "1 BMW\n2 Toyota\n3 Seat\n4 Mercedes-Benz\n5 Subaru");
        do{
            n = sc.nextInt();
        }while(!comprMarca(n));

        sc.nextLine();
        System.out.println("Definamos el modelo de tu vehículo: ");
        String modelo = sc.nextLine();

        System.out.println("Definamos el cupo de tu depósito: ");
        double depos= sc.nextDouble();

        try {
            escribirCoche(mat, marc, modelo, depos);
            leerCoche();
        } catch (IOException ex) {
            System.err.println("Error de Lectura/Escritura");
        }
        
    }
    public static void escribirCoche(String matricula, String marca, String modelo, double deposito) throws FileNotFoundException, IOException{
        File f = new File("files/coche.bin");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f, true));
        dos.writeUTF(matricula);
        dos.writeUTF(marca);
        dos.writeUTF(modelo);
        dos.writeDouble(deposito);
    }
    public static void leerCoche() throws IOException{
        File f = new File("files/coche.bin");
        System.out.println("----------------LISTA DE COCHES EN EL FICHERO --------------------");
        DataInputStream dis = new DataInputStream(new FileInputStream(f));
        try {
            while (true) {
            System.out.println("Coche: " + dis.readUTF()+ " " + dis.readUTF()+
                    " " + dis.readUTF()+ " " + dis.readDouble());
        }
        } catch (EOFException e) {
            System.err.println("Sacabao");
        }
        dis.close();
    }

    public static boolean validarMatricula(String matricula) {
        Pattern pattern = Pattern.compile(PATRON_MATRICULA);
        Matcher matcher = pattern.matcher(matricula);
        return matcher.matches();
    }
    public static boolean comprMarca(int n) {
        if (n < 1 || n > 5) {
            System.out.println("Por favor, introduce un número del 1 - 5");
            return false;
        }
        switch (n){
            case 1:
                marc = "BMW";
                break;
            case 2:
                marc = "Toyota";
                break;
            case 3:
                marc = "Seat";
                break;
            case 4:
                marc = "Mercedes-Benz";
                break;
            case 5:
                marc = "Subaru";
        }
        return true;
    }
}
