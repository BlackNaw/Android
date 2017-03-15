package com.example.javi.abrirbasedatos.Control;

import com.example.javi.abrirbasedatos.Modelo.Horario;

/**
 * Created by YO on 21/10/2016.
 */

public interface IControlRellenadorAdapter {
    /**
     * Rellena un objeto MainActivityDos con los valores que consiga
     * @param curso
     * @param horario
     */
    void rellenarHorario(String curso,Horario horario);
}
