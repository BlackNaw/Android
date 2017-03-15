package com.nawtovi.dosdedoscoordenadas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    StringBuilder builder;
    TextView texto;
    boolean tocando[] = {false, false};
    float posX[] = new float[2];
    float posY[] = new float[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        texto = new TextView(this);
        super.onCreate(savedInstanceState);
        setContentView(texto);
        texto.setTextSize(24);
        builder = new StringBuilder();
        texto.setText("pulsa con dos dedos");
        texto.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int pointerindex, pointerid, action, cuantos;

        //Ya tengo el puntero tocador
        pointerindex = event.getActionIndex();

        //Su identificador historico
        pointerid = event.getPointerId(pointerindex);
        //Accion sin tener en cuenta el culpable de la accion
        action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                tocando[pointerid] = true;
                posX[pointerid] = event.getX(pointerindex);
                posY[pointerid] = event.getY(pointerindex);
                break;
            case MotionEvent.ACTION_MOVE:
                //cuantos dedos tocan actualmente la pantalla
                cuantos=event.getPointerCount();
                for (int i = 0; i <cuantos; i++) {
                    //el que cambia es el index
                    pointerindex=i;
                    pointerid=event.getPointerId(pointerindex);
                    posX[pointerid]=(int) event.getX(pointerindex);
                    posY[pointerid]=(int) event.getY(pointerindex);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                tocando[pointerid]=false;
                posX[pointerid]=(int) event.getX(pointerindex);
                posY[pointerid]=(int) event.getY(pointerindex);
                break;
        }
        actualizarTextView();
        return true;
    }

    private void actualizarTextView() {
        builder.setLength(0);
        //Recorremos el vector de dedos tocando
        for (int i = 0; i < tocando.length; i++) {
            builder.append(i);
            //Solo si el pointer id esta a true segun el vector tocando leeremos su valor
            if (tocando[i]) {
                builder.append("Numero " + i + " ,");
                builder.append(posX[i] + " ," + posY[i] + "\n");
            }
        }
        texto.setText(builder.toString());
    }
}
