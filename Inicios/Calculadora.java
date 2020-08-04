/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tercersemestre;

import java.util.Scanner;

/**
 *
 * @author Marco Campos
 */
public class Calculadora {

    public String resolver (String operando, String uno, String dos){
        String resp = "";
        
            if (uno.length()< dos.length()){
                String temp=dos.substring(0, dos.length()-uno.length());
                temp=temp.replace('1', '0');
                temp=temp+uno;
                uno=temp;
            }
                else{
                    String temp=uno.substring(0, uno.length()-dos.length());
                    temp=temp.replace('1', '0');
                    temp=temp+dos;
                    dos=temp;
                }
            if (operando.equals("+")){
                resp=suma(uno, dos);
            }
            else if(operando.equals("-")){
                resp=resta(uno,dos);
            }
            
        return resp;    
    }
    
    public String suma(String uno, String dos) {
        String resp = "";
        char a = '0';
        for (int i = uno.length() - 1; i >= 0; i--) {
            if (uno.charAt(i) == '0' && dos.charAt(i) == '0') {
                if (a == '0') {
                    resp = "0" + resp;
                    System.out.println("if 1 "+resp);
                } else {
                    resp = "1" + resp;
                    System.out.println("else 1 "+resp);
                }
            } else if ((uno.charAt(i) == '0' && dos.charAt(i) == '1') || (uno.charAt(i) == '1' && dos.charAt(i) == '0')) {
                if (a == '0') {
                    resp = "1" + resp;
                    System.out.println("if 2 "+resp);
                } else {
                    a = '1';
                    resp = "0" + resp;
                    System.out.println("else 2 "+resp);
                }
            } else if (uno.charAt(i) == '1' && dos.charAt(i) == '1') {
                if (a == '0') {
                    a = '1';
                    resp = "0" + resp;
                    System.out.println("if 3 "+resp);
                } else if(uno.charAt(i) == '1' && dos.charAt(i) == '1'&& a=='1'){ 
                    a='1';
                    resp = "1" + resp;
                    System.out.println("else 3  "+resp);
                }
                else {
                    a='1';
                    resp = "0" + resp;
                }
            }
           
        }
        if (a == '1') {
            resp = a + resp;
            System.out.println("if 4 "+resp);
        }
        return resp;
    }

    public String resta(String uno, String dos) {
        char debo = '0';
        String resp = "";
        for (int i = uno.length() - 1; i >= 0; i--) {
            if ((uno.charAt(i) == '0' && debo == '0') || (uno.charAt(i) == '1' && debo == '1')) {
                if (dos.charAt(i) == '0') {
                    debo = '0';
                    resp = "0" + resp;
                } else {
                    debo = '1';
                    resp = "1" + resp;
                }
            } else if (uno.charAt(i) == '1' && debo == '0') {
                debo = '0';
                if (dos.charAt(i) == '0') {
                    resp = "1" + resp;
                } else {
                    resp = "0" + resp;
                }
            } else if (uno.charAt(i) == '0' && debo == '1') {
                debo = '1';
                if (dos.charAt(i) == '0') {
                    resp = "1" + resp;
                } else {
                    resp = "0" + resp;
                }
            }
        }
        if (debo == '1') {
            resp = "-" + resp;
        }
        return resp;
    }
    
    public static void main(String arg[]) {

        Calculadora calculadora = new Calculadora();
        Scanner input = new Scanner(System.in);
        
            while (input.hasNextLine()){
                String uno=input.nextLine();
                String operando=input.nextLine();
                String dos=input.nextLine();
                
                System.out.println(calculadora.resolver(operando, uno, dos));
            }
    }

    
}
