package com.adorno.mockitohorariocontrol.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.adorno.mockitohorariocontrol.R;


public class HorarioCuadrante extends AppCompatActivity {

    private TextView[][] elementos;
    private String curso;
    private String grupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.horario);

        final TextView txtGrupo = (TextView) findViewById(R.id.textoGrupo);
        curso = getIntent().getStringExtra("curso");
        grupo = getIntent().getStringExtra("grupo");

        txtGrupo.setText(String.format("%s %s", curso, grupo));

        elementos=new TextView[6][5];
        elementos[0][0]=(TextView)findViewById(R.id.txt00);
        elementos[0][1]=(TextView)findViewById(
                getResources().getIdentifier(String.format("txt%d%d",0,1),"id",getPackageName())
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
