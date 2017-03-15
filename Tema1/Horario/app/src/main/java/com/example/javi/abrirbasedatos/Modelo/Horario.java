package com.example.javi.abrirbasedatos.Modelo;

/**
 * Created by YO on 21/10/15.
 */
public class Horario {
    private StringBuilder[][] cuadrante;
    private String grupo;
    private StringBuilder[][] asignaturas;

    public Horario() {
        cuadrante = new StringBuilder[6][5];
        asignaturas=new StringBuilder[6][5];
        for (int i = 0; i < cuadrante.length; i++) {
            for (int j = 0; j < cuadrante[i].length; j++) {
                cuadrante[i][j] = new StringBuilder();
                asignaturas[i][j]=new StringBuilder();
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
    public String get(int hora, int dia){
        return cuadrante[hora][dia].toString();
    }

    /**
     * Añade una materia a un dia y hora
     * @param hora
     * @param dia
     * @param materia
     */
    public void set(int hora, int dia, String materia){
        cuadrante[hora][dia].append(materia);
        cuadrante[hora][dia].append('\n');
    }

    public void setAsignaturas(int hora, int dia, String materia){
        asignaturas[hora][dia].append(materia);
        asignaturas[hora][dia].append('\n');
    }

    public String getAsignaturas(int hora, int dia){
        return asignaturas[hora][dia].toString();
    }


    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
