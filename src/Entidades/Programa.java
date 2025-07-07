/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import TDA.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Leonardo
 */
public class Programa {
    private static ListaDobleEnlazada<Dependencia> listaDependencias = new ListaDobleEnlazada<>();
    private static Pila<Expediente> pilaExpedientesFinalizados = new Pila<>();
    
    public static void registrarExpediente(int prioridad, Interesado interesado, String asunto, Documento documentoReferencia){
        Expediente nuevoExp = new Expediente(prioridad, interesado, asunto, documentoReferencia);
        Dependencia aux = listaDependencias.getCabeza().getItem();
        switch(prioridad){
            case 1:
                aux.getColaAlta().encolar(nuevoExp);
                break;
            case 2:
                aux.getColaMedia().encolar(nuevoExp);
                break;
            case 3:
                aux.getColaBaja().encolar(nuevoExp);
                break;
        }
    }
    
    public static void actualizaTablaMesaDePartes(DefaultTableModel modeloAlta, DefaultTableModel modeloMedia, DefaultTableModel modeloBaja) {
    Dependencia aux = listaDependencias.getCabeza().getItem();
        actualizarTabla(modeloAlta, aux.getColaAlta());
        actualizarTabla(modeloMedia, aux.getColaMedia());
        actualizarTabla(modeloBaja, aux.getColaBaja());
    }
    
    public static void actualizarTabla(DefaultTableModel modelo, Cola<Expediente> cola){
        Cola<Expediente> tmp = new Cola<>();
        modelo.setRowCount(0);
        
        while(!cola.esVacia()){
            Expediente expediente = cola.desencolar();
            Interesado interesado = expediente.getInteresado();
            Documento documentoref = expediente.getDocumentoReferencia();
            
            modelo.addRow(new Object []{
                expediente.getIdExpediente(),
                expediente.getPrioridad(),
                interesado.getNombres(),
                expediente.getAsunto(),
                (documentoref == null ? "Ninguno" : documentoref.getNombre()),
                (expediente.getListaSeguimiento().esVacia() ? "-" : expediente.getListaSeguimiento().toString()),
                (expediente.getDocumentosTramites().esVacia() ? "-" : expediente.getDocumentosTramites().toString()),
                expediente.getEstado(),
                expediente.getFechaIni().toString(),
                (expediente.getFechaFin() == null ? "-" :expediente.getFechaFin().toString())
            });
            
            tmp.encolar(expediente);
        }
        while(!tmp.esVacia()){
            cola.encolar(tmp.desencolar());
        }
    }
    
    public static void registrarDependencia(String nombre){       
        Dependencia dependencia= new Dependencia(nombre);
        listaDependencias.agregarFinal(dependencia);
    }
    
