package ejerciciosFicheros;

import java.io.*;
/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        File input = new File("files/empleados.txt");
        File output = new File("files/pruebesitas.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            FileWriter fw = new FileWriter(output);
            String line;
            int numEmpleados = 0;
            int sumatorioEdades = 0;
            while ((line = br.readLine())!= null){
                numEmpleados++;
                Employee e = separateData(line);
                sumatorioEdades += e.age;
                fw.write(String.valueOf(e.age));
                fw.write("\n");
            }
            br.close();
            fw.close();
            System.out.println("EDADES DE TODOS LOS EMPLEADOS");
            br = new BufferedReader(new FileReader(output));
            while((line = br.readLine())!= null){
                System.out.println(line);
            }
            System.out.println("EDAD MEDIA: \n" + sumatorioEdades/numEmpleados);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Employee separateData(String line){
        StringBuilder sb = new StringBuilder();
        String[] elements = line.split(" ");
        String name = elements[0];
        int age = Integer.parseInt(elements[1]);
        int children = Integer.parseInt(elements[2]);
        String maritalStatus = elements[3];
        return new Employee(name, age, children, maritalStatus);
    }
}
