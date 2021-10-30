import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Connection {
    private RandomAccessFile rafHeader;
    private RandomAccessFile rafData;
    private File fileHeader;
    private File fileData;

    public Connection(File fileHeader, File fileData) throws FileNotFoundException {
        try {
            rafHeader =   new RandomAccessFile(fileHeader, "rw");

            if (rafHeader.length() == 0) {
                rafHeader.seek(0);
                rafHeader.writeInt(0); // n ; Cantidad  de registros
                rafHeader.writeInt(0); // k ; id de cada registro
            }
            
            rafData = new RandomAccessFile(fileData, "rw");

            this.fileHeader = fileData;
            this.fileData = fileData;
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RandomAccessFile getRafHeader() {
        //Si raf es nulo inicializarlo
        if (rafHeader == null) {
            try {
                rafHeader = new RandomAccessFile(this.fileHeader,"rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return rafHeader;
    }

    //Metodo que  devuelve el raf de datos y si es nulo inicializarlo
    public RandomAccessFile getRafData() {
        //Si raf es nulo inicializarlo
        if (rafData == null) {
            try {
                rafData = new RandomAccessFile(this.fileData,"rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return rafData;
    }

    //Metodo que cierre el flujo de bytes del raf
    public void close() {
        try {
            // si los objetos tipo RandomAccessFile no son nulos cerrarlos
            if (rafHeader != null) {
                rafHeader.close();
                rafHeader = null;
            }

            if (rafData != null) {
                rafData.close();
                rafData = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}