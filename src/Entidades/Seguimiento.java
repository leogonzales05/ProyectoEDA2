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
    private Fecha fechaHoraMovimiento;

    public Seguimiento(String dependenciaOrigen, String dependenciaDestino, Fecha fechaHoraMovimiento) {
        this.dependenciaOrigen = dependenciaOrigen;
        this.dependenciaDestino = dependenciaDestino;
        this.fechaHoraMovimiento = fechaHoraMovimiento;
    }

    public String getDependenciaOrigen() {
        return dependenciaOrigen;
    }

    public void setDependenciaOrigen(String dependenciaOrigen) {
        this.dependenciaOrigen = dependenciaOrigen;
    }

    public String getDependenciaDestino() {
        return dependenciaDestino;
    }

    public void setDependenciaDestino(String dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    public Fecha getFechaHoraMovimiento() {
        return fechaHoraMovimiento;
    }

    public void setFechaHoraMovimiento(Fecha fechaHoraMovimiento) {
        this.fechaHoraMovimiento = fechaHoraMovimiento;
    }
    
    
}
