package com.nawtovi.examen1evab;

import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by Yo on 02/12/2016.
 */

public class CuentaAtras extends Thread {
    private TextView cuenta;
    private int tiempo=4;
    private Handler escribirEnUI = new Handler();
    private Activity closse;

    public CuentaAtras(TextView textView, Activity cerrar){
        this.cuenta = textView;
        this.closse=cerrar;
    }

    @Override
    public void run() {

        while (true){
            try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            escribirEnUI.post(new Runnable() {
                @Override
                public void run() {
                    cuenta.setText(String.valueOf(tiempo));
                    tiempo--;
                }
            });
            if(tiempo==0)closse.finish();
        }
    }

}
