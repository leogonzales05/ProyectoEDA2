/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlUsuarios;
import Entidades.Expediente;
import Entidades.Programa;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
/**
 *
 * @author Leonardo
 */
public class Temporizador {
    private static Timer timer = new Timer();

    public static void iniciar() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mostrarAlerta();
            }
        }, 0, 60 * 1000);  
    }

    public static void detener() {
        timer.cancel();
        timer = new Timer();  
    }

    private static void mostrarAlerta() {
        Expediente exp = Programa.obtenerExpedienteMasAntiguo();
        if (exp != null) {
            JOptionPane.showMessageDialog(null,
                """
                Expediente m\u00e1s urgente:
                C\u00f3digo: """ + exp.getIdExpediente() + "\n" +
                "Fecha: " + exp.getFechaIni().toString() + "\n" +
                "Asunto: " + exp.getAsunto());
        } else {
            JOptionPane.showMessageDialog(null, "No hay expedientes pendientes en prioridad alta.");
        }
    }
} 

