package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binarios {
    public static void main(String[] args) {
        try {
            File f = new File("files/prueba.bin");
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.close();
            fos.close();
            System.out.println("LOS DATOS DEL FICHERO SON ");
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            try {
                while (true) {
                    System.out.println(dis.readInt() + " " + dis.readDouble());
                }
            } catch (EOFException e) {
                System.out.println("NO HAY MAS DATOS EN EL FICHERO");
            }

            dis.close();
            fis.close();

            fos = new FileOutputStream(f, true);
            dos = new DataOutputStream(fos);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.writeInt((int) (Math.random() * 10 + 1));
            dos.writeDouble(Math.random() * 10);
            dos.close();
            fos.close();

            System.out.println("LOS DATOS DEL FICHERO SON ");
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
            try {
                while (true) {
                    System.out.println(dis.readInt() + " " + dis.readDouble());
                }
            } catch (EOFException e) {
                System.out.println("NO HAY MAS DATOS EN EL FICHERO");
            }

            dis.close();
            fis.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
