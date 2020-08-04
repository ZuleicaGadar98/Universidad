/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tamagotchi;

/**
 *
 * @author Marco Campos
 */
public class ColaDeImpresion2 {

    public static void main(String arg[]) {
        ColaDeImpresion2 c = new ColaDeImpresion2();
        System.out.println("--------------------------------------");
        System.out.println("Pregunto si la cola esta vacia");
        c.vacia();
        Tarea tarea1 = new Tarea("file1", 1);
        Tarea tarea2 = new Tarea("file2", 2);
        Tarea tarea3 = new Tarea("file3", 2);
        Tarea tarea4 = new Tarea("file4", 1);
        Tarea tarea5 = new Tarea("file5", 3);
        System.out.println("--------------------------------------");
        System.out.println("AQUI IMPRIMO EL PRIMER VALOR");
               c.agregar(tarea5);
        c.agregar(tarea4);
        c.agregar(tarea3);
        c.agregar(tarea2);
        c.agregar(tarea1);
        c.primero();
        System.out.println("--------------------------------------");
        System.out.println("AQUI IMPRIMO");
        c.imprimir();
        System.out.println("--------------------------------------");
        System.out.println("AQUI IMPRIMO AL REVES");
        System.out.println("");

        c.alreves();

        System.out.println("--------------------------------------");
        System.out.println("AQUI ELIMINO");
        c.eliminar();
        c.imprimir();
        System.out.println("--------------------------------------");
        System.out.println("AQUI IMPRIMO AL REVES");
        System.out.println("");
        c.alreves();
        System.out.println("--------------------------------------");
        System.out.println("vuelvo a preguntar si la cola esta vacia");
        c.vacia();
    }
    private Nodo inicio, ultimo;

    public void agregar(Tarea tarea) {
        Nodo nodo = new Nodo(tarea);
        Nodo aux, aux2;
        boolean ctrl = false;

        if (inicio == null) {
            nodo.setAnterior(nodo);
            nodo.setSig(nodo);
            inicio = nodo;
            ultimo = inicio;
        } else if (tarea.getPrioridad() <= inicio.getTarea().getPrioridad()) {
            inicio.setAnterior(nodo);
            nodo.setAnterior(ultimo);
            ultimo.setSig(nodo);
            nodo.setSig(inicio);
            inicio = nodo;
        } else if (tarea.getPrioridad() >= ultimo.getTarea().getPrioridad()) {
            inicio.setAnterior(nodo);
            nodo.setAnterior(ultimo);
            ultimo.setSig(nodo);
            nodo.setSig(inicio);
            ultimo = nodo;
        } else {

            aux = inicio;
            aux2 = inicio.getSig();
            while (aux2 != null) {
                if (tarea.getPrioridad() >= aux.getTarea().getPrioridad() && tarea.getPrioridad() <= aux2.getTarea().getPrioridad()) {
                    nodo.setSig(aux2);
                    aux.setSig(nodo);
                    nodo.setAnterior(aux);
                    aux2.setAnterior(nodo);
                    ctrl = true;
                    break;
                } else {
                    aux = aux2;
                    aux2 = aux2.getSig();
                }
            }
            if (ctrl == false) {
                nodo.setAnterior(aux);
                aux.setSig(nodo);
            }
        }
    }

    public void eliminar() {
        inicio.getSig().setAnterior(inicio.getAnterior());
        inicio.getAnterior().setSig(inicio.getSig());
        inicio = inicio.getSig();
    }

    public void imprimir() {

        Nodo aux = inicio;
        do {
            System.out.println(aux.getTarea());

            aux = aux.getSig();
        } while (aux != inicio);
    }

    public void alreves() {

        Nodo aux = ultimo;

        do {
            System.out.println(aux.getTarea());

            aux = aux.getAnterior();
        } while (aux != ultimo);

    }
    public void primero(){
        System.out.println(inicio.getTarea());
    }
    public void vacia(){
        if(inicio==null){
            System.out.println("La cola esta vacia");
        }
        else{
        System.out.println("La cola tiene datos");
        }
    }
}
