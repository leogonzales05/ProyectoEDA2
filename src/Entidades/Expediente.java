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
}
