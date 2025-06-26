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
public class Administrador {
    private String usuario;
    private String contraseña;
    private ListaDobleEnlazada<Expediente> expedientes;
    private Cola<Expediente> colaAtencion;
    private Pila<String> pilaHistorialAcciones;
    
}
