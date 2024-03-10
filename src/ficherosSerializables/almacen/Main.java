package ficherosSerializables.almacen;

import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Integer, Integer> inventory = new HashMap<>();
    private static List<Producto> prods= new ArrayList<>();

    public static void main(String[] args) {
        File input1 = new File("almacen.dat");
        File input2 = new File("articulos.dat");
        // Paso 1: Leer el archivo almacén.dat y almacenar su contenido en un HashMap
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(input1));
            while(true){
                int id = dis.readInt();
                int stock = dis.readInt();
                inventory.put(id, stock);
            }
        } catch (EOFException e) {
            System.err.println("End of file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(inventory.toString());
        // Paso 2: Leer el archivo articulos.dat y almacenar sus datos en una lista de objetos Producto
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(input2));
            while (true){
                int cod = dis.readInt();
                String nom = dis.readUTF();
                int exist = dis.readInt();
                double price = dis.readDouble();
                Producto p  = new Producto(cod,nom,exist,price);
                prods.add(p);
            }
        } catch (EOFException e) {
            System.err.println("End of file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Paso 3: Actualizar las existencias de los productos en la lista de productos
        Iterator<Producto> iterator = prods.iterator();
        List<Producto> nuevosProductos = new ArrayList<>(); // Lista para almacenar nuevos productos
        while (iterator.hasNext()) {
            Producto p = iterator.next();
            if (inventory.containsKey(p.getCodigo())) {
                int unidades = inventory.get(p.getCodigo());
                // Sumar o restar las unidades del almacén a las existencias del producto
                p.setExistencias(p.getExistencias() + unidades);
                // Controlar las existencias del producto
                if (p.getExistencias() < 0) {
                    // Si las existencias son negativas, eliminar el producto de la lista
                    iterator.remove();
                }
            } else {
                // Si el producto no está en el almacén, pedir al usuario que lo dé de alta
                Scanner scanner = new Scanner(System.in);
                System.out.println("El producto con código " + p.getCodigo() + " no se encuentra en el archivo de artículos.");
                System.out.println("Introduce el nombre del producto:");
                String nombre = scanner.nextLine();
                System.out.println("Introduce el precio del producto:");
                double precio = scanner.nextDouble();
                // Agregar el nuevo producto a la lista de nuevos productos
                nuevosProductos.add(new Producto(p.getCodigo(), nombre, 0, precio)); // Inicializamos las existencias a 0
            }
        }

        // Agregar los nuevos productos a la lista de productos después de terminar la iteración
        prods.addAll(nuevosProductos);

        // Paso 4: Escribir los datos actualizados de la lista de productos en el archivo articulos.dat
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(input2))) {
            for (Producto p : prods) {
                dos.writeInt(p.getCodigo());
                dos.writeUTF(p.getNombre());
                dos.writeInt(p.getExistencias());
                dos.writeDouble(p.getPrecio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Paso 5: Generar un informe con la información solicitada
        for (Producto p : prods) {
            System.out.println("Hay " + p.getExistencias() + " unidades del producto " + p.getNombre() +
                    " lo que equivale a " + (p.getExistencias() * p.getPrecio()) + " euros.");
        }
    }
}
