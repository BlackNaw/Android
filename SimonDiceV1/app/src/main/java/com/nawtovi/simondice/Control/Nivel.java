package com.nawtovi.simondice.Control;

/**
 * Created by Yo on 11/11/2016.
 */
public class Nivel implements IControlNivel {

    private int dificult;
    private int logintud;
    private long pause;
    private int points;

    public Nivel(int dificult, int logintud, long pause) {
        this.dificult = dificult;
        this.logintud = logintud;
        this.pause = pause;
        this.points=0;
    }

    public Nivel() {
        this.dificult =1;
        this.logintud=4;
        this.pause =550;
    }

    @Override
    public void incrementarNivel() {
        this.dificult++;
        this.logintud+=4;
        this.pause=(pause>100)?pause-150:pause;
    }



    public void ingreasePoints(){
        this.points+=10;
    }

    public int getDificultad() {
        return dificult;
    }

    public int getLogintud() {
        return logintud;
    }


    public int getPoints() {
        return points;
    }

    public long getPause() {
        return pause;
    }
}
