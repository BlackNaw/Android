package com.nawtovi.pasandolistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, Receptora.class);
        ArrayList<Integer> lista = new ArrayList<>();
        populateLista(lista);
        /*El intent que va a arrancar la activity lleva consigo los datos*/
        intent.putIntegerArrayListExtra("valores", lista);

        Button boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 1);
                startActivity(intent);

            }
        });
    }

    private void populateLista(ArrayList<Integer> lista) {
        lista.add(0, 0);
        for (int i = 1; i < 10; i++) {
            lista.add((int) (Math.random() * 50 + 1));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
          textView = (TextView) findViewById(R.id.textView2);
            Button button = (Button) findViewById(R.id.button);
            button.setText("Volver a seleccionar");
            textView.setText("El numero selecionado " + data.getExtras().getString("numero"));
        }
    }
}
