package com.adorno.mockitohorariocontrol.mock;

import com.adorno.mockitohorariocontrol.control.IControlRellenadorAdapter;
import com.adorno.mockitohorariocontrol.modelo.Horario;

/**
 * Created by jose on 21/10/2016.
 */

public class ControlrellenadorAdapterMock implements IControlRellenadorAdapter {

    @Override
    public void rellenarHorario(String curso, Horario horario) {
        for (int i = 0; i <horario.getCuadrante().length; i++) {
            for (int j = 0; j < horario.getCuadrante()[i].length; j++) {
                horario.set(j,i,String.format("ab%d%d",j+1,i+1));
            }
        }

    }
}