    public static ListaDobleEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }
    
    public static boolean moverExpediente(String idExpediente, String nombreDependenciaDestino) {
        // 1. Buscar expediente y su dependencia origen
        Object[] busqueda = buscarExpediente(idExpediente);
        if (busqueda == null) return false;
        
        Expediente expediente = (Expediente)busqueda[0];
        Dependencia origen = (Dependencia)busqueda[1];
        String tipoCola = (String)busqueda[2];
        
        // 2. Buscar dependencia destino
        Dependencia destino = buscarDependencia(nombreDependenciaDestino);
        if (destino == null) return false;
        
        // 3. Mover entre colas
        return moverEntreColas(origen, destino, expediente, tipoCola);
    }
    
    private static Object[] buscarExpediente(String id) {
        NodoDoble<Dependencia> nodo = listaDependencias.getCabeza();
        while (nodo != null) {
            Dependencia dep = nodo.getItem();
            
            for (String tipo : new String[]{"ALTA", "MEDIA", "BAJA"}) {
                Expediente exp = buscarEnCola(dep, tipo, id);
                if (exp != null) return new Object[]{exp, dep, tipo};
            }
            nodo = nodo.getSgteNodo();
        }
        return null;
    }
    
    private static Expediente buscarEnCola(Dependencia dep, String tipo, String id) {
        Cola<Expediente> cola = switch(tipo) {
            case "ALTA" -> dep.getColaAlta();
            case "MEDIA" -> dep.getColaMedia();
            case "BAJA" -> dep.getColaBaja();
            default -> null;
        };
        
        if (cola == null) return null;
        
        Cola<Expediente> temp = new Cola<>();
        Expediente encontrado = null;
        
        while (!cola.esVacia()) {
            Expediente exp = cola.desencolar();
            temp.encolar(exp);
            if (String.valueOf(exp.getIdExpediente()).equals(id)) {
                encontrado = exp;
                break;
            }
        }
        
        while (!temp.esVacia()) cola.encolar(temp.desencolar());
        return encontrado;
    }
    
    private static boolean moverEntreColas(Dependencia origen, Dependencia destino, Expediente exp, String tipoCola) {
        try {
            Cola<Expediente> colaOrigen = switch(tipoCola) {
                case "ALTA" -> origen.getColaAlta();
                case "MEDIA" -> origen.getColaMedia();
                case "BAJA" -> origen.getColaBaja();
                default -> null;
            };
            colaOrigen.eliminarExpediente(String.valueOf(exp.getIdExpediente()));
            switch(exp.getPrioridad()) {
                case 1 -> destino.getColaAlta().encolar(exp);
                case 2 -> destino.getColaMedia().encolar(exp);
                case 3 -> destino.getColaBaja().encolar(exp);
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error al mover: " + e.getMessage());
            return false;
        }
    }
    
    public static Dependencia buscarDependencia(String nombre) {
        NodoDoble<Dependencia> actual = listaDependencias.getCabeza();
        while (actual != null) {
            if (actual.getItem().getNombre().equals(nombre)) {
                return actual.getItem();
            }
            actual = actual.getSgteNodo();
        }
        return null;
    }
    
    public static Expediente obtenerExpedienteMasAntiguo() {
    ListaDobleEnlazada<Expediente> listaCabezaColasAltas = new ListaDobleEnlazada<>();

    NodoDoble<Dependencia> actual = listaDependencias.getCabeza();
    while (actual != null) {
        Dependencia dependencia = actual.getItem();
        if (!dependencia.getColaAlta().esVacia()) {  
            listaCabezaColasAltas.agregarFinal(dependencia.getColaAlta().getFrente().getItem());
        }
        actual = actual.getSgteNodo();
    }

    Expediente masAntiguo = null;
    NodoDoble<Expediente> nodoExp = listaCabezaColasAltas.getCabeza();
    while (nodoExp != null) {
        Expediente exp = nodoExp.getItem();
        if (masAntiguo == null || exp.getFechaIni().comparar(masAntiguo.getFechaIni()) < 0) {
            masAntiguo = exp;
        }
        nodoExp = nodoExp.getSgteNodo();
    }

    return masAntiguo;
}

    public static Expediente BuscarExpediente(int id){
        NodoDoble<Dependencia> nodo = listaDependencias.getCabeza();
        
        while(nodo != null){
            Dependencia dependencia = nodo.getItem();
            
            Expediente encontrado  = BuscarCola(dependencia.getColaAlta(), id);
            if(encontrado != null){
                return encontrado;
            }
            encontrado  = BuscarCola(dependencia.getColaMedia(), id);
            if(encontrado != null){
                return encontrado;
            }
            encontrado  = BuscarCola(dependencia.getColaBaja(), id);
            if(encontrado != null){
                return encontrado;
            }

            nodo = nodo.getSgteNodo();
        }
        
        return null;
    }
    
    
    public static Expediente BuscarCola(Cola<Expediente> cola, int id ){
        Cola<Expediente> temp = new Cola<>();
        Expediente encontrado = null;
        
        while(!cola.esVacia()){
            Expediente expediente = cola.desencolar();
            if(expediente.getIdExpediente() == id){
                encontrado = expediente;
            }
            temp.encolar(expediente);
                }
        while(!temp.esVacia()){
            cola.encolar(temp.desencolar());
        }
        
        return encontrado;
    }
            
    
    public static Expediente finalizar(int id, String prioridad){
        NodoDoble<Dependencia> nodo = listaDependencias.getCabeza();
        
        while(nodo != null){
            Dependencia dependencia = nodo.getItem();
            Cola<Expediente> cola = null;
            
            switch(prioridad){
                case "1-Alta":
                    cola = dependencia.getColaAlta();
                    break;
                    
                case "2-Media":
                    cola = dependencia.getColaMedia();
                    break;
                  
                case "3-Baja":
                    cola = dependencia.getColaBaja();
                    break;       
            }
            if(cola != null){
                Expediente eliminado = eliminar(cola, id);
                if(eliminado !=  null){
                    return eliminado;
                }
            }
            
            nodo = nodo.getSgteNodo();
        }
        
        return null;
    }
    
    
    public static Expediente eliminar(Cola<Expediente> cola, int id){
        Cola<Expediente> tmp = new Cola<>();
        Expediente eliminado = null;
        
        while(!cola.esVacia()){
            Expediente exp = cola.desencolar();
            if(eliminado == null && exp.getIdExpediente() == id){
                exp.setFechaFin(Fecha.Exacta());
                exp.setEstado(EstadoTramite.FINALIZADO);
                pilaExpedientesFinalizados.apilar(exp);
                eliminado = exp;
            }else{
                tmp.encolar(exp);
            }
    } 
    while(!tmp.esVacia()){
        cola.encolar(tmp.desencolar());
    }
    return eliminado;
    
}
 
}

  