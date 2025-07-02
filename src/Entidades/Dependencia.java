/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Lenovo
 */
import TDA.*;
public class Dependencia {
    private String nombre;
    private Cola colaAlta;
    private Cola colaMedia;
    private Cola colaBaja;

    public Dependencia(String nombre) {
        this.nombre = nombre;
        this.colaAlta = new Cola();
        this.colaMedia = new Cola();
        this.colaBaja = new Cola();        
    }

    public String getNombre() {
        return nombre;
    }

    public Cola getColaAlta() {
        return colaAlta;
    }

    public Cola getColaMedia() {
        return colaMedia;
    }

    public Cola getColaBaja() {
        return colaBaja;
    }
    
}
