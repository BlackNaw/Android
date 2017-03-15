package com.example.javi.abrirbasedatos.Mock;

import com.example.javi.abrirbasedatos.Control.IControlRellenadorAdapter;
import com.example.javi.abrirbasedatos.Modelo.Horario;

/**
 * Created by YO on 21/10/2016.
 */

public class ControlRellenadorAdapterMock implements IControlRellenadorAdapter {

    @Override
    public void rellenarHorario(String curso, Horario horario) {
        for (int i = 0; i < horario.getCuadrante().length; i++) {
            for (int j = 0; j < horario.getCuadrante()[i].length; j++) {
                horario.set(i, j, String.format("ab%d%d", i, j));
                horario.setAsignaturas(i,j,String.format("ab%d%d", i, j));
                if (i==0&&j==0) {
                    horario.set(0,0,"prueba");
                    horario.setAsignaturas(0,0,"prueba");
                }
            }
        }
        horario.setGrupo(curso);
    }
}
