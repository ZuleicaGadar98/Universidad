/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gadar
*/

public class Estudiante  {
    private String nombre, matricula, carrera, nacimiento;
    private int calificaciones, escuela;
    public Materia materia;
    public double nparciales;
    private double pa1, pa2, pa3,promedio, proyecto;
    
    public Estudiante(String m, String n, String c, int e, String na ) {
        
        matricula = m;
        nombre = n;
        carrera = c;
        materia = new Materia(6, "Cominicion"); 
        escuela=e;
        nacimiento=na;
         
    }
    
        public Estudiante(double pa1, double pa2, double p3, 
                double proyecto, double nparciales, double prom) {
        
        pa1=pa1;
        pa2=pa2;
        pa3=pa3;
        proyecto=proyecto;
        nparciales=nparciales;
        promedio=prom;
    }
    
    public Estudiante() {
        
        nparciales = 3;
        nparciales = 4;
        pa1=0;
        pa2=0;
        pa3=0;
        proyecto=0;
        promedio=0;
    }
    
   
    public void setNombre(String n) {
        this.nombre = n;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setCarrera(String c) {
        this.carrera = c;
    }
    
    public String getCarrera() {
        return carrera;
    }

    public void setMatricula(String ma) {
        this.matricula = ma;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setCalificaciones(int ca) {
        this.calificaciones = ca;
    }
        
    public int getCalificaciones() {
        return calificaciones;
    }

    public void setEscuela(int e) {
        this.escuela=e;
    }  
    
    public int getEscuela() {
        return escuela;
    }

    public void setNacimieto(String na) {
        this.nacimiento=na;
    }    
    
     public String getNacimiento() {
        return nacimiento;
    }
     public void setParcial1(double pa1) {
        this.pa1 = pa1;
    }

    public double getParcial1() {
        return pa1;
    }
 
    public void setParcial2(double pa2) {
        this.pa2 = pa2;
    }

    public double getParcial2() {
        return pa2;
    }

    public void setParcial3(double pa3) {
        this.pa3 = pa3;
    }  
    
    public double getParcial3() {
        return pa3;
    }
    
    public void setProyecto(double proyecto) {
        this.proyecto = proyecto;
    }
    
    public double getProyecto() {
        return proyecto;
    } 
    
     public void setPromedio(double prom) {
        this.promedio = prom;
    }
    
     public double getPromedio() {
        promedio = (pa1+pa2+pa3+proyecto)/nparciales;
        return promedio;
    }
    
     //Método para saber si reprobaron o no
     public String reprobados () 
    {
        System.out.println(getPromedio());
       if (getPromedio()>70)
    {
        
       System.out.println("Vuela, se libre por ahora...");
    }
     else 
       {
        System.out.println( "Ni modo chama, te tocó hacer");
       }
     return " ";
     
    }
    
    public String ToString() {
         setPromedio((pa1 + pa2 + pa3 + proyecto)/nparciales);
        return  this.matricula + "          " + this.nombre  + "             "  +
                this.escuela   + "   "        + this.carrera + "              " + 
                this.nacimiento+ "          " + this.pa1     + "    "           + 
                this.pa2       + "    "       + this.pa3     + "    "           +
                this.proyecto  + "    "       + this.getPromedio() + "    ";
    }
}
