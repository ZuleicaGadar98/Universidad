/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad3;

/**
 *
 * @author 
 */
public class Nodo {
    private Plato dato;
    private Nodo sig;

    public Nodo(Plato d, Nodo s){
        dato=d;
        sig=s;
    }
    public Nodo(Plato d){
        dato=d;
    }
    public void setSig(Nodo s){
        sig=s;
    }
    public void setDato(Plato d){
        dato=d; 
    }
    public Nodo getSig(){
        return sig;
    }
    public Plato getDato(){
        return dato;
    }
  
    
}
