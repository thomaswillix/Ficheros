
package ficherosSerializables;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
  public static void main(String[] args) {
      File f=new File("datos.obj");
      try{
          /*FileOutputStream fos=new FileOutputStream(f);
          ObjectOutputStream oos=new ObjectOutputStream(fos);
          Alumno al=new Alumno(1,"Alumno1");
          oos.writeObject(al);
          al=new Alumno(2,"Alumno2");
          oos.writeObject(al);
          al=new Alumno(3,"Alumno3");
          oos.writeObject(al);
          
          oos.close();
          fos.close();*/
          if(!f.exists()){
            FileOutputStream fos=new FileOutputStream(f);
            ObjectOutputStream co=new ObjectOutputStream(fos); 
            
            co.close();
            fos.close();
          }
          
          FileOutputStream fos=new FileOutputStream(f,true);
          ClaseOutput co=new ClaseOutput(fos);
          Alumno al;
          al=new Alumno(4,"Alumno1B");
          co.writeObject(al);
          al=new Alumno(5,"Alumno2B");
          co.writeObject(al);
          al=new Alumno(6,"Alumno3B");
          co.writeObject(al);
          
          co.close();
          fos.close();
          
        
        FileInputStream fis=new FileInputStream(f);
        ObjectInputStream ois=new ObjectInputStream(fis);
       // Alumno al;
        try{
           while(true){
               al=(Alumno)ois.readObject();
               System.out.println(al.toString());
           } 
        }catch(EOFException e){}
        
        ois.close();
        fis.close();
          
      }catch(IOException e){
          System.out.println(e);
      }catch(ClassNotFoundException e){
          System.out.println(e);
      }
        
    }
  
}
