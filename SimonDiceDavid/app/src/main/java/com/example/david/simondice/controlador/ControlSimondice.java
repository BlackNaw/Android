package com.example.david.simondice.controlador;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.david.simondice.modelo.Nivel;
import com.example.david.simondice.modelo.Secuencia;

/**
 * Created by david on 12/11/2016.
 */

public class ControlSimondice extends Thread implements IControlSimondice {

    Handler escribirUIMostrar = new Handler();
    View botones[];
    Secuencia secuencia;
    Nivel nivel;
    public boolean parado = true;

    public ControlSimondice(Secuencia secuencia, View v[], Nivel nivel) {
        this.secuencia = secuencia;
        this.nivel = nivel;
        this.botones = v;
    }

    @Override
    public synchronized void run() {
        while (true) {
            while (!parado) {
                Log.d("hilo", "reproduciendo realmente hilo");
                for (int i = 0; i < secuencia.getSecuencia().length; i++) {
                    for (int j = 0; j < secuencia.getColores().length; j++) {
                        if (secuencia.getSecuencia()[i] == secuencia.getColores()[j]) {
                            final int finalJ = j;
                            final int finalI = i;
                            escribirUI(secuencia.getColoresResaltados()[finalJ], finalJ);
                            pausarHilo(nivel.getPausa());
                            escribirUI(secuencia.getSecuencia()[finalI], finalJ);
                            pausarHilo(50);
                        }
                    }
                }
                parado = true;
            }
        }
    }

    private void escribirUI(final int color, final int finalJ) {
        escribirUIMostrar.post(new Runnable() {
            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    AppCompatActivity appCompatActivity = new AppCompatActivity();
                    botones[finalJ].setBackgroundTintList(botones[finalJ].getResources().getColorStateList(color,null));
                }
                //botones[finalJ].setBackgroundColor(color);
            }
        });
    }

    private void pausarHilo(int pausa) {
        try {
            sleep(pausa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean comprobarPulsacion(int color, Secuencia secuencia, int orden) {
        return secuencia.getSecuencia()[orden] == color;
    }

    @Override
    public boolean comprobarFinSecuenciaUsuario(int orden, Nivel nivel) {
        return nivel.getLongitudSecuencia() == (orden+1);
    }


}
