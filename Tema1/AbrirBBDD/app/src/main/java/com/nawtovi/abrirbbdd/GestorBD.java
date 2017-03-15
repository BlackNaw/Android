package com.nawtovi.abrirbbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Yo on 14/10/2016.
 */

public class GestorBD {

    //sobre la que hacer las consultas
    private SQLiteDatabase sqLiteDatabase;

    public GestorBD(SQLiteDatabase sqLiteDatabase) throws SQLiteCantOpenDatabaseException {
        this.sqLiteDatabase = sqLiteDatabase;
        if (sqLiteDatabase == null)
            throw new Error("base de datos no abierta");
    }

    public void queryNombreMaterias(ArrayList<String> lista) {
        lista.add(0, "");
        Cursor mCursor = sqLiteDatabase.rawQuery("SELECT distinct nombre from materia", null);
        mCursor.moveToFirst();
        for (int i = 1; i <= mCursor.getCount(); i++) {
            lista.add(i, mCursor.getString(0));
            mCursor.moveToNext();
        }
    }

    //Consulta cruda
    public Cursor leerPorGrupo() {
        Cursor mCursor = sqLiteDatabase.query(true, Tabla.TABLA_GRUPO.NOMBRE, new String[]
                {Tabla.TABLA_GRUPO.CAMPO_ID, Tabla.TABLA_GRUPO.CAMPO_NOMBRE},null,null,null,null,null,null);
        return mCursor;
    }
}
