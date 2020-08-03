

import javax.swing.JOptionPane;


public class Conversion {

  
    public static void main(String[] args) {
    //Declaracion
    String opcion;
    double km, mill, kg, lbs;
    
    //Entrada
    opcion = (JOptionPane.showInputDialog("Elige la opcion correspondiente: \n a.-Km a Mill \n b.-Mill a Km \n c.-Kg a Lbs \n d.-Libs a Kg" ));
    
    //Proceso
    switch(opcion){
        case "a":
         km = Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad de km que deseas convertir a mill"));
         km = km/1.609;
         JOptionPane.showMessageDialog(null, "La conversion es "+ km +" millas");
       break;
       
        case "b":
          mill = Double.parseDouble(JOptionPane.showInputDialog("INgresa la cantidad de mill que deseas convertir a km"));
         mill = mill*1.609;
         JOptionPane.showMessageDialog(null, "La conversion es "+ mill +" km");
       break;
       
        case "c":
          kg = Double.parseDouble(JOptionPane.showInputDialog("INgresa la cantidad de kg que deseas convertir a lbs"));
         kg = kg*2.2;
         JOptionPane.showMessageDialog(null, "La conversion es "+ kg +" lbs");
       break;
       
        case "d":
        lbs = Double.parseDouble(JOptionPane.showInputDialog("INgresa la cantidad de lbs que deseas convertir a kg"));
        lbs = lbs/2.2;
        JOptionPane.showMessageDialog(null, "La conversion es "+ lbs +" lbs");
       break;
       
        default:
            JOptionPane.showMessageDialog(null, "La letra ingresada no es una opcion dispoible");
            
        
    }
    }
    
}