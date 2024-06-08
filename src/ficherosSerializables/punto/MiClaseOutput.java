package ficherosSerializables.punto;
import java.io.*;

public class MiClaseOutput extends ObjectOutputStream {

    MiClaseOutput(FileOutputStream f) throws IOException {
        super(f);
    }

    protected void writeStreamHeader() throws IOException {
    }
}
