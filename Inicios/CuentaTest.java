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
import java.util.Scanner;
public class CuentaTest {
    public static void main(String[] args)
     {
         Cuenta cuenta1 = new Cuenta("Marco Campos", 50.00);
     
         Cuenta cuenta2 = new Cuenta("Francisco Avalos", -7.53); 
         System.out.printf("%s balance: $%.2f%n",
            cuenta1.getNombre(), cuenta1.getBalance());
         System.out.printf("%s balance: $%.2f%n%n",
            cuenta2.getNombre(), cuenta2.getBalance());
         Scanner input = new Scanner(System.in);

         System.out.print("Ingresa el deposito para la cuenta1: "); // prompt
         double depositoCuenta = input.nextDouble(); // obtain user input
         System.out.printf("%nadding %.2f para el balance de la cuenta1%n%n",
            depositoCuenta);
        cuenta1.deposito(depositoCuenta);
        System.out.printf("%s balance: $%.2f%n",
            cuenta1.getNombre(), cuenta1.getBalance());
         System.out.printf("%s balance: $%.2f%n%n",
            cuenta2.getNombre(), cuenta2.getBalance());
         System.out.print("Ingresa el deposito para la cuenta2: "); // prompt
         double depositoCuenta2 = input.nextDouble(); // obtain user input
         System.out.printf("%nadding %.2f para el balance de la cuenta2%n%n",
            depositoCuenta2);
         cuenta2.deposito(depositoCuenta2);
         System.out.printf("%s balance cuenta1: $%.2f%n",
            cuenta1.getNombre(), cuenta1.getBalance());
         System.out.printf("%s balance cuenta2: $%.2f%n%n",
            cuenta2.getNombre(), cuenta2.getBalance());
     }
    
    
}
