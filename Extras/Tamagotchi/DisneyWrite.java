/*import java.io.*;

public class DisneyWrite implements Serializable {
     
    private boolean enableOverride;
    FileOutputStream f;
    ObjectOutputStream obis;
    
    public DisneyObjeto disney;
    
    public DisneyWrite (DisneyObjeto disney){
        this.disney=disney;
    }
    
    public void abrirArchivo (Object disney) throws FileNotFoundException, IOException{
       
        f= new FileOutputStream ("DisneyObjeto.tmp", false);
        obis = new ObjectOutputStream (f);
        enableOverride = true;
        
        if (enableOverride){
        obis.writeObject(disney);
        return;
        }
        
    }
    
    public void cerrarArchivo () throws IOException{
        obis.close();
    }  
    
}
*/