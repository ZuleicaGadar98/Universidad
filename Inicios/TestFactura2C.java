/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author franciscojavieravalosperalta
 */
import java.util.Scanner;
public class TestFactura2C {
    public static void main(String arg[])
    {
        Scanner input = new Scanner(System.in);
        int noFactura, res, cant, ff;
        String fecha, cliente;
        Factura2C mifactura = new Factura2C(0, "null", "null", 0);
        
        System.out.println("Escriba el número de facturas a realizar");
        ff = input.nextInt();
        
        Factura2C facturas[] = new Factura2C[ff];
        
        do {
        System.out.println("Sistema de facturacion");
        System.out.println("\n\n1. Crear factura");
        System.out.println("\n2. Añadir producto");
        System.out.println("\n3. Facturar");
        System.out.println("\n4. Salir");
        System.out.println("\nElije una opcion");
        res = input.nextInt();
        
        switch(res)
        {
            case 1:
                for(int i=0;i<facturas.length;i++)
                {
                System.out.print("\nNo. Factura ");
                noFactura = input.nextInt();
                System.out.print("\nFecha de facturacion ");
                input.nextLine();
                fecha = input.nextLine();
                System.out.print("\nNombre del cliente ");
                input.nextLine();
                cliente = input.nextLine();
                System.out.print("\nCantidad de productos a facturar ");
                input.nextLine();
                cant = input.nextInt();
                mifactura = new Factura2C(noFactura, fecha, cliente, cant);
                facturas[i] = mifactura;
                }
                break;
            case 2:
                for(int i=0;i<facturas.length;i++)
                {
                facturas[i].realizarCompra();
                facturas[i].datosFactura();
                }
                break;
            case 3:
                for(int i=0;i<facturas.length;i++)
                {
                System.out.println(facturas[i]);
                }
                break;
            default:
                break;
        }
        
        }
        while (res < 4);
    }
    
}
