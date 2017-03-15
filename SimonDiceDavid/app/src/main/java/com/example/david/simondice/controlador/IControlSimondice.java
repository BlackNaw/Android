package com.example.david.simondice.controlador;

import com.example.david.simondice.modelo.Nivel;
import com.example.david.simondice.modelo.Secuencia;

/**
 * Created by david on 11/11/2016.
 */

public interface IControlSimondice {
//    void reproducirSecuenciaOriginal(Secuencia secuencia, View v[]);

    boolean comprobarPulsacion(int color, Secuencia secuencia, int orden);

    boolean comprobarFinSecuenciaUsuario(int orden, Nivel nivel);
}
