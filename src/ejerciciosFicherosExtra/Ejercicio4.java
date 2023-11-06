package ejerciciosFicherosExtra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("Buscando archivo...");
        File f = new File("empleados.txt");
        String[] spl;
        int num;
        ArrayList<Integer> nums = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                spl = linea.split(" ", 4);
                num = Integer.parseInt(spl[1]);
                nums.add(num);
                linea = br.readLine();
            }
            br.close();
            System.out.println("\nLa media de edad de los empleados es: " + edadMediaEmpleados(nums));
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado mi rey");
        } catch (IOException ex) {
            System.err.println("Error en la lectura y/o escritura");
        }
    }
    public static int edadMediaEmpleados(ArrayList<Integer> nums){
        int n = 0;
        for (Integer num : nums) {
            n+=num;
        }
        return n/nums.size();
    }
}
