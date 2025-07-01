/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import TDA.*;
import java.util.Random;
import TDA.ListaDobleEnlazada;
/**
 *
 * @author Leonardo
 */
public class Programa {
    public static ListaDobleEnlazada<Expediente> expedientes = new ListaDobleEnlazada<>();
    public static Cola<Expediente> colaAtencion;
    public static Pila<Documento> pilaHistorialAcciones;
    static Random rand = new Random();
    public static ListaDobleEnlazada<Dependencia> listaDependencias;
    

    public ListaDobleEnlazada<Expediente> getExpedientes() {
        return expedientes;
    }


    public Cola<Expediente> getColaAtencion() {
        return colaAtencion;
    }


    public Pila<Documento> getPilaHistorialAcciones() {
        return pilaHistorialAcciones;
    }
    
   public static int registrarExpediente(int prioridad, 
            Interesado interesado, String asunto, 
            String documentoRef){
        int id = rand.nextInt(99999999 - 10000000 + 1) + 10000000;    
        NodoDoble<Expediente> aux = expedientes.getCabeza();
        while( aux != null){
            if (aux.getItem().getIdExpediente() == id) {
                id = rand.nextInt(99999999 - 10000000 + 1) + 10000000;    
            }
            if (aux.getItem().getInteresado().getDni() == interesado.getDni()) {
                Interesado yaRegistrado = aux.getItem().getInteresado();
                interesado.setEmail(yaRegistrado.getEmail());
                interesado.setNombres(yaRegistrado.getNombres());
                interesado.setApellidos(yaRegistrado.getApellidos());
                interesado.setTelefono(yaRegistrado.getTelefono());
                interesado.setTipo(yaRegistrado.getTipo());
            }
            aux = aux.getSgteNodo();
        }
        
        Expediente exp = new Expediente (id,prioridad,interesado,asunto,documentoRef);
        expedientes.agregarFinal(exp);
        return id;
        
    }
    
    public static void registrarDependencia(String nombre){
        
    Dependencia dependencia= new Dependencia(nombre);
    listaDependencias.agregarFinal(dependencia);
    
    }
    
    public static Expediente BuscarExp(int id){
        NodoDoble<Expediente> aux = expedientes.getCabeza();
        
        while(aux != null){
            if(aux.getItem().getIdExpediente() == id){
                return aux.getItem();
            }
            aux = aux.getSgteNodo();
        }
        
        return null;
} 
    
    
}
