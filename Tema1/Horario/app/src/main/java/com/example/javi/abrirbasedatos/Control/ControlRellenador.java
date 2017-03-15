package com.example.javi.abrirbasedatos.Control;

import android.widget.TextView;

import com.example.javi.abrirbasedatos.Modelo.Horario;


/**
 * Created by YO on 21/10/2016.
 */
/*
 *Iintroducir esta clase mediante el constructorr puede entenderse como una inyeccion de dependencias
 */
public class ControlRellenador implements IControlRellenador {

    IControlRellenadorAdapter rellenadorAdapter;

    public ControlRellenador(IControlRellenadorAdapter rellenadorAdapter) {
        this.rellenadorAdapter = rellenadorAdapter;
    }

    @Override
    public Horario rellenarCuadrante(TextView[][]matriz, String grupo) {
        Horario horario=new Horario();
        rellenadorAdapter.rellenarHorario(grupo,horario);
        for (int i = 0; i <horario.getCuadrante().length ; i++) {
            for (int j = 0; j <horario.getCuadrante()[i].length ; j++) {
               matriz[i][j].setText(horario.get(i,j));
            }
        }
        return horario;
    }

}
