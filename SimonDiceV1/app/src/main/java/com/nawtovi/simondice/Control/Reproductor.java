package com.nawtovi.simondice.Control;

import com.nawtovi.simondice.Modelo.MyButton;

import java.util.ArrayList;

/**
 * Created by JAVI on 18/11/2016.
 */

public class Reproductor extends Thread {

    private static Boolean hilo=true;
    private MyButton[] buttons;
    private Boolean parado = false;
    private ArrayList<Integer> secuencia;
    private long pausa;

    protected Reproductor(MyButton[] buttons) {
        this.buttons = buttons;
    }

    protected void reproducirSecuencia(ArrayList<Integer> secuencia, long level) {
        this.secuencia = secuencia;
        this.pausa=level;
        this.parado = true;
    }

    @Override
    public void run() {
        while (hilo) {
            if (parado) {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                enableDisableButtons(buttons.length - 1);
                for (int i = 0; i < secuencia.size() && hilo; i++) {
                    buttons[secuencia.get(i)].pressButton();
                    try {
                        sleep(pausa);
                        buttons[secuencia.get(i)].upButton();
                        sleep(pausa);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                enableDisableButtons(buttons.length - 1);
                this.parado = false;
            }
        }

    }

    private void enableDisableButtons(int limit) {
        for (int i = 0; i < limit; i++) {
            buttons[i].enableButton();
        }
    }

    public static void setHilo(Boolean condicion) {
        hilo = condicion;
    }
}
