package com.example.javi.abrirbasedatos.Modelo;

/**
 * Created by YO on 21/10/2016.
 */

public class Tabla {
    //Los valores de la BBDD
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Horario";

    //Vamos a crear una inner class por cada tabla
    //El nombre de la clase lleva el prefijo tabla y de sufijo el nombre de la tabla
    class TABLA_GRUPO{
        //Como constante de la clase tenemos el grupo
        public static final String NOMBRE="grupo";
        //Los campos que llevan el prefijo campo y como sufijo el nombre del campo
        //El valor de todas las constantes coinciden con su nombre en la BBDD
        protected static final String CAMPO_ID="idGrupo";
        protected static final String CAMPO_NOMBRE="nombre";
        protected static final String CAMPO_ESTUDIOS="estudios";
    }

    class TABLA_CONSULTA{
        public static final String NOMBRE="grupo";
        
        protected static final String CAMPO_ID="idGrupo";
        protected static final String CAMPO_NOMBRE="nombre";
        protected static final String CAMPO_ESTUDIOS="estudios";

    }
}
