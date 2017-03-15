package com.nawtovi.ciclovida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declarar en java el textview hecho en xml
    TextView textView;
    StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asociamos la activity java al ui en XML
        setContentView(R.layout.activity_main);
        /*Asociamos el view declarado en java con el definido en xml*/
        textView=(TextView) findViewById(R.id.texito);
        stringBuilder=new StringBuilder("Estamos creando la activity");
        textView.setText(stringBuilder);
    }

    @Override
    protected void onStart() {
        super.onStart();
       /* stringBuilder.append("\n Estamos iniciando la activity");
        textView.setText(stringBuilder);*/
        textView.append("\n Estamos iniciando la activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.append("\n La estamos ejecutando");
    }

    @Override
    protected void onPause() {
        super.onPause();
        textView.append("\n Estamos pausando");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.append("\n Estamos deteniendo");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Como syso en java
        Log.d("destruir","Destruyendo");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textView.append("\n En el Restart");
    }
}
