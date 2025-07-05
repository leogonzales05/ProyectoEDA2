/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author Leonardo
 */
public class ValidarCampos {
    public static boolean esDniValido(String dni){
        if (dni == null || dni.length() != 8) {
            return false;
        }
        for (int i = 0; i < dni.length(); i++) {
            if (!Character.isDigit(dni.charAt(i))) {
               return false;
            }
        }
        return true;
    }
    
    public static boolean esTelefonoValido(String telefono){
        if (telefono == null) {
            return false;
        }
        if (telefono.length() < 6 || telefono.length() > 15) {
            return false;
        }
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean esEmailValido(String email){
        if (email == null) {
            return false;
        }
        return (email.contains("@") && email.contains("."));
    }
    
    public static boolean esNoVacio(String texto){
        return texto != null && !texto.trim().isEmpty();
    }
    
    public static boolean esDocumentoVacio(String nombre, String tipo){
        return nombre == null && tipo == null;
    }
}
