/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlUsuarios;

import TDA.ListaSimpleEnlazada;

/**
 *
 * @author Leonardo
 */
public class ListaAdministrador {
    private static ListaSimpleEnlazada <Usuario> usuarios = new ListaSimpleEnlazada<>();
    
    public static void Iniciar(){
        Usuario usuario1 = new Usuario("administrador", "20230606");
        usuarios.agregar(usuario1);
        
        System.out.println("Usuario administrador Agregado!");
    }
    
    public static ListaSimpleEnlazada <Usuario> usuarios(){
        return usuarios;
    }
    
    public static void añadirUsuario(Usuario usuario){
        usuarios.agregar(usuario);
    }
}
