package com.nawtovi.examen1evab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Yo on 02/12/2016.
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView codigo;
    private Button botones[] = new Button[10];
    private ArrayList<Integer> secuencia = new ArrayList<Integer>();
    private Socio socio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        codigo = (TextView) findViewById(R.id.secreto);

        CuentaAtras cuentaAtras = new CuentaAtras((TextView)findViewById(R.id.cuenta),this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        socio = (Socio) bundle.getSerializable("socio");
        codigo.setText(String.valueOf(socio.getNumero_Secreto()));

        botones[0] = (Button) findViewById(R.id.btn0);
        botones[1] = (Button) findViewById(R.id.btn1);
        botones[2] = (Button) findViewById(R.id.btn2);
        botones[3] = (Button) findViewById(R.id.btn3);
        botones[4] = (Button) findViewById(R.id.btn4);
        botones[5] = (Button) findViewById(R.id.btn5);
        botones[6] = (Button) findViewById(R.id.btn6);
        botones[7] = (Button) findViewById(R.id.btn7);
        botones[8] = (Button) findViewById(R.id.btn8);
        botones[9] = (Button) findViewById(R.id.btn9);

        for (Button boton : botones) {
            boton.setOnClickListener(this);
        }

        cuentaAtras.start();

    }
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        secuencia.add(Integer.parseInt(String.valueOf(b.getText())));
        if (secuencia.size() >= 4) {
            Integer suma = 0;
            for (Integer num : secuencia) {
                suma += num;
            }
            if (suma == socio.getNumero_Secreto()) {
                Toast.makeText(Main2Activity.this, "VICTORIA", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(Main2Activity.this, "PRINGADO", Toast.LENGTH_SHORT).show();
                secuencia.removeAll(secuencia);
            }
        }
    }
}
