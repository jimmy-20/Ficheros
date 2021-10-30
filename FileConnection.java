import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JOptionPane;

public class FileConnection extends Connection {
    private File fileHeader;
    private File fileData;
    public final int SIZE_Vehiculo = 156;

    public FileConnection(File fileheader, File fileData) throws FileNotFoundException {
        super(fileheader, fileData);

        this.fileHeader = fileheader;
        this.fileData = fileData;
    }

    @Override
    public void close() {
        super.close();
    }

    public void create(Vehiculo v)
    {
        if (v == null){
            return;
        }

            try {
                getRafHeader().seek(0);
                int n = getRafHeader().readInt(); // n = numero de vehiculos
                int k = getRafHeader().readInt(); // k = Id

                long posData = n*SIZE_Vehiculo;

                getRafData().seek(posData); // Colocar al final del ultimo registro

                getRafData().writeInt(++k);
                getRafData().writeUTF(v.getNombre());
                getRafData().writeUTF(v.getMarca());
                getRafData().writeUTF(v.getModelo());
                getRafData().writeUTF(v.getColor());
                getRafData().writeFloat(v.getPrecio());


                getRafHeader().seek(0); //Colocar puntero al inicio en el header
                getRafHeader().writeInt(++n); // como se hizo un nuevo registro se aumenta 1 y se guarda
                getRafHeader().writeInt(k); // Como se hizo un nuevo registro se aumenta 1 y se guarda

            } catch (IOException e) {
                e.printStackTrace();
            }

        JOptionPane.showMessageDialog(null, "Registro exitoso");
            
    }

    public Collection<Vehiculo> findAll(){
        Collection<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        Vehiculo v = null;
        
        try {
            getRafHeader().seek(0);
            int n = getRafHeader().readInt(); // n = numero de vehiculos
            int k = getRafHeader().readInt(); // k = Id

            

            for (int i = 0; i < n; i++) {

                long posData = i*SIZE_Vehiculo;

                getRafData().seek(posData); // Colocar al final del cada registro
                v = new Vehiculo();
                v.setId(getRafData().readInt());
                v.setNombre(getRafData().readUTF());
                v.setMarca(getRafData().readUTF());
                v.setModelo(getRafData().readUTF());
                v.setColor(getRafData().readUTF());
                v.setPrecio(getRafData().readFloat());
                
                vehiculos.add(v);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehiculos;
    }
}
