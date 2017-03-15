package com.loloacedo.usandobundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tercera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        TextView textView=(TextView)findViewById(R.id.textView3);
        Bundle bundle=getIntent().getExtras();
        textView.setText(bundle.getString("apellidos"));
    }
}
