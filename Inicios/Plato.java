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
public class Plato {
    
    private int id;
    private String color;
    
    public Plato(int i, String c){
        id=i;
        color=c;
    }
    
    public void setId(int i){
        id=i;
    }
    public void setColor(String c){
        color=c;
    }
    public int getId(){
        return id;
    }
    public String getColor(){
        return color;
    }
    
    public String toString(){
        return "Id: "+id+" Color:"+ color;
    }
    
}
