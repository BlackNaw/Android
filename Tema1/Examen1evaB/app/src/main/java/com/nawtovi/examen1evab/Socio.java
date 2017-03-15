package com.nawtovi.examen1evab;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by jose on 01/12/2016.
 */

public class Socio implements Serializable {

    private int numero_Secreto;
    private String nombre;

    public Socio(String nombre) {
        numero_Secreto = new Random().nextInt(nombre.length());
        this.nombre = nombre;
    }



    public int getNumero_Secreto() {
        return numero_Secreto;
    }

    public String getNombre() {
        return nombre;
    }
}
