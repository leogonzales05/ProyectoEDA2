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
public class Nodo<T> {
    private T item;
    private Nodo<T> sgteNodo;

    public Nodo(T item, Nodo<T> sgteNodo) {
        this.item = item;
        this.sgteNodo = sgteNodo;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Nodo<T> getSgteNodo() {
        return sgteNodo;
    }

    public void setSgteNodo(Nodo<T> sgteNodo) {
        this.sgteNodo = sgteNodo;
    }
    
    
}
