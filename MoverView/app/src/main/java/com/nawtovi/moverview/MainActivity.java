package com.nawtovi.moverview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    TextView txtMove,txtX,txtY;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMove=(TextView)findViewById(R.id.txtMove);
        txtX=(TextView)findViewById(R.id.txtX);
        txtY=(TextView)findViewById(R.id.txtY);
        txtMove.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int accion=event.getAction();
        String letrero="";
        switch(accion){
            case MotionEvent.ACTION_DOWN:letrero="Down";
                break;
            case MotionEvent.ACTION_UP:
                v.setX(event.getRawX());
                v.setY(event.getRawY());
                letrero="Up";
                break;
            case MotionEvent.ACTION_MOVE:letrero="Move";
                break;
            case MotionEvent.ACTION_CANCEL:letrero="Cancel";
                break;
        }
        txtMove.setText(letrero);
        txtX.setText(Float.toString(event.getRawX()));
        txtY.setText(Float.toString(event.getRawY()));
        return true;
    }
}
