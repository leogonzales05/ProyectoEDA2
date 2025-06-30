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
public class ListaDobleEnlazada<T> {
    
    private NodoDoble<T> cabeza;
    private NodoDoble<T> ultimo;

    public ListaDobleEnlazada() {
        this.cabeza = null;
        this.ultimo = null;
    }

    public ListaDobleEnlazada(NodoDoble<T> cabeza, NodoDoble<T> ultimo) {
        this.cabeza = cabeza;
        this.ultimo = ultimo;
    }
    
    public boolean esVacia(){
        return cabeza == null;
    }

    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }
    
    public void agregarInicio(T item){
        NodoDoble<T> nuevoNodo = new NodoDoble(item);
        
        if (esVacia()){
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }
        else{
            nuevoNodo.setSgteNodo(cabeza);
            cabeza.setAntNodo(nuevoNodo);
            cabeza = nuevoNodo;
        }
    }
    
    public void agregarAntes(T item, T valorRef){
        if (esVacia()) {
            System.out.println("Lista vacia, no se puede agregar");
        }
        else{
            NodoDoble<T> aux = cabeza;
            while(aux != null && aux.getItem() != valorRef){
                aux = aux.getSgteNodo();
            }
            NodoDoble<T> nuevoNodo = new NodoDoble(item);
            
            if (aux != null) {
                if (aux.getAntNodo() != null) {
                    NodoDoble <T> tmp = aux.getAntNodo();
                    tmp.setSgteNodo(nuevoNodo);
                    aux.setAntNodo(nuevoNodo);
                    nuevoNodo.setSgteNodo(aux);
                    nuevoNodo.setAntNodo(tmp);
                }
                else{
                    agregarInicio(item);
                }
            }
            else{
                System.out.println("No se encontro el valor de referencia");
            }
        }
    }
    
    public void agregarFinal(T item){
        NodoDoble<T> nuevoNodo = new NodoDoble(item);
        if (esVacia()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        }
        else{
            nuevoNodo.setAntNodo(ultimo);
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    
    public void mostrarAdelante(){
        NodoDoble<T> aux = cabeza;
        while(aux != null){
            System.out.println(aux.getItem()+"-->");
            aux = aux.getSgteNodo();
        }
        System.out.println("null");
    }
    
    public void mostarAtras(){
        NodoDoble<T> aux = ultimo;
        while(aux != null){
            System.out.println(aux.getItem()+"<--");
            aux = aux.getAntNodo();
        }
        System.out.println("null");
    }
    
    public int longitud(){
        int count = 0;
        if (!esVacia()) {
            NodoDoble<T> aux = cabeza;
            while(aux != null){
                count++;
                aux = aux.getSgteNodo();
            }
        }
        return count;
    }
    
    public int ubicacion(T item){
        int pos = 1;
        NodoDoble<T> aux = cabeza;
        while(aux!=null){
            if (aux.getItem().equals(item)) {
                return pos;
            }
            aux= aux.getSgteNodo();
            pos++;
        }
        return -1; 
    }
    
    public T iesimo(int pos){
        if (pos >= 1 && pos<= longitud()) {
            int i = 1;
            NodoDoble<T> aux = cabeza;
            while(i < pos){
                i++;
                aux = aux.getSgteNodo();
            }
            return aux.getItem();
        }
        else{
            return null;
        }
    }
    
    public void eliminar(T item){
        if (esVacia()) {
            System.out.println("La lista esta vacia.");
        }
        else{
            NodoDoble<T> aux = cabeza;
            while(aux != null && !aux.getItem().equals(item)){
                aux = aux.getSgteNodo();
            }
            if (aux != null) {
                if (aux == cabeza) {
                    cabeza = aux.getSgteNodo();
                    cabeza.setAntNodo(null);
                }
                else if(aux == ultimo){
                    ultimo = aux.getAntNodo();
                    ultimo.setSgteNodo(null);
                }
                else{
                    NodoDoble<T> aux2 = aux.getAntNodo();
                    aux2.setSgteNodo(aux.getSgteNodo());
                    aux.getSgteNodo().setAntNodo(aux2);
                }
            }
        }
    }
}
