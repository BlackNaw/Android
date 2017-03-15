package com.example.javi.abrirbasedatos.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.javi.abrirbasedatos.Control.GestorBD;
import com.example.javi.abrirbasedatos.Modelo.DBHelper;
import com.example.javi.abrirbasedatos.Modelo.Mensajes;
import com.example.javi.abrirbasedatos.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> lista = new ArrayList<>();
    DBHelper dbHelper;
    Spinner spinner;
    GestorBD gestorBD;
    String consulta;

    Button[] botones = new Button[7];
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Asociamos el spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        //Asociamos los botones
        botones[0] = (Button) findViewById(R.id.button1);
        botones[1] = (Button) findViewById(R.id.button2);
        botones[2] = (Button) findViewById(R.id.button3);
        botones[3] = (Button) findViewById(R.id.button4);
        botones[4] = (Button) findViewById(R.id.button5);
        botones[5] = (Button) findViewById(R.id.button6);
        botones[6] = (Button) findViewById(R.id.button7);

        //Nos conectamos BBDD
        dbHelper = new DBHelper(this, getPackageName(), "Horario");
        dbHelper.open();
        Log.d("prueba",this.toString());
        gestorBD = new GestorBD(dbHelper.getMyDataBase());

        //Cerramos la base de datos
        dbHelper.close();

        //Ponemos los action listener
        for (int i = 0; i < botones.length - 1; i++) {
            botones[i].setOnClickListener(cursos);
        }

        //Ponemos en un intent el valor seleccionado en el spinner
        intent = new Intent(this, MainActivityDos.class);
        botones[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getCount()==0) {
                    new Mensajes(1,getApplicationContext());
                } else {
                    intent.putExtra("grupo", spinner.getSelectedItem().toString());
                    //Lanzamos el segundo activity
                    startActivityForResult(intent, 1);
                }
            }
        });

    }

    //Desarrollamos que ocurre al pinchar en un botón
    View.OnClickListener cursos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Obtenemos el nombre del boton
            Button b = (Button) v;
            String nombre = b.getText().toString();
            Log.d("boton", nombre);
            //Hacemos la consulta
            gestorBD.queryNombreMaterias(lista, nombre);
            //Añadimos la lista al spinner
            spinner.setAdapter(new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, lista));
        }
    };
}
