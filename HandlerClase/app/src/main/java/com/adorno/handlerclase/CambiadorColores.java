package com.adorno.handlerclase;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;

/**
 * Created by jose on 11/11/2016.
 */

public class CambiadorColores extends Thread {
    int[] colores = {Color.RED, Color.YELLOW, Color.GRAY, Color.BLUE, Color.DKGRAY, Color.WHITE};
    View v;
    int valor;
    int pause = 250;
    boolean flipper = false;
    Handler escribirEnUI = new Handler();

    public CambiadorColores(View v) {
        this.v = v;
    }

    @Override
    public void run() {
        while (true) {
            escribirEnUI.post(new Runnable() {
                @Override
                public void run() {
                    if (!flipper)
                        valor = (int) (Math.random() * colores.length - 1);
                    else
                        valor = colores.length - 1;
                    flipper = !flipper;
                    v.setBackgroundColor(colores[valor]);
                }

            });
            try {
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
