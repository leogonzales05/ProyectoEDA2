/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Calendar;

/**
 *
 * @author Leonardo
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int minuto;
    private int segundo;
    
    public Fecha() {
        dia = 1;
        mes = 1;
        anio = 1900;
        hora = 0;
        minuto = 0;
        segundo = 0;
    }

    public Fecha(int dia, int mes, int anio, int hora, int minuto, int segundo) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    public static Fecha Exacta(){
        Calendar calendario = Calendar.getInstance();
        int d = calendario.get(Calendar.DAY_OF_MONTH);
        int m = calendario.get(Calendar.MONTH) + 1;
        int y = calendario.get(Calendar.YEAR);
        int h = calendario.get(Calendar.HOUR_OF_DAY);
        int min = calendario.get(Calendar.MINUTE);
        int seg = calendario.get(Calendar.SECOND);
        
        return new Fecha(d,m,y,h,min,seg);
    }
    
    public int comparar(Fecha otra) {
        if (this.anio != otra.anio) return this.anio - otra.anio;
        if (this.mes != otra.mes) return this.mes - otra.mes;
        if (this.dia != otra.dia) return this.dia - otra.dia;
        if (this.hora != otra.hora) return this.hora - otra.hora;
        if (this.minuto != otra.minuto) return this.minuto - otra.minuto;
        return this.segundo - otra.segundo;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio + " " + hora + ":" + minuto + ":" + segundo;
    }
} 

