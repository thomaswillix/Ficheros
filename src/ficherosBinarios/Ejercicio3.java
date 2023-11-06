package ficherosBinarios;

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
        System.out.println("Sexo: ");
        while (!comprSex(sc, sex)) {            
            System.out.println("Solo se aceptan como valores correctos H/M/N, vuelva a introducir por favor");
            comprSex(sc, sex);
        }
        System.out.println("Edad: ");
        age = sc.nextInt();
        while (age<20 || age > 60){
            System.out.println("Vuelva a introducir la edad por favor (20 - 60)");
            age = sc.nextInt();
        }
        System.out.println("Asignaturas suspensas: ");
        sus = sc.nextInt();
        while (sus<0 || sus>4) {            
            System.out.println("Las asignaturas suspensas solo pueden tomar valores comprendidos entre 0 - 4");
            sus = sc.nextInt();   
        }
        System.out.println("¿Vive de alquiler? (s-n)");
        viv = sc.nextLine().toLowerCase().trim().charAt(0);
        while(viv!='s'|| viv!='n'){
            System.out.println("Vuelva a introducir la respuesta (s-n)");
            viv = sc.nextLine().toLowerCase().trim().charAt(0);
        }
        if(viv=='s'){
            res = true;
        }else{
            res = false;
        }

        
    }
    
    public static boolean comprSex(Scanner sc, char sexo){
        sexo = sc.nextLine().toUpperCase().trim().charAt(0);

        if (sexo != 'H' || sexo!= 'M' || sexo != 'N'){
            return false;
        }
        return true;
    }
    
}
