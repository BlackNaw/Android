package com.nawtovi.abrirbbdd;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jose on 14/10/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    //Ruta por defecto de las bases de datos en el sistema android
    private static String paquete = "";
    private static String DB_PATH = "";
    private static String DB_NAME = "";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    /**
     * Constructor Toma referencia hacia el contexto de la aplicación que lo
     * invoca para poder acceder a los 'assets' y 'resources' de la aplicación.
     * Crea un objeto DBOpenHelper que nos permitirá controlar la apertura de la
     * base de datos.
     *
     * @param context
     */
    public DBHelper(Context context, String paqueteDatos, String DBName) {
        super(context, DBName, null, 1);
        myContext = context;
        paquete = paqueteDatos;
        DB_NAME = DBName;
        //esta es la ruta que debe tener el archivo en el terminal
        DB_PATH = "/data/data/" + paquete + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Este emétodo es el encargado de abrir la base de datos
     *
     * @throws SQLException
     */
    public void open() throws SQLException {
        //crea las condiciones necesarias para poder abrir la bbdd
        try {
            createDataBase();
        } catch (IOException e) {
            throw new Error("Ha sido imposible crear la Base de Datos");
        }
        //Abrir la base de datos
        myDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READONLY);
    }

    /**
     * Crea una base de datos que será rescrita con nuestro fichero
     */
    private void createDataBase() throws IOException {
        //Existe ya la bbdd?
        if (!checkDataBase()) {
            //LLamamos a este metodo que crea una base de datos vacia en la ruta por deffecto del sistema
            //de nuestra aplicacion que posteriormente sera rescrita
            myDataBase = getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copiando bases de datos");
            }
        }
    }

    /**
     * Copia nuestra base de datos desde la carpeta assets a la recien creada
     * base de datos en la carpeta de sistema, desde donde podremos acceder a ella.
     * Esto se hace con bytestream.
     * */
    private void copyDataBase() throws  IOException{
        //Abrimos el fichero de base de datos como entrada
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        //TODO hay que quitar codigo si la prueba esta bien
        if(myInput==null)
            Log.d("dbhelper","no se encontro el archivo Horario");
        //Ruta a la base de datos vacia recien creada
        String outFileName = DB_PATH + DB_NAME;
        //Abrimos la base de datos vacia como salida
        OutputStream myOutput = new FileOutputStream(outFileName);
        //TODO hay que quitar codigo si la prueba esta bien
        if(myOutput==null)
            Log.d("dbhelper","no se encontro la bbd en el terminal");
        //Transferimos los bytes desde el fichero de entrada al de salida
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        //Liberamos los streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    /**
     * Comprueba si la base de datos existe para evitar copiar siempre el fichero cada vez que se abra la aplicacion.
     *
     * @return true si existe, false si no existe
     */
    private boolean checkDataBase() {
        //Un objeto de bbdd
        SQLiteDatabase checkDB = null;
        String myPath = DB_PATH + DB_NAME;
        //Si lo intento abrir que va a pasar
        try {
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception e) {
           //TODO: no se que hacer
        }
        if (checkDB != null) {
            //si la bbdd ya existe se cierra
            checkDB.close();

            Log.d("dbhelper","se abrio bien, existia ya al hacer el chek");
        }
        else
            Log.d("dbhelper","no existia al hacer el chek");
        //return checkDB != null ? true : false;
        //fuera de bromas
        return checkDB != null;
    }


    public SQLiteDatabase getMyDataBase() {
        return myDataBase;
    }
}
