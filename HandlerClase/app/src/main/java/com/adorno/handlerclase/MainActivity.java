package com.adorno.handlerclase;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setBackgroundColor(Color.RED);
        CambiadorColores cambiadorColores=new CambiadorColores(button);
        cambiadorColores.start();
    }

}
