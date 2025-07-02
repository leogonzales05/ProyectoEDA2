/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Leonardo
 */
public class Seguimiento {
    private String dependenciaOrigen;
    private String dependenciaDestino;
    private Fecha fechaInicio;
    private Fecha fechaFin;

    public Seguimiento(String dependenciaOrigen, String dependenciaDestino, Fecha fechaInicio, Fecha fechaFin) {
        this.dependenciaOrigen = dependenciaOrigen;
        this.dependenciaDestino = dependenciaDestino;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getDependenciaOrigen() {
        return dependenciaOrigen;
    }

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }
       
}
