package com.example.david.simondice.modelo;

/**
 * Created by david on 11/11/2016.
 */

public class Nivel implements IControlNivel{

    private int nivel = 1;

    private int longitudSecuencia = 1;

    private static int aumentoxnivel = 2;

    private static int dificultad[] = {900,650,350};

    private int pausa;

    private int puntos = 0;

    public Nivel(int dificultad) {
        assert dificultad < 4 && dificultad > 0;
        pausa = this.dificultad[dificultad-1];
    }

    @Override
    public void incrementarNivel() {
        nivel++;
    }

    public int getLongitudSecuencia(){
        return longitudSecuencia + (nivel*aumentoxnivel);
    }

    public int getPausa(){
        return pausa - (nivel*50);
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }
}
