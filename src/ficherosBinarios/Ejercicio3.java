package ficherosBinarios;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Thomas Freitas
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nom;
        char sex='N', viv='s';
        int age, sus;
        boolean res = true;
        double ing;
        
        System.out.println("Nombre completo: ");
        nom = sc.nextLine();

        System.out.println("Sexo (H/M/N): ");
        do {
            sex = sc.nextLine().toUpperCase().trim().charAt(0);
        }while(!comprSex(sex));

        System.out.println("Edad: ");
        age = sc.nextInt();
        while (age<20 || age > 60){
            System.out.println("Vuelva a introducir la edad por favor (20 - 60)");
            age = sc.nextInt();
        }

        System.out.println("Asignaturas suspensas: ");
        sus = sc.nextInt();
        while (sus < 0 || sus > 4) {
            System.out.println("Las asignaturas suspensas solo pueden tomar valores comprendidos entre 0 - 4");
            sus = sc.nextInt();   
        }
        sc.nextLine();

        System.out.println("¿Vive de alquiler? (s-n)");
        viv = sc.next().toLowerCase().trim().charAt(0);
        while(viv!='s'&& viv!='n'){
            System.out.println("Vuelva a introducir la respuesta (s-n)");
            viv = sc.nextLine().toLowerCase().trim().charAt(0);
        }
        if(viv=='s'){
            res = true;
        }else{
            res = false;
        }

        System.out.println("Indique los ingresos anuales de su familia");
        ing = sc.nextDouble();
        while (ing < 0){
            System.out.println("Los ingresos no pueden ser menores a 0");
            ing = sc.nextDouble();
        }

        File output = new File("datosbeca.bin");
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(output,true));
            dos.writeUTF(nom);
            dos.writeChar(sex);
            dos.writeInt(age);
            dos.writeInt(sus);
            dos.writeBoolean(res);
            dos.writeDouble(ing);

            dos.close();
            System.out.println("--------------- LECTURA DEL FICHERO BINARIO ---------------");
            DataInputStream dis = new DataInputStream(new FileInputStream(output));
            while(true){
                System.out.println("DATOS DE LA BECA: " + dis.readUTF() + " " + dis.readChar() + " " +
                        dis.readInt() + " " + dis.readInt() + " " + dis.readBoolean() + " " +
                        dis.readDouble());
            }
        } catch (EOFException e) {
            System.err.println("Sacabao");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static boolean comprSex(char sexo){
        if (sexo != 'H' && sexo!= 'M' && sexo != 'N'){
            System.out.println("Solo se aceptan como valores correctos H/M/N, vuelva a introducir por favor");
            return false;
        }
        return true;
    }
    
}
