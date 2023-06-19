/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fich.procesos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class RoundRobin {

    public static String correr(List<ProcesoRR> procesos) {
        int quantum = 3;
        Queue<ProcesoRR> cola = new LinkedList<>();
        int tiempo = 0;
        int tiempoMaximo = 0;
        int quantumRestante = 3;
        boolean fin = false;

        for (ProcesoRR proceso : procesos) {
            tiempoMaximo += proceso.ejecucion;
        }

        String resultado = "";

        do {

            ProcesoRR primerProceso = procesos.get(0);
            if (tiempo == primerProceso.llegada) {
                cola.add(primerProceso);
            }

            tiempo++;

            for (ProcesoRR proceso : procesos) {
                if (tiempo == proceso.llegada) {
                    cola.add(proceso);
                }
            }

            ProcesoRR primeroCola = cola.peek();

            if (primeroCola != null) {
                if (primeroCola.tiempoRestante > 0) {
                    primeroCola.tiempoRestante--;
                    quantumRestante--;

                    if (primeroCola.tiempoRestante == 0) {
                        primeroCola.finalizado = tiempo;
                        cola.poll();
                        quantumRestante = quantum;
                    } else if (quantumRestante == 0) {
                        cola.poll();
                        cola.add(primeroCola);
                        quantumRestante = quantum;
                    }
                }
            }

            boolean todosTerminados = true;
            for (ProcesoRR proceso : procesos) {
                if (proceso.tiempoRestante > 0) {
                    todosTerminados = false;
                    break;
                } else if (tiempo > tiempoMaximo){
                    return "No se puede calcular con los datos ingresados";
                }
            }

            if (todosTerminados && cola.isEmpty()) {
                fin = true;
            }
        } while (!fin);

        System.out.println("Calculo de proceso utilizando el metodo Round Robin");
        for (ProcesoRR proceso : procesos) {
            proceso.setTiempoServicio();
            proceso.setTiempoEspera();
            proceso.setIndiceMedio();

            resultado += String.format(
                    "El proceso %s tiene los siguientes datos: Tiempo de servicio = %d, Tiempo de espera = %d, Indice = %.2f",
                    proceso.nombre, proceso.tiempoServicio, proceso.tiempoEspera, proceso.indiceMedio
            );
            resultado += "\n";
        }

        return resultado;
    }
}
