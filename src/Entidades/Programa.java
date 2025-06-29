/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import TDA.*;
import java.util.Random;

/**
 *
 * @author Leonardo
 */
public class Programa {
    private ListaDobleEnlazada<Expediente> expedientes;
    private Cola<Expediente> colaAtencion;
    private Pila<Documento> pilaHistorialAcciones;
    static Random rand = new Random();
    
    public Programa() {
        this.expedientes = new ListaDobleEnlazada<>();
        this.colaAtencion = new Cola<>();
        this.pilaHistorialAcciones = new Pila<>();
    }

    public ListaDobleEnlazada<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(ListaDobleEnlazada<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public Cola<Expediente> getColaAtencion() {
        return colaAtencion;
    }

    public void setColaAtencion(Cola<Expediente> colaAtencion) {
        this.colaAtencion = colaAtencion;
    }

    public Pila<Documento> getPilaHistorialAcciones() {
        return pilaHistorialAcciones;
    }

    public void setPilaHistorialAcciones(Pila<Documento> pilaHistorialAcciones) {
        this.pilaHistorialAcciones = pilaHistorialAcciones;
    }
    
    public void registrarExpediente(int prioridad, 
            Interesado interesado, String asunto, 
            String documentoRef, Fecha fechaIni, 
            ListaSimpleEnlazada<Seguimiento> seguimiento, 
            ListaSimpleEnlazada<Documento> documentosResultado){
        int id = rand.nextInt(99999999 - 10000000 + 1) + 10000000;    
        while(!expedientes.esVacia()){
            NodoDoble<Expediente> aux = expedientes.getCabeza();
            if (aux.getItem().getIdExpediente() == id) {
                id = rand.nextInt(99999999 - 10000000 + 1) + 10000000;    
            }
            if (aux.getItem().getInteresado().getDni() == interesado.getDni()) {
                interesado.setEmail(aux.getItem().getInteresado().getEmail());
                interesado.setNombre(aux.getItem().getInteresado().getNombre());
                interesado.setTelefono(aux.getItem().getInteresado().getTelefono());
                interesado.setTipo(aux.getItem().getInteresado().getTipo());
            }
        }
        Expediente exp = new Expediente (id,prioridad,interesado,asunto,documentoRef, seguimiento, documentosResultado);
        expedientes.agregarFinal(exp);
    }
    
}
