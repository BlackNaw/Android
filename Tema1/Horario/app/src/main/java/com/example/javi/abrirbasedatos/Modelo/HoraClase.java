package com.example.javi.abrirbasedatos.Modelo;

import java.util.ArrayList;

/**
 * Created by YO on 21/10/2016.
 */

public class HoraClase {
    private ArrayList<Integer> lista;
    public HoraClase(){
        //Llista con el id de materias en esa hora de clase
        lista=new ArrayList<Integer>();
    }
    public ArrayList<Integer> getLista(){return lista;}
    public void setLista(ArrayList<Integer>lista){this.lista=lista;}
}
