package com.adorno.mockitohorariocontrol.control;


import com.adorno.mockitohorariocontrol.modelo.Horario;

/**
 * Created by jose on 16/10/15.
 */

public interface IControlRellenadorAdapter {

    /**
     * Rellena un objeto Horario con los valores que consiga
     */
    void rellenarHorario(String curso, Horario horario);
}
