package com.nawtovi.tocarcoordenadas;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    FrameLayout frameLayout;
    TextView txtX, txtY, txtTime;
    float antiguoY = 0, antiguoX = 0, antiguoZ = 0, intervalo = 0;
    int colorY = 1, colorX = 1, colorZ = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtX = (TextView) findViewById(R.id.txtX);
        txtY = (TextView) findViewById(R.id.txtY);
        txtTime = (TextView) findViewById(R.id.txtTime);
        frameLayout = (FrameLayout) findViewById(R.id.layout);
        frameLayout.setOnTouchListener(this);
        colorX = frameLayout.getSolidColor();
        colorY = frameLayout.getSolidColor();
        colorZ = frameLayout.getSolidColor();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int accion = event.getAction();
        if (accion == MotionEvent.ACTION_MOVE) {
            colorY(event);
            colorX(event);
            colorZ(event);
        }
        if (accion == MotionEvent.ACTION_UP)
            intervalo = event.getEventTime() - event.getDownTime() ;
        frameLayout.setBackgroundColor(Color.rgb(colorY, colorX, colorZ));
        colorZ=colorZ==255?0:colorZ;
        txtX.setText(Float.toString(event.getRawX()));
        txtY.setText(Float.toString(event.getRawY()));
        txtTime.setText(Float.toString(intervalo/1000));

        return true;
    }

    private void colorY(MotionEvent event) {

        if (antiguoY >= event.getRawY()) {
            if (colorY < 255) colorY++;
        } else if (colorY > 0) colorY--;
        antiguoY = event.getRawY();
    }

    private void colorX(MotionEvent event) {
        if (antiguoX >= event.getRawX()) {
            if (colorX < 255) colorX++;
        } else if (colorX > 0) colorX--;
        antiguoX = event.getRawX();
    }

    private void colorZ(MotionEvent event) {
        if (antiguoZ >= intervalo) {
            if (colorZ < 255) colorZ++;
        } else if (colorZ > 0) colorZ--;
        antiguoZ=intervalo;
    }
}
