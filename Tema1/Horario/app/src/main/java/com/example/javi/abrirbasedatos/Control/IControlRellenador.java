package com.example.javi.abrirbasedatos.Control;

import android.widget.TextView;

import com.example.javi.abrirbasedatos.Modelo.Horario;

/**
 * Created by YO on 21/10/2016.
 */

public interface IControlRellenador {
    /**
     * Rellena la matriz de textview con los valores de un horario definido por el parametro grupo
     * @param matriz
     * @param grupo
     */
    Horario rellenarCuadrante(TextView[][] matriz, String grupo);
}
