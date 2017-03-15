package com.nawtovi.intentretornovalor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Primero creamos un intent para alojar el dato
        Intent datos=new Intent();
        //Creamos el dato para pasar
        String datoCadena="La cadena que devuelvo, de momento";
        //Metemos el dato en el intent con la clase Uri (necesaria para pasar un String
        datos.setData(Uri.parse(datoCadena));
        int altura=168;
        //Se meten los datos e tipo primitivo d euno a uno y se etiquetan para recuperarlos con esa etiqueta
        datos.putExtra("altura",altura);
        //Ahora pasamos el intent que contine los datos con un metodo que pertenece a la clase ACtivity
        setResult(RESULT_OK,datos);
        //Tenemos que terminar la activity
        finish();
    }
}
