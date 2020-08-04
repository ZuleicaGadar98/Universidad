/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gadar
 */

import java.util.Scanner;
public class PruebaInventario {
    
    public static void main (String arg[])
    {
        Scanner entrada = new Scanner (System.in);
        int resp, v, g;
        double p;
           Inventario mivino=new Inventario ();
                System.out.println("\n Bienvenido a tu inventario");
        
            do 
            {
                System.out.println("\n 1. Ingresar el nombre dle vino");
                System.out.println("\n 2. Consultar Precio");
                System.out.println("\n 3. Pagar el vino");
                System.out.println("\n 4. Datos del vino");
                System.out.println("\n 5. Salir");
                System.out.println("\n ¿Qué desea consultar?");
                resp=entrada.nextInt();
                
                //Menú
                
                switch (resp)
                {
                    case 1:
                        System.out.println("Escriba el nombre del vino");
                        v=entrada.nextInt();
                        
                        mivino.setVino(v);
                        break;
                        
                    case 2: 
                        System.out.println(mivino.consultarPrecio());
                        break;
                        
                    case 3:
                        System.out.println ("¿Con cuánto va  pagar?");
                        p=entrada.nextDouble();
                        mivino.pagarPrecio(p);
                        break;
                     
                    case 4: 
                        System.out.println(mivino.datosdelInventario());
                        break;
                        
                    case 5: 
                        System.out.println("Nos vemos desoues...");
                        
                    default:
                        System.out.println("Opción invalido");

                }
            }while (resp<5);
    }
    
}
