package com.example.javi.abrirbasedatos.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javi.abrirbasedatos.Control.ControlAsociador;
import com.example.javi.abrirbasedatos.Control.ControlRellenador;
import com.example.javi.abrirbasedatos.Control.ControlRellenadorAdapter;
import com.example.javi.abrirbasedatos.Modelo.Horario;
import com.example.javi.abrirbasedatos.R;

import static com.example.javi.abrirbasedatos.R.layout.horario;


/**
 * Created by Yo on 18/10/2016.
 */
public class MainActivityDos extends AppCompatActivity {
    Horario horarioRelleno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(horario);

        //Mostramos en pantalla el grupo seleccionado
        TextView txtgrupo=(TextView)findViewById(R.id.textoGrupo);
        txtgrupo.setText(getIntent().getStringExtra("grupo"));

        //Obtenemos los campos del layout
        TextView[][] elementos=new ControlAsociador().asociarComponentes(this);


        //Rellenamos el horario y los TextView usando un MOCK
       //horarioRelleno=new ControlRellenador(new ControlRellenadorAdapterMock()).rellenarCuadrante(elementos,(String)txtgrupo.getText());

        //Rellenamos el horario y los TextView usando el REAL
        horarioRelleno=new ControlRellenador(new ControlRellenadorAdapter(this)).rellenarCuadrante(elementos,(String)txtgrupo.getText());

        //Pongo actionlistener a los textView
        ponerActionListener(elementos);
    }

    private void ponerActionListener(TextView[][] elementos) {
        for (int i = 0; i <elementos.length ; i++) {
            for (int j = 0; j < elementos[i].length; j++) {
                elementos[i][j].setOnClickListener(textos);
            }
        }
    }

    View.OnClickListener textos=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String id=((TextView)v).getResources().getResourceEntryName(Integer.valueOf(v.getId()));
            int i=Integer.valueOf(id.substring(3,4));
            int j=Integer.valueOf(id.substring(4,5));
            Toast.makeText(MainActivityDos.this, horarioRelleno.getAsignaturas(i, j),Toast.LENGTH_SHORT).show();


        }
    };
}
