/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author Leonardo
 */
public class NodoDoble<T> {
    private T item;
    private NodoDoble<T> antNodo;
    private NodoDoble<T> sgteNodo;

    public NodoDoble() {
        this.antNodo = null;
        this.item = null;
        this.sgteNodo = null;
    }

    public NodoDoble(T item) {
        this.item = item;
        this.antNodo = null;
        this.sgteNodo = null;
    }
       
    public NodoDoble(T item, NodoDoble<T> antNodo, NodoDoble<T> sgteNodo) {
        this.item = item;
        this.antNodo = antNodo;
        this.sgteNodo = sgteNodo;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public NodoDoble<T> getAntNodo() {
        return antNodo;
    }

    public void setAntNodo(NodoDoble<T> antNodo) {
        this.antNodo = antNodo;
    }

    public NodoDoble<T> getSgteNodo() {
        return sgteNodo;
    }

    public void setSgteNodo(NodoDoble<T> sgteNodo) {
        this.sgteNodo = sgteNodo;
    }
    
    
}
