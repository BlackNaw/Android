package com.example.javi.abrirbasedatos.Modelo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by YO on 23/10/2016.
 */

public class Mensajes {
    public Mensajes(int numero, Context applicationContext) {
        String mensaje;
        switch (numero) {
            case 1: mensaje="SELECCIONE UN GRUPO";
                break;
            default: mensaje="ERROR";
                break;
        }
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show();
    }
}
