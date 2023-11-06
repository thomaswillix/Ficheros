package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a hacer un coche, para ello dime los datos por separado\n"
                + "Comencemos por la matrícula: ");
        String mat = sc.nextLine().trim().toUpperCase();
        System.out.println("Definamos la marca de tu vehículo: ");
        String marc = sc.nextLine();
        /*while (!comprMatricula(mat)) {
            System.out.println("Que no coñooo, que la introduzcas bien");
            mat = sc.nextLine();
            comprMatricula(mat);
        }
        while(!comprMarca(sc)){
            System.out.println("Por favor, introduce un número del 1 - 5");
            comprMarca(sc);
        }*/
                System.out.println("Definamos el modelo de tu vehículo: ");
        String modelo = sc.nextLine();
        System.out.println("Definamos el cupo de tu depósito: ");
        double depos= sc.nextDouble();
        try {
            escribirCoche(mat, marc, modelo, depos);
            leerCoche(mat, marc, modelo, depos);
        } catch (IOException ex) {
            System.err.println("Error de Lectura/Escritura");
        }
        
    }
    public static void escribirCoche(String matricula, String marca, String modelo, double deposito) throws FileNotFoundException, IOException{
        File f = new File("coche.bin");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f, true));
        dos.writeUTF(matricula);
        dos.writeUTF(marca);
        dos.writeUTF(modelo);
        dos.writeDouble(deposito);
    }
    public static void leerCoche(String matricula, String marca, String modelo, double deposito) throws FileNotFoundException, IOException{
        File f = new File("coche.bin");
        DataInputStream dis = new DataInputStream(new FileInputStream(f));
        try {
            while (true) {
            System.out.println(dis.readUTF()+ " " + dis.readUTF()+ 
                    " " + dis.readUTF()+ " " + dis.readDouble());
        }
        } catch (EOFException e) {
            System.err.println("Sacabao");
        }
        dis.close();
    }

    /*public static boolean comprMatricula(String matricula) {
        String nums = "123456789";
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (matricula.length() != 7) {
            return false;
        }
        if (matricula.substring(0, 3).contains(nums) && matricula.substring(4, 6).contains(letras)) {
            return true;
        }
        return false;
    }

    public static boolean comprMarca(Scanner sc) {
        System.out.println("Definamos la marca de tu vehículo: \n"
                + "1 BMW\n 2 Toyota\n 3 Seat\n4 Mercedes-Benz\n5 Subaru");
        int n;
        try {
            n = sc.nextInt();
        } catch (Exception e) {
            System.out.println("El número  no se intrudujo bien");
            return false;
        }
        if (n < 1 || n > 5) {
            return false;
        }
        return true;
    }*/
}
