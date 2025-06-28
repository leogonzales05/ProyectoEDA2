/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import TDA.*;

/**
 *
 * @author Leonardo
 */
public class Programa {
    private ListaDobleEnlazada<Expediente> expedientes;
    private Cola<Expediente> colaAtencion;
    private Pila<String> pilaHistorialAcciones;

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

    public Pila<String> getPilaHistorialAcciones() {
        return pilaHistorialAcciones;
    }

    public void setPilaHistorialAcciones(Pila<String> pilaHistorialAcciones) {
        this.pilaHistorialAcciones = pilaHistorialAcciones;
    }
    
}
