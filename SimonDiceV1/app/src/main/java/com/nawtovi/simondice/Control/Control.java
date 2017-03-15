package com.nawtovi.simondice.Control;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.nawtovi.simondice.Modelo.MyButton;
import com.nawtovi.simondice.Modelo.Touch;
import com.nawtovi.simondice.R;

import java.util.ArrayList;

/**
 * Created by JAVI on 18/11/2016.
 */

public class Control implements View.OnTouchListener {

    private Context context;
    private final long[] VIBRACION = {200, 500};
    private final int CENTRAL_BUTTON = 4;
    private MyButton[] buttons;
    private Touch touch;
    private Secuencia instancia = new Secuencia();
    private ArrayList<Integer> secuencia;
    private Check check = new Check();
    private int auxiliar = 0;
    private Nivel level;
    private Reproductor reproductor;
    private Boolean perdido;
    private MostrarEnPantalla pantalla;

    private MediaPlayer logro, lose;


    public Control(Context context, MyButton[] buttons) {
        this.context = context;
        this.buttons = buttons;
        this.touch = new Touch(context);

        for (int i = 0; i < this.buttons.length; i++) {
            this.buttons[i].getImageView().setOnTouchListener(this);
        }

        pantalla = new MostrarEnPantalla((TextView) ((Activity) context).findViewById(R.id.txtNivel),
                (TextView) ((Activity) context).findViewById(R.id.textPuntuacion));

        this.buttons[CENTRAL_BUTTON].enableButton();
        this.reproductor = new Reproductor(buttons);
        this.logro = MediaPlayer.create(context, R.raw.logro);
        this.lose = MediaPlayer.create(context, R.raw.lose);
        startGame();
        reproductor.start();

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!perdido) {
            //Comienza juego
            int accion = event.getAction();
            int elemento;
            //Obtenemos el elemento pulsado
            if ((elemento = touch.wichIsTouching(buttons[CENTRAL_BUTTON], event, v)) >= 0) {
                if (accion == MotionEvent.ACTION_DOWN)
                    botonPulsado(elemento);
                if (accion == MotionEvent.ACTION_UP)
                    buttons[elemento].upButton();
            }
            this.pantalla.updateText(String.valueOf(level.getPoints()), String.valueOf(level.getDificultad()));
        } else
            this.restart();
        return true;
    }

    private void botonPulsado(int elemento) {
        buttons[elemento].pressButton();
        if (check.comprobarSeleccion(elemento, secuencia.get(auxiliar++))) {
            level.ingreasePoints();
            if (check.comprobarSecuenciaCompleta(auxiliar, level, secuencia.size())) {
                secuenciaCorrecta();
            }
        } else {
            endGame();
        }
    }

    private void secuenciaCorrecta() {
        secuencia = instancia.anadirNotaSecuencia(secuencia);
        pantalla.showToast(context, "Correcto");
        reproductor.reproducirSecuencia(secuencia, level.getPause());
        auxiliar = 0;
        logro.start();
        buttons[CENTRAL_BUTTON].vibrate(VIBRACION[0]);
    }

    private void restart() {
        buttons[CENTRAL_BUTTON].playSound();
        for (MyButton button : buttons) {
            button.enableButton();
            button.upButton();
        }
        startGame();
    }

    private void startGame() {
        this.secuencia = instancia.crearSecuenciaNueva();
        this.level = new Nivel();
        reproductor.reproducirSecuencia(secuencia, level.getPause());
        perdido = false;
        this.pantalla.updateText(String.valueOf(level.getPoints()), String.valueOf(level.getDificultad()));
    }

    private void endGame() {
        pantalla.showToast(context, "You Lose!! ");
        lose.start();
        auxiliar = 0;
        buttons[CENTRAL_BUTTON].vibrate(VIBRACION[1]);
        for (MyButton button : buttons) {
            button.enableButton();
            button.upButton();
        }
        perdido = true;
    }
}