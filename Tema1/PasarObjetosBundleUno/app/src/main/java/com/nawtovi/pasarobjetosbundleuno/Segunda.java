package com.nawtovi.pasarobjetosbundleuno;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.nawtovi.pasarobjetosbundleuno.R.id.txtvNumero;

public class Segunda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Intent intent=getIntent();

        //Recojo el paquete
        Bundle bundle = intent.getExtras();

        //Lo desempaqueto
        Socio socio=bundle.getParcelable("socio");
        TextView numero,nombre;
        numero=(TextView)findViewById(txtvNumero);
        nombre=(TextView)findViewById(R.id.txtvNombre);

        //Lo uso
        numero.setText(Integer.toString(socio.getNumeor()));
        nombre.setText(socio.getNombre());
    }
}
