package com.nawtovi.abrirbbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    ArrayList<String> lista;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        dbHelper = new DBHelper(this, getPackageName(), "Horario");
        dbHelper.open();
        lista = new ArrayList<String>();
        GestorBD gestorBD = new GestorBD(dbHelper.getMyDataBase());
        gestorBD.queryNombreMaterias(lista);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, lista);
        spinner.setAdapter(adaptador);
        Spinner spinnerSQL = (Spinner) findViewById(R.id.spinner2);
        Cursor prueba = consultaNombreGruposCursor(dbHelper.getMyDataBase());
        //De cursor a spinner
        //La consulta siempre debe llevar el id
        SimpleCursorAdapter adpterSQL = new SimpleCursorAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, prueba, new String[]{"nombre"}, new int[]{android.R.id.text1}, 0);

        spinnerSQL.setAdapter(adpterSQL);
        dbHelper.close();
    }

    public static Cursor consultaNombreGruposCursor(SQLiteDatabase miBaseDatos) {
        return miBaseDatos.rawQuery("Select idGrupo as _id, nombre from grupo", null);
    }
}
