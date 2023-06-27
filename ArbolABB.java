/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoExamenEd2Arboles;

import Tarea6.ClaseArbol;

/**
 *
 * @author USER
 */
public class ArbolABB {

    public Nodo raiz;

    public ArbolABB() {
        raiz = null;
    }

    /*Insertar*/
    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo p, int elem) {
        if (p == null) {
            return new Nodo(elem);
        }
        if (elem < p.elem) {
            p.izq = insertar(p.izq, elem);
        } else {
            p.der = insertar(p.der, elem);
        }
        return p;
    }
    
    public void inOrden(){
        inOrden(raiz);
    }
    
    private void inOrden(Nodo p){
        if(p==null){
            return;
        }else{
            inOrden(p.izq);
            System.out.println(p.elem);
            inOrden(p.der);
        }
    }

    public boolean isHoja(Nodo p) {
        return (p.izq == null && p.der == null);
    }

    //Verifica si un elemento x, se encuentra en el arbol
    public boolean seEncuentra(int x) {
        return seEncuentra(raiz, x);
    }

    private boolean seEncuentra(Nodo p, int x) {
        if (p == null) {
            return false;
        }
        if (isHoja(p)) {
            return (x == p.elem);
        }
        boolean i = seEncuentra(p.izq, x);
        boolean d = seEncuentra(p.der, x);
        if(i == true || d == true){
            return true;
        }
        if(p.elem == x){
            return true; 
        }else{
            return false;
        }
    }
    
    //Me retorna la cantidad de Nodos de un arbol
    public int cantidadNodos(){
        return cantidadNodos(raiz);
    }
    
    private int cantidadNodos(Nodo p){
        if(p == null){
            return 0;
        }
        if(isHoja(p)){
            return 1;
        }
        int i = cantidadNodos(p.izq);
        int d = cantidadNodos(p.der);
        return i+d+1;
    }
    
    
    public int suma(){
        return suma(raiz);
    }
    
    private int suma(Nodo p ){
        if( p == null){
            return 0;
        }
        if(isHoja(p)){
            return p.elem;
        }
        int i = 0;
        int d = 0;
        i = i + suma(p.izq);
        d  = d +  suma(p.der);
        return i + d + p.elem;
    }
    
    //Obtenemos el menor Numero del Nodo, si esta vacio el arbol nos retorna -1
    public int ObtenerMenor(){
        return ObtenerMenor(raiz);
    }
    
    private int ObtenerMenor(Nodo p){
        if(p == null){
            //throw new IllegalStateException("El árbol está vacío");
            return -1;
        }
        if(isHoja(p)){
            return p.elem;
        }
        int i = ObtenerMenor(p.izq);
        return i;
    }
    
     //Obtenemos el mayor Numero del Nodo, si esta vacio el arbol nos retorna -1
    public int ObtenerMayor(){
        return ObtenerMayor(raiz);
    }
    
    private int ObtenerMayor(Nodo p){
        if(p == null){
            //throw new IllegalStateException("El árbol está vacío");
            return -1;
        }
        if(isHoja(p)){
            return p.elem;
        }
        int d = ObtenerMayor(p.der);
        return d;
    }
    
    
    public void mostrarNivel() {
        mostrarNivel(raiz, 1);
    }
    
    private void mostrarNivel(Nodo p,int nivel){
        if(p==null){
            return;
        }
        mostrarNivel(p.izq,nivel+1);
        System.out.println(p.elem + " nivel: " + nivel);
        mostrarNivel(p.der, nivel+1);
    }
    
    public static void main(String[] args) {
        ArbolABB a =  new ArbolABB();
        a.insertar(10);
        a.insertar(8);
        a.insertar(5);
        a.insertar(3);
        a.insertar(2);
        a.insertar(1);
        a.insertar(20);
        
        a.inOrden();
        System.out.println("Verificar si se encuentra el 10: " + a.seEncuentra(10));
        System.out.println("La cantidad de Nodos es: " + a.cantidadNodos());
        System.out.println("la suma de los Nodos es : " + a.suma());
        System.out.println("El menor dato del arbol es: " + a.ObtenerMenor());
        System.out.println("El mayor dato del arbol es: " + a.ObtenerMayor());
        System.out.println("Mostrar nivel:");
        a.mostrarNivel();
        
    }

}
