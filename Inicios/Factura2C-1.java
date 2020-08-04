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
public class Factura2C {
    private int noFactura;
    private double monto;
    private String fecha, cliente;
    private Producto productos[];
    //constructor
    public Factura2C(int n, String f, String c, int cProd)
    {
        noFactura = n;
        cliente = c;
        productos = new Producto[cProd];
        fecha = f;
    }
//Los elementos de una clase son las variables y los métodos de la clase
    public void setNumero(int n)
    {
        noFactura = n;
    }
    public int getNumero()
    {
        return noFactura;
    }
    
    public void setMonto(double m)
    {
        monto = m;
    }
    public double getMonto()
    {
        return monto;
    }
    
    public void setFecha(String f)
    {
        fecha = f;
    }
    public String getFecha()
    {
        return fecha;
    }
    
    public void setCliente(String c)
    {
        cliente = c;
    }
    public String getCliente()
    {
        return cliente;
    }
    
    public void realizarCompra()
    {
        String numero, descripcion;
        double precio;
        int cantidad;
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < productos.length; i++)
        {
            System.out.println("Numero de producto");
            numero = input.next();
            System.out.println("Descripcion del producto");
            descripcion = input.next();
            System.out.println("Precio de producto");
            precio = input.nextDouble();
            System.out.println("Cantidad del producto");
            cantidad = input.nextInt();
            Producto articulo = new Producto(numero, descripcion, precio, cantidad);
            productos[i] = articulo;
        }
    }
    
    public String datosFactura()
    {
        return "No. Factura " + getNumero() + "   " + getFecha() + "\nNo. Cliente" + getCliente();
    }
    
    public void datosProductos()
    {
        for(int i=0; i < productos.length; i++)
        {
            System.out.println(productos[i]);
            double venta = (productos[i].getCantidad()*productos[i].getPrecio());
            System.out.printf("   $%.2f", venta);
            setMonto(getMonto() + venta);
        }
    }
    
    public String toString()
    {    
        datosFactura();
        datosProductos();
        return "\n\nLa venta es de ";
    }
    
    
}
