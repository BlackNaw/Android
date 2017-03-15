package com.nawtovi.examen1evab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boton;
    private Intent intent;
    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button8);
        nombre =(EditText) findViewById(R.id.nombre);
        intent = new Intent(this, Main2Activity.class);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datos=nombre.getText().toString();
                if(datos!=null&datos.length()>0){
                    intent.putExtra("socio", new Socio(datos));
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Nombre no valido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
