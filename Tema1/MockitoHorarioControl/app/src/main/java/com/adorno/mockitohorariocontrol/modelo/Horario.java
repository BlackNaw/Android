package com.adorno.mockitohorariocontrol.modelo;

/**
 * Created by jose on 16/10/15.
 */
public class Horario {
    private StringBuilder[][] cuadrante;

    public Horario() {
        cuadrante = new StringBuilder[6][5];
        for (int i = 0; i < cuadrante.length; i++) {
            for (int j = 0; j < cuadrante[i].length; j++) {
                cuadrante[i][j] = new StringBuilder();
            }
        }
    }

    public StringBuilder[][] getCuadrante() {
        return cuadrante;
    }

    /**
     * Obtiene la materia para un dia y una hora
     * @param hora
     * @param dia
     * @return
     */
    public String get(int dia, int hora){
        return cuadrante[hora][dia].toString();
    }

    /**
     * Añade una materia a un dia y hora
     * @param hora
     * @param dia
     * @param materia
     */
    public void set(int dia, int hora, String materia){
        cuadrante[hora][dia].append(materia);
        cuadrante[hora][dia].append('\n');
    }
}
