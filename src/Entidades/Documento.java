/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Leonardo
 */
public class Documento {
    private String nombre;
    private String descripcion;
    private String tipo;

    public Documento(String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContenido() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Documento{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
}
