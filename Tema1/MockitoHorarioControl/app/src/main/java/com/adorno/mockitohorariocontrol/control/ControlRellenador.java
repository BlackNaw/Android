package com.adorno.mockitohorariocontrol.control;

import android.widget.TextView;

import com.adorno.mockitohorariocontrol.modelo.Horario;

/**
 * Created by jose on 21/10/2016.
 */

/**
 * Introducir esta clase mediante el constructor puede entenderse como una inyeccion de dependencias
 */
public class ControlRellenador implements IControlRellenador {
    IControlRellenadorAdapter rellenadorAdapter;

    public ControlRellenador(IControlRellenadorAdapter rellenadorAdapter) {
        this.rellenadorAdapter = rellenadorAdapter;
    }

    @Override
    public void rellenarCuadrante(TextView[][] matriz, String grupo) {
        Horario horario = new Horario();


    }
}
