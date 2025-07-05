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
    private static int contadorId = 1;
    private int idExpediente;
    private int prioridad;
    private Interesado interesado;
    private String asunto;
    private Documento documentoReferencia;
    private Fecha fechaIni;
    private Fecha fechaFin;
    private ListaSimpleEnlazada<Seguimiento> listaSeguimiento;
    private Pila<Documento> documentosTramites;
    private String estado;
    
    public Expediente(int prioridad, Interesado interesado, String asunto, Documento documentoReferencia) {
        this.idExpediente = contadorId++;
        this.prioridad = prioridad;
        this.interesado = interesado;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.fechaIni = Fecha.Exacta();
        this.fechaFin = null;
        this.documentosTramites = new Pila<>();
        this.listaSeguimiento = new ListaSimpleEnlazada<>();
        this.estado = EstadoTramite.EN_PROCESO;
    }
    
    public int getIdExpediente() {
        return idExpediente;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public String getAsunto() {
        return asunto;
    }

    public Documento getDocumentoReferencia() {
        return documentoReferencia;
    }

    public Fecha getFechaIni() {
        return fechaIni;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public ListaSimpleEnlazada<Seguimiento> getListaSeguimiento() {
        return listaSeguimiento;
    }

    public Pila<Documento> getDocumentosTramites() {
        return documentosTramites;
    }

    public String getEstado() {
        return estado;
    }

    public void setDocumentoReferencia(Documento documentoReferencia) {
        this.documentoReferencia = documentoReferencia;
    }
    
    public void agregarDocumentos(Documento documento){
        this.documentosTramites.apilar(documento);
    }

    public void agregarSeguimiento(Seguimiento seguimiento) {
        this.listaSeguimiento.agregar(seguimiento); 
    }
}
