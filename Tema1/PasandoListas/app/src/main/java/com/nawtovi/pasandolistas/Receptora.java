package com.nawtovi.pasandolistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Receptora extends AppCompatActivity {

    Intent datos;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receptora);
        /* Siempre hay un intent asociado a una activity */
        ArrayList<Integer> lista = getIntent().getIntegerArrayListExtra("valores");
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Integer> adaptador = new ArrayAdapter<Integer>(spinner.getContext(),
                android.R.layout.simple_spinner_item, lista);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItemPosition() != 0) {
                    datos = new Intent();
                    datos.putExtra("numero", spinner.getSelectedItem().toString());
                    setResult(RESULT_OK, datos);
                    finish();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
