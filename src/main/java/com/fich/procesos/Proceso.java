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

    char nombre;
    int llegada, ejecucion, tiempoServicio, tiempoEspera;
    float indiceMedio;

    public void setIndiceMedio() {
        this.indiceMedio = (float) this.ejecucion / this.tiempoServicio;
    }

    public void mostrarResultado() {
        System.out.println(String.format(
                "El proceso %s tiene los siguientes datos: Tiempo de servicio = %d, Tiempo de espera = %d, Indice = %.2f",
                this.nombre, this.tiempoServicio, this.tiempoEspera, this.indiceMedio
        ));
    }
}
