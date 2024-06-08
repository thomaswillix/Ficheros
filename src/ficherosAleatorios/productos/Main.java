package ficherosAleatorios.productos;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;

/**
 *
 * @author Thomas Freitas
 */
public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("files/productos.dat");
        System.out.println("LECTURA DEL ARCHIVO");
        int id;
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        try {
            while (true) {
                System.out.println("PUNTERO: " + raf.getFilePointer());
                System.out.println(raf.readInt() + " " + raf.readInt() + " " + raf.readDouble());
            }
        } catch (EOFException e) {
            id = (int) (raf.length() / 16) + 1;
            System.err.println("End of file");
        }

        File f = new File("files/datos");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        Manejador m = new Manejador();
        sp.parse(f, m);
        ArrayList<Operacion> lista = m.getLista();
        for (Operacion operacion : lista) {
            int busqueda = 0;
            if (operacion.getCodigo() == 1) {
                busqueda = 1;
            } else busqueda = (operacion.getCodigo()-1)*16;
            switch (operacion.getOperacion()) {
                case "Modificacion":
                    if (operacion.getCampo().equals("cantidad")) {
                        raf.seek(busqueda);
                        raf.readInt();
                        raf.writeInt(operacion.getCantidad());
                        raf.seek(busqueda);
                    } else if (operacion.getCampo().equals("precio")){
                        raf.seek(busqueda);
                        raf.readInt();
                        raf.readInt();
                        raf.writeDouble(operacion.getPrecio());
                    }
                    break;
                case "Baja":
                    raf.seek(busqueda);
                    raf.readInt();
                    raf.writeInt(-1);
                    break;
                case "Alta":
                    raf.seek((id-1)*16);
                    raf.writeInt(id);
                    raf.writeInt(operacion.getCantidad());
                    raf.writeDouble(operacion.getPrecio());
                    id++;
                    break;
            }
        }
        System.out.println("FICHERO ACTUALIZADO");
        try {
            raf.seek(0);
            while (true) {
                System.out.println("PUNTERO: " + raf.getFilePointer());
                System.out.println(raf.readInt() + " " + raf.readInt() + " " + raf.readDouble());
            }
        } catch (EOFException e) {
            id = (int) (raf.length() / 16) + 1;
            System.err.println("End of file");
        }
    }

}
