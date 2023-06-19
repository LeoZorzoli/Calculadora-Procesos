/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fich.procesos;

/**
 *
 * @author Usuario
 */
public class Proceso {

    String nombre;
    int llegada, ejecucion, tiempoServicio, tiempoEspera;
    float indiceMedio;

    public void setIndiceMedio() {
        this.indiceMedio = (float) this.ejecucion / this.tiempoServicio;
    }
}
