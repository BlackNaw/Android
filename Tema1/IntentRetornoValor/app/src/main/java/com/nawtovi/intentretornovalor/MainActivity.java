package com.nawtovi.intentretornovalor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.texto);
        //Crear el intent para llamar a la segunda activity
        intent = new Intent(this, Main2Activity.class);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent,1);
            }
        });


    }
    //Un tipo de metodo callback

    //REQUESTcODE : CODIGO DE LA ACTIVITY QUE HA TERMINADO
//    resultCode : codigo descripcion del resultado del intent (RESULT_OK)
    //data es el intent que vuelve de la activity terminada
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(resultCode==RESULT_OK)
                textView.setText(Integer.toString(data.getExtras().getInt("altura")));
    }
}
