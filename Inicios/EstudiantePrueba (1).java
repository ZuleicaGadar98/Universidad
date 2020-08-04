/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gadar
 */
import java.util.Scanner;
public class EstudiantePrueba {
    
    public static void main(String args[]) {
        
        Scanner input = new Scanner(System.in);
        
        //Declaración de variables/Inicialización de variables
        boolean ing;
        
        int no, prom, p, e, suma=0, proyecto, nparciales;
        int testudiantes;
        int info=2;
        double pa1,pa2,pa3;  
        double total, promedio;
        String m, n, c, na;
        prom=0; total=0;
        pa1=0; pa2=0; pa3=0; proyecto=0; nparciales=0; promedio=0;
        
        
      //Inicio del programa
        System.out.println("¿Cuántos estudiantes estan inscritos en el grupo?");
        testudiantes =input.nextInt();
        input.nextLine();
        
        //ARREGLO ESTUDIANTES
        Estudiante estudiantes[] = new Estudiante[testudiantes];
        
     
        System.out.println("\nIngrese los datos de los estudiantes por fi");
        
        //For
        for(int i = 0; i < estudiantes.length; i++) {
            
            System.out.println("Fecha de nacimiento(Ej: 06 SEP 99): ");
            na = input.nextLine();
            
            System.out.println("Escuela (Ing.= 1  Lic.= 2): ");
            e = input.nextInt();
             input.nextLine();
        
            System.out.println("Matricula: ");
            m = input.nextLine();
            
            System.out.println("Nombre y Apellido: ");
            n = input.nextLine();
            
            System.out.println("Carrera (Ej: ISW, IDGD, LNI):  ");
            c = input.nextLine();
        
            //LO QUE RECIBE EL ARREGLO DEL CONSTRUCTOR
            estudiantes[i] = new Estudiante(m, n, c, e, na);
                      
            //IF/ELSE
            if (e == 1) {
                ing = true;
                
                pa1 = (int)(Math.random()*50) + 50;
                pa2 = (int)(Math.random()*50) + 50;
                pa3 = (int)(Math.random()*50) + 50; 
                proyecto = (int)(Math.random()*50) + 50;
                
                estudiantes[i].setParcial1(pa1);
                estudiantes[i].setParcial2(pa2);
                estudiantes[i].setParcial3(pa3);
                estudiantes[i].setProyecto(proyecto);
                estudiantes[i].nparciales = 4; 
            }
            else {
                ing = false;
                
                pa1 = (int)(Math.random()*50) + 50;
                pa2 = (int)(Math.random()*50) + 50;
                pa3 = (int)(Math.random()*50) + 50;
                
                 estudiantes[i].setParcial1(pa1);
                 estudiantes[i].setParcial2(pa2);
                 estudiantes[i].setParcial3(pa3);
                 estudiantes[i].nparciales = 3; 
            }
                          
            //input.nextLine();
            
        }
  
        System.out.println("\n********** REGISTRO DE CALIFICACIONES DE LA MATERIA DE COMUNICACIÓN **********");
        System.out.println("********** Clave de la Materia: HHU001  **********");
        System.out.println("********** Maestro: Cecilia Luhrs **********");
        System.out.println("********** Clave del maestro: HHU001-91 **********");
        System.out.println("********** Límite de faltas: 12 **********");
        
         System.out.println("\nFECHA DE NACIMIENTO         ESCUELA        MATRICULA            NOMBRE                  CARRERA           1ER PARCIAL        2DO PARCIAL       3ER PARCIAL         PROYECTO             PROMEDIO");
      
        //Formato
        for(int i=0; i<estudiantes.length; i++) {
                           
        String output = String.format
        //"FECHA DE NACIMIENTO   ESCUELA       MATRICULA     NOMBRE         CARRERA     1ER PARCIAL     2DO PARCIAL     3ER PARCIAL     PROYECTO        PROMEDIO"
        ( "%s                     %d              %s             %s              %s                  %.2f              %.2f              %.2f              %.2f              %.2f",
        
        //Llamando a la clase Estudiante
        estudiantes[i].getNacimiento(),
        estudiantes[i].getEscuela(),
        estudiantes[i].getMatricula(), 
        estudiantes[i].getNombre(),
        estudiantes[i].getCarrera(),
        
        
        //LLamada de calificaciones
        estudiantes[i].getParcial1(), 
        estudiantes[i].getParcial2(),
        estudiantes[i].getParcial3(), 
        estudiantes[i].getProyecto(),
        estudiantes[i].getPromedio()
        );
         System.out.println(output);
         System.out.println(estudiantes[i].reprobados());
         total+=estudiantes[i].getPromedio();
        }
       
       
        System.out.printf("\n\n *************** PROMEDIO GENERAL %.2f ***************************",total/testudiantes);
        
        
            
        
    }
}
