package com.nawtovi.usandobundlebasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView textView=(TextView)findViewById(R.id.textView3);

        Bundle bundle=getIntent().getExtras();
        textView.setText(bundle.getString("apellidos"));
    }
}
