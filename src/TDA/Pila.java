/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author Leonardo
 * @param <T>
 */
public class Pila<T> {
    private Nodo<T> cima;

    public Pila(Nodo<T> cima) {
        this.cima = cima;
    }
    
    public boolean esVacia(){
        return cima == null;
    }
    
    public void apilar(T item){
        Nodo<T> nuevoNodo = new Nodo(item, null);
        if (esVacia()) {
            cima = nuevoNodo;
        }
        else{
            nuevoNodo.setSgteNodo(nuevoNodo);
            cima = nuevoNodo;
        }
    }
    
    public T desapilar(){
        if (esVacia()) {
            throw new RuntimeException("La pila esta vacia");
        }
        else{
            T item = cima.getItem();
            cima = cima.getSgteNodo();
            return item;
        }
    }
}
