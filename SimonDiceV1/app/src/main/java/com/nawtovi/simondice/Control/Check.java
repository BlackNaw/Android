package com.nawtovi.simondice.Control;

/**
 * Created by JAVI on 18/11/2016.
 */

public class Check {


    public boolean comprobarSeleccion(int elemento, int comparar) {
        return elemento == comparar;
    }

    public boolean comprobarSecuenciaCompleta(int auxiliar, Nivel level, int longitud) {
        if (auxiliar == longitud) {
            if (auxiliar == level.getLogintud()) {
                level.incrementarNivel();
            }
        }
        return auxiliar == longitud;
    }


}
