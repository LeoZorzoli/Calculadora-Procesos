/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fich.procesos;

/**
 *
 * @author Usuario
 */
public class ProcesoRR extends Proceso {

    int tiempoRestante, finalizado;

    public ProcesoRR(char nombre, int llegada, int ejecucion) {
        this.nombre = nombre;
        this.llegada = llegada;
        this.ejecucion = ejecucion;
        this.tiempoRestante = ejecucion;
        this.finalizado = 0;
    }

    public void setTiempoServicio() {
        this.tiempoServicio = this.finalizado - this.llegada;
    }

    public void setTiempoEspera() {
        this.tiempoEspera = this.finalizado - this.llegada - this.ejecucion;
    }

    public void setIndiceMedio() {
        this.indiceMedio = (float) this.ejecucion / this.tiempoServicio;
    }

}
