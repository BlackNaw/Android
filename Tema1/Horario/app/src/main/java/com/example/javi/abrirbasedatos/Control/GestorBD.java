package com.example.javi.abrirbasedatos.Control;

import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by YO on 14/10/2016.
 */

public class GestorBD {
    //Sobre la que hacer las consultas
    private SQLiteDatabase sqLiteDatabase;

    public GestorBD(SQLiteDatabase sqLiteDatabase) throws SQLiteCantOpenDatabaseException {
        this.sqLiteDatabase = sqLiteDatabase;
        if (sqLiteDatabase == null) {

            throw new Error("Base de datos no abierta");
        }
    }

    //Consulta crudísima
    public void queryNombreMaterias(ArrayList<String> lista, String nombre) {
        lista.removeAll(lista);
        Cursor mCursor = sqLiteDatabase.rawQuery("Select g.nombre from grupo g, estudios e where e.nombre=\"" + nombre + "\" and g.idEstudios=e.idEstudios", null);
        mCursor.moveToFirst();
        for (int i = 0; i < mCursor.getCount(); i++) {
            lista.add(i, mCursor.getString(0));
            mCursor.moveToNext();
        }
    }


    public String[][] queryTodasMaterias(String grupo){
        Cursor cursor= sqLiteDatabase.rawQuery("SELECT horasSemana.descripcion ,materia.nombre , materia.completo" +
                        " FROM materia NATURAL JOIN materiahoraclase NATURAL JOIN horaClase NATURAL JOIN diaClase , grupo , diaSemana , horasSemana" +
                        " WHERE diaClase.idGrupo = grupo.idGrupo AND diaSemana.idDiaSemana = diaClase.idDiaSemana AND horaClase.idHorasSemana = horasSemana.idHorasSemana AND grupo.nombre = '"+grupo+"'",null);
        cursor.moveToFirst();
        String[][] campos = new String[cursor.getCount()][3];
        for (int i = 0; i < cursor.getCount(); i++) {
            for (int j=0;j<3;j++){
                campos[i][j]=cursor.getString(j);
            }
            cursor.moveToNext();
        }
        return campos;
    }

    /*
    //Consulta cocinada
    public Cursor leerPorGrupo() {
        Cursor mCursor = sqLiteDatabase.query(true, Tabla.TABLA_GRUPO.NOMBRE, new String[]
                {Tabla.TABLA_GRUPO.CAMPO_ID, Tabla.TABLA_GRUPO.CAMPO_NOMBRE}, null, null, null, null, null, null);
        return mCursor;
    }
*/
}

