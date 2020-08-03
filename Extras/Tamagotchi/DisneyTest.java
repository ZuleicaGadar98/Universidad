
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class DisneyTest {
    
    
    public static void main(String args[]){
        
      ImageIcon entrada;
      JLabel cuadro, cuadro2, cuadro3;
        //Modificación del font de los botones
     Font letras = new Font ("Segoe Print",1, 14);
      
      Disney midisney = new Disney();
      
      entrada = new ImageIcon ("hola.jpg");
      
      cuadro = new JLabel( "Bienvenido a este tu Tamagotchi...");
      cuadro.setFont(letras);
      JOptionPane.showMessageDialog(null,cuadro, "Mensaje de Bienvenida!!!!", JOptionPane.QUESTION_MESSAGE,entrada); 
      
        cuadro2 = new JLabel(  "Tu tamagotchi se llama RAPUNZEL :)");
        cuadro2.setFont(letras);
        JOptionPane.showMessageDialog(null,cuadro2 , "Presentación", JOptionPane.QUESTION_MESSAGE,entrada);
      
            cuadro3 = new JLabel(  "Sin más por el momento comencemos" );
            cuadro3.setFont(letras);
            JOptionPane.showMessageDialog(null,cuadro3, "INICIO!!!", JOptionPane.QUESTION_MESSAGE,entrada); 
                                 
        
   }
    
}
