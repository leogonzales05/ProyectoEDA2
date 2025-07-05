/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import TDA.*;
import javax.swing.JTable;
/**
 *
 * @author Leonardo
 */
public class Programa {
    private static ListaDobleEnlazada<Dependencia> listaDependencias;
    private static Pila<Expediente> pilaExpedientesFinalizados;
    
    public static Expediente registrarExpediente(int prioridad, Interesado interesado, String asunto, Documento documentoReferencia){
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
        }
        return nuevoExp;
    }
    
    public static void registrarDependencia(String nombre){       
        Dependencia dependencia= new Dependencia(nombre);
        listaDependencias.agregarFinal(dependencia);
    }   
    
    /*
    public static String visualizarExpedientes() {
        StringBuilder sb = new StringBuilder("EXPEDIENTES REGISTRADOS:\n");
        NodoDoble<Expediente> actual = Programa.expedientes.getCabeza();
        while (actual != null) {
            Expediente exp = actual.getItem();
            sb.append("ID: ").append(exp.getIdExpediente())
              .append(" | Asunto: ").append(exp.getAsunto())
              .append(" | Prioridad: ").append(exp.getPrioridad())
              .append("\n");
            actual = actual.getSgteNodo();
        }
        return sb.toString();
    }
    */
    
    /*
    public static boolean cambiarExpediente(int idExpediente, Seguimiento cambio) {
        if (cambio == null) {
            return false;
        }

        Expediente exp = BuscarExp(idExpediente);

        if (exp != null && exp.getFechaFin() == null) {

            if (cambio.getDependenciaOrigen().equals(cambio.getDependenciaDestino())) {
                return false;
            }


            exp.agregarSeguimiento(cambio); 
            return true;
        }
        return false;
    }
    */
    
}
