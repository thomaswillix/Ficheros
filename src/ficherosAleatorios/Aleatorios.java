package ficherosAleatorios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Thomas Freitas
 */
public class Aleatorios {
    public static void main(String[] args) {
        try {
            File f = new File("prueba.bin");
            RandomAccessFile raf =  new RandomAccessFile(f, "rw"); //"r"
            System.out.println("Tamaño del fichero " + raf.length());
            raf.seek(raf.length());
            System.out.println("Puntero desde donde voy a escribir " + raf.getFilePointer());
            raf.writeInt(6);
            System.out.println("Puntero después del primer número entero " + raf.getFilePointer());
            raf.writeDouble(5.2);
            System.out.println("Puntero después del segundo número (double) " + raf.getFilePointer());
            raf.writeChar('F');
            System.out.println("Puntero después del tercer valor char " + raf.getFilePointer());
            raf.writeUTF("Directo");
            System.out.println("Puntero después del último valor (String) " + raf.getFilePointer());
            System.out.println("Tamaño del fichero " + raf.length());
            
            raf.seek(0);
            try {
                while (true) {                    
                    System.out.println("Puntero " + raf.getFilePointer());
                    System.out.println("Puntero " + raf.getFilePointer() + "->VALOR 1 " + raf.readInt());
                    System.out.println("Puntero " + raf.getFilePointer() + "->VALOR 2 " + raf.readDouble());
                    System.out.println("Puntero " + raf.getFilePointer() + "->VALOR 3 " + raf.readChar());
                    System.out.println("Puntero " + raf.getFilePointer() + "->VALOR 4 " + raf.readUTF());
                }    
            } catch (Exception e) {
            }
            raf.getFilePointer();
        } catch (IOException e) {
        }
    }
}
