
package ficherosSerializables.supermercado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClaseOutput extends ObjectOutputStream {
    
    ClaseOutput(FileOutputStream f) throws IOException{
      super(f);   
    }

    @Override
    protected void writeStreamHeader() throws IOException {}
    
}
