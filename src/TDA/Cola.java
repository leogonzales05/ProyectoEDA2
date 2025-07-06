/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

import Entidades.Expediente;

/**
 *
 * @author Leonardo
 * @param <T>
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> ultimo;
    
    public Cola(){
        frente = null;
        ultimo = null;
    }
    
    public boolean esVacia(){
        return frente == null;
    }
    
    public void encolar(T item){
        Nodo<T> nuevoNodo = new Nodo(item, null);
        if (esVacia()) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        }
        else{
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    
    public T desencolar(){
        if (esVacia()) {
            throw new RuntimeException("La cola esta vacia!");
        }
        else{
            T itemAux = frente.getItem();
            frente = frente.getSgteNodo();
            return itemAux;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void eliminarExpediente(String id) {
        Cola<T> temp = new Cola<>();
        boolean encontrado = false;
        
        while (!this.esVacia()) {
            T item = this.desencolar();
            if (item instanceof Expediente exp) {
                if (!String.valueOf(exp.getIdExpediente()).equals(id)) {
                    temp.encolar(item);
                } else {
                    encontrado = true;
                }
            } else {
                temp.encolar(item);
            }
        }
        
        while (!temp.esVacia()) this.encolar(temp.desencolar());
        
        if (!encontrado) {
            throw new RuntimeException("Expediente no encontrado");
    
    
    
    
    
        }
}
}
