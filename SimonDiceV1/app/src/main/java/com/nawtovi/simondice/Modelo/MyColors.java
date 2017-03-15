package com.nawtovi.simondice.Modelo;

/**
 * Created by JAVI on 17/11/2016.
 */

public enum MyColors {
    RED(0),BLUE(1),GREEN(2),YELLOW(3),CENTER(4);

    private final int id;
       
    private MyColors(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }
}
