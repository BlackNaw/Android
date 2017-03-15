package com.nawtovi.pasarobjetosbundleuno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=new Intent(this,Segunda.class);
        Socio socio=new Socio(1,"Jose");
        Bundle bundle=new Bundle();

        //Metemos el socio en el paquete
        bundle.putParcelable("socio",socio);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
