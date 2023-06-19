/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fich.procesos;

/**
 *
 * @author Usuario
 */
public class ProcesoFIFO extends Proceso {

    public ProcesoFIFO(String nombre, int llegada, int ejecucion) {
        this.nombre = nombre;
        this.llegada = llegada;
        this.ejecucion = ejecucion;
    }

    public void setTiempoServicio(int tiempo) {
        this.tiempoServicio = tiempo - this.llegada;
    }

    public void setTiempoEspera(int tiempo) {
        this.tiempoEspera = tiempo == 0 ? 0 : tiempo - this.llegada;
    }
}
