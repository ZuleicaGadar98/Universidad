/*import java.io.*;
import javax.swing.*;

public class DisneyRead implements Serializable{

    FileInputStream f;
    ObjectInputStream obis;
    
    void abrirArchivo () throws IOException{
        try
        {
            f = new FileInputStream ("DisneyObjeto.tmp");
            obis = new ObjectInputStream(f);
        }
        
        catch (IOException io)
        {
            JOptionPane.showMessageDialog (null, "Error en el archivo", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cerrarArchivo() throws IOException{
        obis.close();
    }
    
    
}*/
