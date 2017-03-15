package com.nawtovi.abrirbbdd;

/**
 * Created by Yo on 21/10/2016.
 */

public class Tabla {
    //Los valores de la bbdd
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Horario";

    //----Vamos a crear una inner class por cada tabla
    class TABLA_GRUPO {
        //----Como constrantes de la clase tenemos el nombre
        public static final String NOMBRE = "grupo";
        //---Los campos que llevan el prefijo campo y como sufijo el nombre del campo
//----El valor de todas las constantes coincide con su nombre en la bbdd
        public static final String CAMPO_ID = "IdGrupo";
        public static final String CAMPO_NOMBRE = "nombre";
        public static final String CAMPO_ESTUDIOS = "estudios";
    }


}
