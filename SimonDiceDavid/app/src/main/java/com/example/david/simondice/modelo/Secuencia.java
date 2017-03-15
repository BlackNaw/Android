package com.example.david.simondice.modelo;

import com.example.david.simondice.R;

/**
 * Created by david on 11/11/2016.
 */

public class Secuencia implements IControlSecuencia{

    private int colores[] = {R.color.rojo,R.color.amarillo,R.color.verde,R.color.azul};
    private int coloresResaltados[] = {R.color.rojopulsado,R.color.amarillopulsado,R.color.verdepulsado,R.color.azulpulsado};
    private int secuencia[];

    @Override
    public void crearSecuencia(Nivel nivel) {
        secuencia = new int[nivel.getLongitudSecuencia()];
        annadirNotaSecuencia(0);
    }

    @Override
    public void annadirNotaSecuencia(int posicion) {
        int numero = (int)(Math.random()*(colores.length)+0);
        secuencia[(posicion)] = colores[numero];
    }

    public int[] getSecuencia(){
        return secuencia;
    }

    public int[] getColores(){
        return colores;
    }

    public int[] getColoresResaltados() {
        return coloresResaltados;
    }
}
