package com.nawtovi.horariojose.com.example.imagenespasando;

import android.app.Activity;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.example.imagenespasando.R;
import com.nawtovi.horariojose.Asociadores.AsociadorEstudios;
import com.nawtovi.horariojose.Comportamientos.ComportamientoEstudios;

import java.util.Vector;

public class MainActivity extends Activity {
	HorizontalScrollView hori;
	ImageView imagen[];
	Vector <ImageView> estudios;
	boolean Tocado=false;
	int estudio=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AsociadorEstudios asociadorEstudios=new AsociadorEstudios();
        estudios=asociadorEstudios.asociaEstudios(this);   
        ComportamientoEstudios comportamientoEstudios=new ComportamientoEstudios(estudios);
        comportamientoEstudios.conductaEstudios(estudios);
    }   
}
