package com.nawtovi.primertouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    TextView textView;
    FrameLayout frameLayout;
    int color=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout) findViewById(R.id.activity_main);
        textView=(TextView)findViewById(R.id.textView2);
        frameLayout.setOnTouchListener(this);
    }

    //V es la view que ha desatado el evento y event que es el evento ocurrido
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //REcogemos la accion el e evento
        int accion=event.getAction();
        String letrero="";
        switch(accion){
            case MotionEvent.ACTION_DOWN:letrero="Down";
                break;
            case MotionEvent.ACTION_UP:letrero="Up";
                break;
            case MotionEvent.ACTION_MOVE:letrero="Move";
                break;
            case MotionEvent.ACTION_CANCEL:letrero="Cancel";
                break;
        }
        textView.setText(letrero);
        frameLayout.setBackgroundColor(color++);
        Log.d("acciones",letrero);
        //indica si el evento ha terminado(false no, true si)
        return true;
    }
}
