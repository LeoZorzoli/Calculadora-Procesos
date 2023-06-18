/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.fich.procesos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class Procesos {

    public static void main(String[] args) {

        correrFIFO();
        correrRR();
    }

    public static void correrFIFO() {

        int tiempoAnt = 0;
        int tiempoDesp = 0;

        ProcesoFIFO procesoAFifo = new ProcesoFIFO('A', 0, 4);
        ProcesoFIFO procesoBFifo = new ProcesoFIFO('B', 2, 5);
        ProcesoFIFO procesoCFifo = new ProcesoFIFO('C', 3, 1);
        ProcesoFIFO procesoDFifo = new ProcesoFIFO('D', 3, 2);
        ProcesoFIFO procesoEFifo = new ProcesoFIFO('E', 5, 6);

        ProcesoFIFO[] procesosFIFO = {procesoAFifo, procesoBFifo, procesoCFifo, procesoDFifo, procesoEFifo};

        System.out.println("Calculo de proceso utilizando el metodo FIFO");
        for (ProcesoFIFO proceso : procesosFIFO) {
            tiempoDesp += proceso.ejecucion;
            proceso.setTiempoEspera(tiempoAnt);
            proceso.setTiempoServicio(tiempoDesp);
            proceso.setIndiceMedio();
            tiempoAnt += proceso.ejecucion;
            proceso.mostrarResultado();
        }
    }

    public static void correrRR() {
        int quantum = 3;
        Queue<ProcesoRR> cola = new LinkedList<>();
        int tiempo = 0;
        int quantumRestante = 3;
        boolean fin = false;

        ProcesoRR procesoARR = new ProcesoRR('A', 0, 4);
        ProcesoRR procesoBRR = new ProcesoRR('B', 2, 5);
        ProcesoRR procesoCRR = new ProcesoRR('C', 3, 1);
        ProcesoRR procesoDRR = new ProcesoRR('D', 3, 2);
        ProcesoRR procesoERR = new ProcesoRR('E', 5, 6);

        List<ProcesoRR> procesosRR = new ArrayList<>(Arrays.asList(procesoARR, procesoBRR, procesoCRR, procesoDRR, procesoERR));

        do {

            ProcesoRR primerProceso = procesosRR.get(0);
            if (tiempo == primerProceso.llegada) {
                cola.add(primerProceso);
            }

            tiempo++;

            for (ProcesoRR proceso : procesosRR) {
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
            for (ProcesoRR proceso : procesosRR) {
                if (proceso.tiempoRestante > 0) {
                    todosTerminados = false;
                    break;
                }
            }

            if (todosTerminados && cola.isEmpty()) {
                fin = true;
            }
        } while (!fin);

        System.out.println("Calculo de proceso utilizando el metodo Round Robin");
        for (ProcesoRR proceso : procesosRR) {
            proceso.setTiempoServicio();
            proceso.setTiempoEspera();
            proceso.setIndiceMedio();
            proceso.mostrarResultado();
        }
    }
}
