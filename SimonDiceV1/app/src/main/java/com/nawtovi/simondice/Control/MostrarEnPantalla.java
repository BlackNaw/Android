package com.nawtovi.simondice.Control;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yo on 19/11/2016.
 */

public class MostrarEnPantalla {

    private TextView textViewNivel;
    private TextView textViewPuntos;

    public MostrarEnPantalla(TextView textViewNivel, TextView textViewPuntu) {
        this.textViewNivel = textViewNivel;
        this.textViewPuntos = textViewPuntu;
    }

    public void updateText(String puntos,String nivel){
        textViewPuntos.setText(puntos);
        textViewNivel.setText(nivel);
    }

    public void showToast(Context context,String mostrar){
        Toast.makeText(context, mostrar, Toast.LENGTH_SHORT).show();
    }
}
