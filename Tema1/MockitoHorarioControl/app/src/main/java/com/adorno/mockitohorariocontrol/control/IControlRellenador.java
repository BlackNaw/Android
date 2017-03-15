package com.adorno.mockitohorariocontrol.control;

import android.widget.TextView;

/**
 * Created by jose on 16/10/15.
 */
public interface IControlRellenador {
    /**
     * Rellena la matriz de textview con los valores de un horario definido por el parametro grupo
     * @param matriz
     * @param grupo
     */
    void rellenarCuadrante(TextView[][] matriz, String grupo);
}
