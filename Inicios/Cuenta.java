/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad1;

/**
 *
 * @author Marco Campos
 */
public class Cuenta {
     private String nombre; 
     private double balance;
     public Cuenta(String nombre, double balance)
     {
        this.nombre = nombre;
        if (balance > 0.0){
            this.balance = balance;
        }
     }
     public void deposito(double depositoCuenta){
         if (depositoCuenta > 0.0){
              balance = balance + depositoCuenta;
         }
     }
     public double getBalance()           
     {                                    
      return balance;                   
     }  
     public void setNombre(String nombre){
         this.nombre = nombre;
     }
     public String getNombre(){
         return nombre;
     }
     
}
