package com.loloacedo.usandobundle;

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
    public void llamar(View v){
        Intent intent=new Intent(this,Segunda.class);
        intent.putExtra("nombre","Ataulfo");
        startActivity(intent);
    }
    //Usar Bundle

    public void colocar(View v){
        //Un paso intermedio para no tener que introducir los datos uno a uno en el intent
        //es usar Bundle(Paquete)
        Bundle bundle=new Bundle();
        bundle.putString("apellidos","Jimenez Morgensen");
        Intent intent=new Intent(this,Tercera.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
