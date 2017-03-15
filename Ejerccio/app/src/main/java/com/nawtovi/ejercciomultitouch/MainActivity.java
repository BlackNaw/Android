package com.nawtovi.ejercciomultitouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    MyImagen[] imagenes=new MyImagen[5];
    int[] codigo = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random=new Random();
        for (int i = 0; i < codigo.length; i++) {
            codigo[i] = i;
        }

        imagenes[0] = new MyImagen(findViewById(R.id.imgTop0), codigo[0]);
        imagenes[1] = new MyImagen(findViewById(R.id.imgTopRight1), codigo[1]);
        imagenes[2] = new MyImagen(findViewById(R.id.imgCenter2), codigo[2]);
        imagenes[3] = new MyImagen(findViewById(R.id.imgBot3), codigo[3]);
        imagenes[4] = new MyImagen(findViewById(R.id.imgBotRight4), codigo[4]);

        for (MyImagen imagen : imagenes) {
            imagen.getImagen().setOnTouchListener(this);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int action=event.getAction();
        if(action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_POINTER_DOWN){

            int index= Integer.valueOf(v.getResources().getResourceEntryName(v.getId()).substring(v.getResources().getResourceEntryName(v.getId()).length()-1));
            int imagen=imagenes[index].getIndex();
            int dedo=event.getPointerId(event.getActionIndex());

            System.out.println("DEDO "+dedo);
            System.out.println("IMAGEN "+imagen);

            if(imagen==dedo&&dedo==5){
                Toast.makeText(this,"Secuencia Correcta",Toast.LENGTH_SHORT).show();
            }
            if(imagen!=dedo){
                Toast.makeText(this,"Fallo",Toast.LENGTH_SHORT).show();
            }

        }
        return true;
    }
}
