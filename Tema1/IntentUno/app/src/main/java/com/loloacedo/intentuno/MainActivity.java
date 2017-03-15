package com.loloacedo.intentuno;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //El formato de metodo que puede asociarse a xml es public void con un parametro View
    public void lanzar(View view){
        //Se crea el intent
        //Definimos el contexto como this
        //La clase a lanzar
        //Se le pasa la activity actual como contexto y la clase de la activity a lanzar
        Intent intent=new Intent(this,Main2Activity.class);
        //Como crea la instancia
        //Con un metodo de context
        startActivity(intent);
    }
}
