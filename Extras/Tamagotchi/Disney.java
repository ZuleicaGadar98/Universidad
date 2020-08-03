import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Disney extends JFrame{
    
 //Declaración del objeto
    private DisneyObjeto DO = new DisneyObjeto ();
    
    //Declaración de variables
    JPanel panel1, panel2, panel3, panel6, panel7;
    JButton boton3, botonComer, botonDormir, botonLeer, botonBailar, botonArco, 
            botonBano, botonDisfraz, botonEje, botonPintar, botonPelo,
            botonTraba, botonCepillar,botonJugar;
     JLabel titulo,etiqueta, barra, barra2, barra3, barra4, barra5, cuadro;
     JMenu menu, autor;
     JMenuItem guardar, cargar, salir, datos, dato;
     ImageIcon inicio, comer, leer, dormir, bailar, arco, bano, dis, eje, pintar,
             pelo, traba, cep, jugar, icono, despedida, tangled, salida,so;
     JProgressBar felicidad, higiene, sueño, hambre, vida;
     private File archivo;
     private ObjectOutputStream oos;
     private ObjectInputStream ois;
     
  //Modificación del font de los botones
     Font letras = new Font ("Segoe Print",1, 14);
      
     public Disney ()
     {
      //Título de la interfaz
         super("Tamagotchi");
         setIconImage (new ImageIcon ("D.png").getImage());
         menu=new JMenu("Menu");
         autor=new JMenu("Info");
      
         guardar = new JMenuItem("Save");
         cargar  = new JMenuItem("Last Game");
         salir   = new JMenuItem("Exit");
         datos   = new JMenuItem("Datos del almuno");
         dato    = new JMenuItem("Datos del maestro");
        
         autor.add(datos);
         autor.add(dato);
         menu.add(guardar);
         menu.add(cargar);
         menu.add(salir);
      
         JMenuBar barras = new JMenuBar();  
         setJMenuBar( barras );  
         barras.add( menu );
         barras.add( autor );
         
         Container contenedor=getContentPane();
         contenedor.setLayout( new BorderLayout() );
         
    //Colores de los botones 
        Color z = new Color (113, 204, 178);
        Color s = new Color (121, 226, 154);
        Color g = new Color (121, 207, 226);
        Color p = new Color (126, 163, 211);
        Color k = new Color (159, 138, 225);
        Color d = new Color (191, 138, 225);
        
       
    //Construcción del primer panel    
        panel1= new JPanel(new FlowLayout());
        titulo = new JLabel("         TAMAGOTCHI ");
        Icon logo = new ImageIcon ("logo.png");
        etiqueta = new JLabel( logo );
        panel1.add( etiqueta );
        panel1.setBackground(Color.WHITE);
        
        Font letra = new Font ("Tahoma",1, 24);
        titulo.setFont(letra);
        
     //Adicción los elementos al panel 1  
        panel1.add(titulo);
        panel1.setBackground(Color.WHITE);
        
    //Creación del Panel donde estarán las progressbars
        panel7 = new JPanel(new GridBagLayout());
        panel7.setBackground(Color.WHITE);

    //Orden de los botones 
        GridBagConstraints m = new GridBagConstraints ();
        m.insets = new Insets (5,8,5,8);
        m.gridx=0;
        m.gridy =0;
    
    //Dirección de los botones 
        m.anchor = GridBagConstraints.LINE_START;
        
    //Color de las progressbars    
        Color a = new Color (196, 92, 151);
        Font le = new Font ("MV Boli",1, 17); //Fuente
        
    //Creación de las progressbars 
            
        felicidad = new JProgressBar(0,100);
        felicidad.setValue(50);
        felicidad.setForeground(a);
        felicidad.setStringPainted(true);
        felicidad.setString("FELICIDAD");
        felicidad.setFont(le);
        
        higiene = new JProgressBar (0,100);
        higiene.setValue(50);
        higiene.setForeground(a);
        higiene.setStringPainted(true);
        higiene.setString("HIGIENE");
        higiene.setFont(le);
        
        sueño = new JProgressBar (0,100);
        sueño.setValue(50);
        sueño.setForeground(a);
        sueño.setStringPainted(true);
        sueño.setString("SUEÑO");
        sueño.setFont(le);
        
        hambre = new JProgressBar (0,100);
        hambre.setValue(50);
        hambre.setForeground(a);
        hambre.setStringPainted(true);
        hambre.setString("HAMBRE");
        hambre.setFont(le);
        
        vida = new JProgressBar (0,100);
        vida.setValue(80);
        vida.setForeground(a);
        vida.setStringPainted(true);
        vida.setString("VIDA");
        vida.setFont(le);
        
    //Adición de los elementos al panel 7  
        panel7.add((vida),m);
        m.gridy ++;
        
        panel7.add((felicidad),m);
        m.gridy ++;
        
        panel7.add((higiene),m);
        m.gridy ++;
        
        panel7.add((sueño),m);
        m.gridy ++;
        
        panel7.add((hambre),m);
        m.gridy ++;
        
        panel7.setBackground(Color.WHITE);
        
    //Creación del panel 2
        panel2= new JPanel(new FlowLayout());
        panel2.setBackground(Color.WHITE);
    
    //Creación del panel 6
        panel6 = new JPanel (new FlowLayout());
        Icon inicio = new ImageIcon ("intro.gif");
        etiqueta = new JLabel( inicio );
        panel6.add( etiqueta );
        panel6.setBackground(Color.WHITE);
        
     //Creación de la clase manejadora
	Manejadora escucha = new Manejadora();        

    //Panel de imagen que tiene las etiquetas y campos de texto
        panel3 = new JPanel(new GridBagLayout());
        panel3.setBackground(Color.WHITE);

    //Orden de los botones 
        GridBagConstraints c = new GridBagConstraints ();
        c.insets = new Insets (3,8,3,8);
        c.gridx=0;
        c.gridy =0;
    
    //Dirección de los botones 
        c.anchor = GridBagConstraints.LINE_START;
    
    // Creación de los 14 botones
        botonLeer = new JButton( "Leer");
        panel3.add( (botonLeer),c );
        c.gridy ++;
        botonLeer.setBackground(z); //Fondo
        botonLeer.setForeground(Color.BLACK);//Letra
        botonLeer.setFont(letras);
        
        botonJugar = new JButton( "Guitarra");
        panel3.add( (botonJugar),c );
        c.gridy ++;
        botonJugar.setBackground(s); //Fondo
        botonJugar.setForeground(Color.BLACK);//Letra
        botonJugar.setFont(letras);
        
        botonBailar = new JButton( "Hornear");
        panel3.add( (botonBailar),c );
        c.gridy ++;
        botonBailar.setBackground(g); //Fondo
        botonBailar.setForeground(Color.BLACK);//Letra
        botonBailar.setFont(letras);
        
        botonPintar = new JButton( "Pintar");
        panel3.add( (botonPintar),c );
        c.gridy ++;
        botonPintar.setBackground(d); //Fondo
        botonPintar.setForeground(Color.BLACK);//Letra
        botonPintar.setFont(letras);
    
        botonComer = new JButton( "Comer");
        panel3.add(( botonComer),c );
        c.gridy ++;
        botonComer.setBackground(k); //Fondo
        botonComer.setForeground(Color.BLACK);//Letra
        botonComer.setFont(letras);
        
        botonDormir = new JButton( "Dormir");
        panel3.add( (botonDormir),c );
        c.gridy ++;
        botonDormir.setBackground(p); //Fondo
        botonDormir.setForeground(Color.BLACK);//Letra
        botonDormir.setFont(letras);

        botonBano = new JButton( "Bañarse");
        panel3.add( (botonBano),c );
        c.gridy ++;
        botonBano.setBackground(z); //Fondo
        botonBano.setForeground(Color.BLACK);//Letra
        botonBano.setFont(letras);   
   
        botonEje = new JButton( "Ejercicio");
        panel3.add( (botonEje),c );
        c.gridy ++;
        botonEje.setBackground(s); //Fondo
        botonEje.setForeground(Color.BLACK);//Letra
        botonEje.setFont(letras); 

        botonTraba = new JButton( "Trabajar");
        panel3.add( (botonTraba),c );
        c.gridy ++;
        botonTraba.setBackground(g); //Fondo
        botonTraba.setForeground(Color.BLACK);//Letra
        botonTraba.setFont(letras);        

        botonArco = new JButton( "Ventriloquía");
        panel3.add( (botonArco),c );
        c.gridy ++;
        botonArco.setBackground(d); //Fondo
        botonArco.setForeground(Color.BLACK);//Letra
        botonArco.setFont(letras);

        botonCepillar = new JButton( "Cepillar el pelo");
        panel3.add( (botonCepillar),c );
        c.gridy ++;
        botonCepillar.setBackground(k); //Fondo
        botonCepillar.setForeground(Color.BLACK);//Letra
        botonCepillar.setFont(letras);

        botonPelo = new JButton( "Cortarse el pelo");
        panel3.add( (botonPelo),c );
        c.gridy ++;
        botonPelo.setBackground(p); //Fondo
        botonPelo.setForeground(Color.BLACK);//Letra
        botonPelo.setFont(letras);
        
        botonDisfraz = new JButton( "NANI??????");
        panel3.add( (botonDisfraz),c );
        c.gridy ++;
        botonDisfraz.setBackground(z); //Fondo
        botonDisfraz.setForeground(Color.BLACK);//Letra
        botonDisfraz.setFont(letras);
        
        //Implementado tamaño a los botones
        botonLeer.setPreferredSize(new Dimension(120,30));
        botonComer.setPreferredSize(new Dimension(120,30));
        botonDormir.setPreferredSize(new Dimension(120,30));
        botonBailar.setPreferredSize(new Dimension(120,30));
        botonArco.setPreferredSize(new Dimension(120,30)); 
        botonBano.setPreferredSize(new Dimension(120,30));
        botonDisfraz.setPreferredSize(new Dimension(150,30));
        botonEje.setPreferredSize(new Dimension(120,30));
        botonPintar.setPreferredSize(new Dimension(120,30));
        botonPelo.setPreferredSize(new Dimension(150,30));
        botonTraba.setPreferredSize(new Dimension(120,30));
        botonCepillar.setPreferredSize(new Dimension(150,30));
        botonJugar.setPreferredSize(new Dimension(120,30));

     //Implementación de los panel 3 al panel 2 
        panel2.add(panel3);
 
    //Agregación objeto a los componentes de escucha 
         
         cargar.addActionListener(escucha);
         guardar.addActionListener(escucha);
         salir.addActionListener(escucha);
         datos.addActionListener(escucha);
         dato.addActionListener(escucha);
         botonComer.addActionListener(escucha);
         botonDormir.addActionListener(escucha);
         botonLeer.addActionListener(escucha);
         botonPintar.addActionListener(escucha);
         botonBailar.addActionListener(escucha);
         botonJugar.addActionListener(escucha);
         botonCepillar.addActionListener(escucha);
         botonPelo.addActionListener(escucha);
         botonEje.addActionListener(escucha);
         botonBano.addActionListener(escucha);
         botonArco.addActionListener(escucha);
         botonDisfraz.addActionListener(escucha);
         botonTraba.addActionListener(escucha);

    //creando el contenedor
        getContentPane().add(panel1, BorderLayout.NORTH);
        getContentPane().add(panel2, BorderLayout.WEST);
        getContentPane().add(panel6, BorderLayout.CENTER);
        getContentPane().add(panel7, BorderLayout.EAST);
        contenedor.setBackground(Color.WHITE);
        pack();
        setLocation(0,0);
        setSize( 1520, 750 );
        setVisible( true );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
    
    //Creación de la clase Manejadora que escucha "Cierra el programa"
        private class Manejadora implements ActionListener
        {
            
        //Implementa el actionperfomed
            @Override
            public void actionPerformed(ActionEvent evento) {
                
                Font me = new Font ("MV Boli",1, 20);
                
        //Modificando los valores de las progressbars dependiendo del boton seleccionado
        
                if (evento.getSource() == botonLeer) 
                {
                    leer = new ImageIcon ("leer.gif");
                    etiqueta.setIcon(leer);
                    
             //Movimiento de las progressbars 
                    DO.setHambre(DO.getHambre()- 5);           hambre.setValue(DO.getHambre());        
                    DO.setHigiene(DO.getHigiene()- 5);         higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()+ 6);             sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()- 8);     felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()- 5);               vida.setValue(DO.getVida());
                      
                }
                
                if (evento.getSource() == botonJugar) 
                {
                    jugar = new ImageIcon ("tocar.gif");
                    etiqueta.setIcon(jugar);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 6);          hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()- 5);        higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 4);            sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 6);    felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()+ 9);              vida.setValue(DO.getVida());
                     
                }
                
                if (evento.getSource() == botonBailar) 
                {
                    bailar = new ImageIcon ("galleta.gif");
                    etiqueta.setIcon(bailar);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()+ 14);          hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()- 15);        higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 8);             sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 6);     felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()- 7);               vida.setValue(DO.getVida());
                     
                }
                
                if (evento.getSource() == botonPintar) 
                {
                    pintar = new ImageIcon ("pintar.gif");
                    etiqueta.setIcon(pintar);
                    
                    //Movimiento de las progressbars
                    DO.setHigiene(DO.getHigiene()-5);           higiene.setValue(DO.getHigiene());    
                    DO.setSueno(DO.getSueno()+ 3);              sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 8);      felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()- 7);                vida.setValue(DO.getVida());
                    
                                             hambre.setValue(DO.getHambre());           
                   
                }
                
                if (evento.getSource() == botonComer) 
                {
                    comer = new ImageIcon ("comida.gif");
                    etiqueta.setIcon(comer);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()+ 100);         hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()- 20);        higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 10);             sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 11);    felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()- 9);               vida.setValue(DO.getVida());
                   
                }
                
                if (evento.getSource() == botonDormir) 
                {
                    dormir = new ImageIcon ("dormir.gif");
                    etiqueta.setIcon(dormir);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 15);         hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()- 15);       higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()+ 100);         sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 3);   felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()+ 6);             vida.setValue(DO.getVida());
                   
                }
                
                if (evento.getSource() == botonBano) 
                {
                    bano = new ImageIcon ("baño.gif");
                    etiqueta.setIcon(bano);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 16);          hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()+ 100);      higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 15);            sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()- 10);    felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()+ 3);              vida.setValue(DO.getVida());
               
                }
                
                if (evento.getSource() == botonEje) 
                {
                    eje = new ImageIcon ("ejercicio2.gif");
                    etiqueta.setIcon(eje);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 7);        hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()- 19);      higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()+ 10);         sueño.setValue(DO.getSueno());
                    DO.setVida(DO.getVida()+ 3);            felicidad.setValue(DO.getFelicidad());
                    
                                            vida.setValue(DO.getVida());
                    
                }
                
                if (evento.getSource() == botonTraba) 
                {
                    traba = new ImageIcon ("limpiar.gif");
                    etiqueta.setIcon(traba);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 7);          hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()+ 5);        higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 6);            sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 7);    felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()- 9);              vida.setValue(DO.getVida());
                    
                }
                
                if (evento.getSource() == botonArco) 
                {
                    arco = new ImageIcon ("ven.gif");
                    etiqueta.setIcon(arco);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 10);          hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()- 3);        higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()+ 4);            sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 3);   felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()-7);              vida.setValue(DO.getVida());
                   
                }
                
                if (evento.getSource() == botonDisfraz) 
                {                    
                    //Movimiento de las progressbars
                    DO.setVida(DO.getVida()-100);
                    
                    DO.setHambre(0);    DO.setHigiene(0);
                    DO.setSueno(0);    DO.setFelicidad(0);
                    
                    
                }
                
                if (evento.getSource() == botonPelo) 
                {
                    pelo = new ImageIcon ("pelos.gif");
                    etiqueta.setIcon(pelo);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 5);         hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()+ 7);       higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 8);           sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 3);   felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()- 6);             vida.setValue(DO.getVida());
                    
                }
                
                 if (evento.getSource() == botonCepillar) 
                {
                    cep = new ImageIcon ("cepillar.gif");
                    etiqueta.setIcon(cep);
                    
                    //Movimiento de las progressbars
                    DO.setHambre(DO.getHambre()- 4);         hambre.setValue(DO.getHambre());
                    DO.setHigiene(DO.getHigiene()+ 7);       higiene.setValue(DO.getHigiene());
                    DO.setSueno(DO.getSueno()- 9);           sueño.setValue(DO.getSueno());
                    DO.setFelicidad(DO.getFelicidad()+ 7);   felicidad.setValue(DO.getFelicidad());
                    DO.setVida(DO.getVida()+ 2);            vida.setValue(DO.getVida());
                                        
                }
                 
                 
            //Indicación para cerrar la vemtana desde el menu  
            //Creación de archivos
            //Componente para cguardar   
            
                if (evento.getSource()== guardar){
                    
                    so = new ImageIcon ("sorry.gif");
                    JOptionPane.showMessageDialog(null, "" , "Disculpa", JOptionPane.INFORMATION_MESSAGE,so);
                    /*archivo = new File ("Disney.tmp");

                    try{
                        oos = new ObjectOutputStream (new FileOutputStream(archivo));
                        oos.writeObject(DO);
                        oos.close();
                        
                    }   

                    catch (IOException ex) {
                            System.out.println("!! TENEMOS UN 33 12 !!");
                        }*/
                }
            
            //Archivos con el boton de cargar    
                
                if (evento.getSource() == cargar){
                    so = new ImageIcon ("sorry.gif");
                    
                    JOptionPane.showMessageDialog(null, "" + "" , "Disculpa", JOptionPane.INFORMATION_MESSAGE,so);
                    
                    /*try{
                        ois = new ObjectInputStream (new FileInputStream (archivo));
                        DO = (DisneyObjeto) ois.readObject();
                        sueño.setValue(DO.getSueno());
                        felicidad.setValue(DO.getFelicidad());
                        hambre.setValue(DO.getFelicidad());
                        vida.setValue(DO.getFelicidad());
                        higiene.setValue(DO.getFelicidad());

                    }   

                    catch (ClassNotFoundException ex) {
                            Logger.getLogger(Disney.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("!!! TENEMOS UN 33 12 !!!");
                        } 
                    catch (FileNotFoundException ex) {
                            Logger.getLogger(Disney.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    catch (IOException ex) {
                            Logger.getLogger(Disney.class.getName()).log(Level.SEVERE, null, ex);
                        }*/
            }
            
                if(evento.getSource()== salir)
                        {
                             cuadro = new JLabel(" ¿Seguro que quieres salir del juego? ");
                             cuadro.setFont(letras);
                             
                            int s= JOptionPane.showConfirmDialog(null, cuadro , "Mensaje de salida",JOptionPane.YES_NO_OPTION);
                            if(s==JOptionPane.YES_OPTION){
                                System.exit(0);
                            } 
                            
                             
                        }
                    
                if(evento.getSource()== datos)
                     {
                         tangled = new ImageIcon ("inicio.png");
                         JOptionPane.showMessageDialog(null, "Alexandra Zuleica Gadar Delgado" + "\n #8999" , "Datos del autor", JOptionPane.INFORMATION_MESSAGE,tangled);      
                  }
                
                if(evento.getSource()== dato)
                     {
                         tangled = new ImageIcon ("inicio2.png");
                         JOptionPane.showMessageDialog(null, "Profesor: Lucia Beltran" + "\n Programación Orientada a Objetos" , "Datos de la materia", JOptionPane.INFORMATION_MESSAGE,tangled);      
                  }  
                
            //Mensaje de despedida    
                
                if (DO.getHambre()<0)
                    {
                        DO.setVida(0);
                        icono = new ImageIcon ("sad.gif");
                        JOptionPane.showMessageDialog(null," ", "Tu Tamagotchi ha muerto", JOptionPane.INFORMATION_MESSAGE,icono);

                        despedida = new ImageIcon ("bye.gif");
                        JOptionPane.showMessageDialog(null, "   ", "Hasta pronto vaquero", JOptionPane.INFORMATION_MESSAGE, despedida);
                        System.exit(0);
                    }
                
                if (DO.getVida()<0)
                {
                    icono = new ImageIcon ("sad.gif");
                    JOptionPane.showMessageDialog(null," ", "Tu Tamagotchi ha muerto", JOptionPane.INFORMATION_MESSAGE,icono);
                    System.exit(0);
                }

            //Restablecer los valores de las progressbars
                if (DO.getFelicidad() < 0)
                        {
                            DO.setFelicidad(0);
                        }
                    
                    else if (DO.getFelicidad() > 100)
                        {
                               DO.setFelicidad(100);
                        }
                    
                if (DO.getSueno() < 0)
                        {
                            DO.setSueno(0);
                        }
                    
                    else if (DO.getSueno() > 100)
                        {
                            DO.setSueno(100);
                        }
                    
                if (DO.getHigiene() < 0)
                        {
                            DO.setHigiene(0);
                        }
                    
                    else if (DO.getHigiene() > 100)
                            {
                                DO.setHigiene(100);
                            }
                    
                if (DO.getHambre() < 0)
                        {
                            DO.setHambre(0);
                        }
                    
                    else if (DO.getHambre() > 100)
                            {
                                DO.setHambre(100);
                            }
                    
                if (DO.getVida() < 0)
                        {
                            DO.setVida(0);
                        }
                    
                    else if (DO.getVida() > 100)
                        {
                               DO.setVida(100);
                        }
           
                }
        }

 }