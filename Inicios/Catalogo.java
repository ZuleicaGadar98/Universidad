/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author e008999
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventObject;


public class Catalogo extends JFrame {

     JPanel panel1, panel2, panel3, panel4, panel5;
     JButton boton1, boton2, boton3, botonCopiar;
     JLabel logo, titulo, flor,etiqueta; 
     JTextArea areaTexto1, areaTexto2;
     Font tipoLetraSimple, tipoLetraNegrita, tipoLetraCursiva, tipoLetraNegritaCursiva;
     JRadioButton botonSimple, botonNegrita, botonCursiva, 
     botonNegritaCursiva;
     ButtonGroup grupoBotonesOpcion;
     JComboBox cuadroCombImagenes;   
    
   private String desertica[] = { "Lavanda", "Cactus","Diente de León",
       "Romero","Lirio del valle", "Violeta", "Alcatraz", "Flor de loto"};
   private Icon de[] = { new ImageIcon( desertica[ 0 ],"C:\\Users\\e008999\\Desktop\\Universidad\\FRAME\\logo.png" ),
   new ImageIcon( desertica[ 1 ])};
 
   public Catalogo()
    {
        super("Catalogo de flores");
    Container contenedor=getContentPane();
    contenedor.setLayout( new BorderLayout() );
        
    //Construcción del primer panel    
    panel1= new JPanel(new FlowLayout());
    Icon ellogo = new ImageIcon ("C:\\Users\\e008999\\Desktop\\Universidad\\FRAME\\logo.png");
    logo= new JLabel (ellogo);
    titulo = new JLabel("Catálogo de flores");
    panel1.add(logo);
    panel1.add(titulo);
    panel1.setBackground(Color.WHITE);
    
    //Construccion del segunfdo panel con dos mas adentro
    panel2= new JPanel(new FlowLayout());
    panel2.setBackground(Color.LIGHT_GRAY);
    
    //Etiqueta imagen
    Icon flores = new ImageIcon ("C:\\Users\\e008999\\Desktop\\Universidad\\FRAME\\FLOR.png");
    flor= new JLabel (flores);
    
    
    //Panel de imagen que tiene las etiquetas y campos de texto
    panel3 = new JPanel(new GridLayout(4,2,10,10));
    panel3.setBackground(Color.WHITE);
    
    // obtener panel de contenido y establecer su esquem
    
      // crear botones de opci�n
      botonSimple = new JRadioButton( "Deserticas", true );
      panel3.add( botonSimple );
      
      botonNegrita = new JRadioButton( "Silvestre", false );
      panel3.add( botonNegrita );
      
      botonCursiva = new JRadioButton( "Sombra", false );
      panel3.add( botonCursiva );
      
      botonNegritaCursiva = new JRadioButton( "Acuaticas", false );
      panel3.add( botonNegritaCursiva );
      
      cuadroCombImagenes = new JComboBox( desertica );
      cuadroCombImagenes.setMaximumRowCount( 4 );
      cuadroCombImagenes.addItemListener(

         new ItemListener() {  // clase interna an�nima 

            // manejar evento para JComboBox
            public void itemStateChanged( ItemEvent evento )
            {
               // determinar si la casilla de verificaci�n est� seleccionada
			   if ( evento.getStateChange() == ItemEvent.SELECTED )
                  etiqueta.setIcon( de[ 
                     cuadroCombImagenes.getSelectedIndex() ] );
            }

         }  // fin de la clase interna an�nima

      );
      
      panel3.add( cuadroCombImagenes );
     
     etiqueta = new JLabel( de[ 0 ] );
      panel3.add( etiqueta ); 
      setSize( 350, 150 );
      setVisible( true );

      
     // crear relacion logica entre objetos JRadioButton
      grupoBotonesOpcion = new ButtonGroup();
      grupoBotonesOpcion.add( botonSimple );
      grupoBotonesOpcion.add( botonNegrita );
      grupoBotonesOpcion.add( botonCursiva );
      grupoBotonesOpcion.add( botonNegritaCursiva);   
      
    //Creación de la clase manejadora
	Manejadora escucha = new Manejadora();

    //Estamos agregando todo al Panel2 en el centro
    panel2.add(flor);
    panel2.add(panel3);
     
    //Creación del panel4 de botones
    panel4=new JPanel(new FlowLayout());
    panel4.setBackground(Color.WHITE);
    
    //Botones del panel 4    
      Icon home = new ImageIcon ("C:\\Users\\e008999\\Desktop\\Universidad\\FRAME\\casa.png");
      boton1 = new JButton(home);
     
      boton3 = new JButton("Salir");
    
    panel4.add(boton1);
    panel4.add(boton3);
    
    
    //Agregación objeto a los componentes gráficos 
    boton1.addActionListener(escucha);
    boton3.addActionListener(escucha);

    //creando el contenedor
    getContentPane().add(panel1, BorderLayout.NORTH);
    getContentPane().add(panel2, BorderLayout.CENTER);
    getContentPane().add(panel4, BorderLayout.SOUTH);
    contenedor.setBackground(Color.WHITE);
    pack();
    setSize( 800, 300 );
    setVisible( true );
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
   
    private class Manejadora implements ActionListener
    {
        //Implementa el actionperfomed
        public void actionPerformed(ActionEvent evento) {
            
            if (evento.getSource()==boton1)
            {
                flor.setVisible(false);
            }
            else 
                if(evento.getSource()==boton3)
                     {
                         flor.setVisible(true);
                     }
            
        }
        
    }
    public static void main(String args[]){
      Catalogo micatalogo = new Catalogo();
       
   }
    
}
