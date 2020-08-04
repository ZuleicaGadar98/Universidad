/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gadar
 */
public class Inventario 

{

    //Atributos necesarios
    private int vino, almacen;
    private double precio;
    
    //Sets y Gets
    
    public void setVino(int v)
    {
    
        vino=v;
        setAlmacen(100);
        setPrecio(100);
     
    }
    
    public int getVino()
    {
        return vino;
    }

   public void setAlmacen (int a)
   
    {
        almacen=a;   
    }
   
   public int getAlmacen()
    
    {
   
        return almacen;
    }
    
    public void setPrecio (double p)
    
    {
        precio=p;
    }
    
    public double getPrecio()
    
    {
        return precio;
    }
    
   ///Acciones
    
    public String cobrar(int pre, int co, int cos2, int v)
    {
            if (pre==600)
                {
                  co=1;
                }
            else
                {
                  cos2=2;
                }
                
           if (getPrecio()>=co)
           {
               setPrecio(getPrecio()-co);
               return "Costo de familia " + "$ " + v;
           }
           
           else 
           {
            return "Costo normal" + "$ " + v;  
           }
           
    
    }
    public String datosdelInventario ()
    {
        return "El vino es: " + getVino() + 
                " con un precio de: " + getPrecio() + " y en existencia hay: " + 
                getAlmacen();
    }

    void setVino(int v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean consultarPrecio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void pagarPrecio(double p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

