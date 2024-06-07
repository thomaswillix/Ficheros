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

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime la cantidad de números enteros positivos que quieres"
                + " guardar en un fichero .bin");
        int num = sc.nextInt();
        try {
            numNumeros(num);
            leerNumeros();
        }  catch (IOException ex) {
            System.err.println("Error de Lectura/Escritura");
        }
    }
    public static void numNumeros(int cant) throws IOException{
        File f = new File("files/prueba.bin");
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f, true));
        for (int i = 1; i <= cant; i++) {
            dos.writeInt((char)(Math.random()* 100));
        }
    } 
    public static void leerNumeros() throws IOException{
        File f = new File("files/prueba.bin");
        DataInputStream dis = new DataInputStream(new FileInputStream(f));
        try {
            while (true) {
            System.out.println(dis.readInt()+ "\n");
        }
        } catch (EOFException e) {
            System.err.println("Sacabao");
        }
        dis.close();
    } 
}
