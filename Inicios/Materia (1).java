/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gadar
 */
 public class Materia {
     
    private int numero, pa1, pa2, pa3, proyecto;
    private String nombre;
    
    public Estudiante parciales;
    
    
    public Materia(int no, String n, int p1, int p2, int p3, int p) {
        numero = no;
        nombre = n;
        pa1 = p1;
        pa2 = p2;
        pa3 = p3;
        proyecto = p;
    }
    
    public Materia(int no, String n) {
        numero = no;
        nombre = n;
        parciales = new Estudiante();
    }
    
    public Materia(int no, String n, int p1, int p2, int p3) {
        numero = no;
        nombre = n;
        pa1 = p1;
        pa2 = p2;
        pa3 = p3;
    }  
    
    public void setNumero(int no) {
        this.numero = no;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNombre(String n) {
        this.nombre = n;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String ToString() {
        return parciales.ToString();
    }
}
