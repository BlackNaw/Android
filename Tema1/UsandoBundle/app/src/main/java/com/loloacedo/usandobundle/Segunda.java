package com.loloacedo.usandobundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Segunda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.setText(getIntent().getStringExtra("nombre"));
    }
}
