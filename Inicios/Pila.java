/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad3;

/**
 *
 * @author MGR#8955
 */
public class Pila {
    private Nodo inicio;
    
    public void agregarPlato(Plato p){
        Nodo nodo= new Nodo(p);
        
        if(inicio==null){
            inicio=nodo;
        }
        else{
            Nodo aux=inicio;            
            inicio=nodo;
            nodo.setSig(aux);
        }
    }
    public void retirarPlato(){
         Nodo aux=inicio;
        System.out.println(aux.getDato());
        Nodo n=aux.getSig();
         aux=null;
        inicio=n;
    }
    public void imprime(){ 
       
        Nodo aux=inicio;
        
        while(aux!=null){
        
            System.out.println(aux.getDato());
            aux=aux.getSig();
        }
    }
    
    public static void main(String arg[]){
        
        Pila p= new Pila();
        
        Plato plato1=new Plato(1,"n");
        //  p.agregarPlato(plato1);
        //  p.imprime();
        Plato plato2=new Plato(2,"w");
        //  p.agregarPlato(plato2);
        //  p.imprime();
        Plato plato3=new Plato(3,"s");
        //  p.agregarPlato(plato3);
        //  p.imprime();
        //  p.retirarPlato();
        //  p.imprime();
        
        
        
    }
}
