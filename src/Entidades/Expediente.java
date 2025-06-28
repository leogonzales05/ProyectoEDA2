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
public class Expediente {
    private int idExpediente;
    private int prioridad;
    private Interesado interesado;
    private String asunto;
    private Documento documentoRef;
    private Fecha fechaIni;
    private Fecha fechaFin;
    private ListaSimpleEnlazada<Seguimiento> listaSeguimiento;
    private ListaSimpleEnlazada<Documento> documentosResultado;

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Documento getDocumentoRef() {
        return documentoRef;
    }

    public void setDocumentoRef(Documento documentoRef) {
        this.documentoRef = documentoRef;
    }

    public Fecha getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Fecha fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public ListaSimpleEnlazada<Seguimiento> getListaSeguimiento() {
        return listaSeguimiento;
    }

    public void setListaSeguimiento(ListaSimpleEnlazada<Seguimiento> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }

    public ListaSimpleEnlazada<Documento> getDocumentosResultado() {
        return documentosResultado;
    }

    public void setDocumentosResultado(ListaSimpleEnlazada<Documento> documentosResultado) {
        this.documentosResultado = documentosResultado;
    }
    
    
}
