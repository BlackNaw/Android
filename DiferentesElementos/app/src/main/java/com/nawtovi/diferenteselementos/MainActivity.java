package com.nawtovi.diferenteselementos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    ImageView[]uno=new ImageView[4];
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uno[0]=(ImageView)findViewById(R.id.imageView);
        uno[1]=(ImageView)findViewById(R.id.imageView2);
        uno[2]=(ImageView)findViewById(R.id.imageView3);
        uno[3]=(ImageView)findViewById(R.id.imageView4);

        for (int i = 0; i < uno.length; i++) {
            uno[i].setOnTouchListener(this);
        }
        textView=(TextView)findViewById(R.id.textView);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int bicho=0;
        if(event.getAction()==MotionEvent.ACTION_CANCEL)
            textView.setText("cancelando");
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            for (int i = 0; i < uno.length; i++) {
                if(v.equals(uno[i]))bicho=i+1;
                Log.d("Me llamo ",v.getResources().getResourceEntryName(v.getId()));
            }
            textView.setText((Integer.toString(bicho)));
        }
        return true;
    }
}
