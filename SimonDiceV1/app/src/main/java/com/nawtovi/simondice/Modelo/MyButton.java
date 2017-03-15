package com.nawtovi.simondice.Modelo;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.widget.ImageView;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by JAVI on 17/11/2016.
 */

public class MyButton {

    private MediaPlayer sonido;
    private int id;
    private ImageView imageView;
    private Handler escribirEnUI = new Handler();
    private Vibrator vibra;


    public MyButton(Context context, int resident, MyColors myColors, ImageView imageView) {
        this.sonido = MediaPlayer.create(context, resident);
        this.id = myColors.getId();
        this.imageView = imageView;
        this.vibra = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);

    }

    public int getId() {
        return id;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void enableButton() {
        escribirEnUI.post(new Runnable() {
            @Override
            public void run() {
                imageView.setEnabled(!imageView.isEnabled());
            }
        });
    }

    public void playSound() {
        sonido.setVolume(1.0f, 1.0f);
        sonido.start();

    }

    public synchronized void pressButton() {
        escribirEnUI.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageAlpha(0);
                playSound();
            }
        });
    }

    public synchronized void upButton() {
        escribirEnUI.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageAlpha(255);
            }
        });

    }

    public void vibrate(long time) {
        vibra.vibrate(time);
    }


}
