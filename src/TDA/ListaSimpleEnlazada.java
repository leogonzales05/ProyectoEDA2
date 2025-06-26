/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TDA;

/**
 *
 * @author Leonardo
 */
public class ListaSimpleEnlazada<T> {
    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    
    public ListaSimpleEnlazada() {
        cabeza = null;
        ultimo = null;
    }
    
    public boolean esVacia() {
        return cabeza == null;
    }
    
    public void agregar(T item) {
        // crear un nuevo nodo
        Nodo<T> nuevoNodo = new Nodo(item, null);
        // Caso 1: cuando lisa esta vacia
        if (esVacia() == true) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            // Caso 2: la lista tiene elementos
            /*Nodo aux = cabeza;
            while(aux.getSgteNodo()!=null){
                aux = aux.getSgteNodo();
            }
            aux.setSgteNodo(nuevoNodo);
             */
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    
    public void mostrar() {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            System.out.print(aux.getItem() + "\t");
            aux = aux.getSgteNodo();
        }
    }

    public int longitud() {
        if (esVacia()) {
            return 0;
        } else {
            Nodo<T> aux = cabeza;
            int i = 0;
            while (aux != null) {
                aux = aux.getSgteNodo();
                i++;
            }
            return i;
        }
    }
    
    public T iesimo(int pos) {
        if (pos >= 1 && pos <= longitud()) {
            Nodo<T> aux = cabeza;
            int i = 1;
            while (i < pos) {
                aux = aux.getSgteNodo();
                i++;
            }
            return aux.getItem();
        } else {
            return null;
        }
    }
    
    public int ubicacion(T item) {
        if (esVacia()) {
            return -1;
        } else {
            int i = 1;
            Nodo<T> aux = cabeza;
            while (aux != null) {
                if (aux.getItem().equals(item) ) {
                    return i;
                }
                aux = aux.getSgteNodo();
                i++;
            }
            return -1;
        }
    }
    
    public void insertar(T item, int pos) {
        if (pos >= 1 && pos <= longitud()) {
            // Crear un nuevo nodo
            Nodo<T> nuevoNodo = new Nodo(item, null);

            // Caso 1: añadir en la posicion 1
            if (pos == 1) {
                nuevoNodo.setSgteNodo(cabeza);
                cabeza = nuevoNodo;
            } else if (pos > 1) {
                Nodo<T> aux = cabeza;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getSgteNodo();
                    i++;
                }
                nuevoNodo.setSgteNodo(aux.getSgteNodo());
                aux.setSgteNodo(nuevoNodo);
            }
        } else {
            System.out.println("La posicion no es valida!!!");
        }
    }
    
    public void eliminar(int pos) {
        if (pos >= 1 && pos <= longitud()) {
            if (pos == 1) {
                cabeza = cabeza.getSgteNodo();
            } else {
                int i = 1;
                Nodo<T> aux = cabeza;
                while (i < pos - 1) {
                    aux = aux.getSgteNodo();
                    i++;
                }
                if (pos != longitud()) {
                    Nodo<T> aux2 = aux.getSgteNodo();
                    aux.setSgteNodo(aux2.getSgteNodo());
                }else if (pos==longitud()){
                    ultimo = aux;
                    aux.setSgteNodo(null);
                }
            }
        } else {
            System.out.println("Posicion no valida o lista vacia");
        }
    }
}
