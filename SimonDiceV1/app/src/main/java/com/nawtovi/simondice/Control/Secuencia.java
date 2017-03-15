package com.nawtovi.simondice.Control;

import com.nawtovi.simondice.Modelo.MyColors;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Yo on 13/11/2016.
 */

public class Secuencia implements IControlSecuencia {

    //Rojo, verde, azul, amarillo
    private final int COLORES[] = {MyColors.RED.getId(), MyColors.GREEN.getId(), MyColors.BLUE.getId(), MyColors.YELLOW.getId()};
    Random random=new Random();

    @Override
    public ArrayList<Integer> crearSecuenciaNueva() {
        ArrayList<Integer> secuenciaBotones = new ArrayList<>();
        secuenciaBotones.add(COLORES[random.nextInt(COLORES.length)]);
        return secuenciaBotones;
    }

    @Override
    public ArrayList<Integer> anadirNotaSecuencia(ArrayList<Integer> secuenciaBotones) {
        secuenciaBotones.add(COLORES[random.nextInt(COLORES.length)]);
        return secuenciaBotones;
    }

}
