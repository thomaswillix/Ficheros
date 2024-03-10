package ficherosSerializables.agenda;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ClaseOutput extends ObjectOutputStream {

    public ClaseOutput(FileOutputStream fos) throws IOException {
        super(fos);
    }

    @Override
    protected void writeStreamHeader() throws IOException {}

}
