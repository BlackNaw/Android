package com.nawtovi.usandobundlebasico;

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
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("nombre","Altaufo");
        startActivity(intent);
    }

    //usar bundle
    public void colocar(View v){
        /* Un paso intermedio par ano tener que introducir los
        datos uno a uno en el intent es uasr un Bundle*/

        Bundle bundle=new Bundle();
        bundle.putString("apellidos","Jimenez Morquensen");
        Intent intent=new Intent(this,Main3Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
