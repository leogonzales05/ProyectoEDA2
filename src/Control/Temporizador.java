/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
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
                Expediente más urgente:
                Código: """ + exp.getIdExpediente() + "\n" +
                "DNI: " + exp.getInteresado().getDni() + "\n" +
                "Nombres: " + exp.getInteresado().getNombres() + "\n" + 
                "Apellidos: " + exp.getInteresado().getApellidos() + "\n" +
                "Seguimiento: " + (exp.getListaSeguimiento().esVacia() ? "No se han registrado movimientos" : exp.getListaSeguimiento().toString()) + "\n" +
                "Documento: " + (exp.getDocumentosTramites().esVacia() ? "No se han registrado documentos" : exp.getDocumentosTramites().toString()) + "\n" +
                "Fecha-Inicio: " + exp.getFechaIni().toString() + "\n" +
                "Asunto: " + exp.getAsunto());
        }
        else {
            JOptionPane.showMessageDialog(null, "No hay expedientes pendientes en prioridad alta.");
        }
    }
} 

