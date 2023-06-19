/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fich.procesos;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class FIFO {

    public static String correr(List<ProcesoFIFO> procesos) {

        int tiempoAnt = 0;
        int tiempoDesp = 0;
        String resultado = "";


        for (ProcesoFIFO proceso : procesos) {
            tiempoDesp += proceso.ejecucion;
            proceso.setTiempoEspera(tiempoAnt);
            proceso.setTiempoServicio(tiempoDesp);
            proceso.setIndiceMedio();
            tiempoAnt += proceso.ejecucion;

            resultado += String.format(
                    "El proceso %s tiene los siguientes datos: Tiempo de servicio = %d, Tiempo de espera = %d, Indice = %.2f",
                    proceso.nombre, proceso.tiempoServicio, proceso.tiempoEspera, proceso.indiceMedio
            );
            resultado += "\n";
        }

        return resultado;
    }
}
