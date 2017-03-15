package com.adorno.velocidadgestual;

import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;

public class MainActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "Velocity";
    //controlar la velocidad del gesto
    private VelocityTracker mVelocityTracker = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Es para que la activity capture eventoos de toque
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Index es el que mueve
        int index = event.getActionIndex();
        int action = event.getActionMasked();
        //id es el fijo
        int pointerId = event.getPointerId(index);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //recuperar el objeto de la instancia mediante un metodo estatico
                if (mVelocityTracker == null) {
                    mVelocityTracker = VelocityTracker.obtain();
                } else {
                    //poner a cero el tracker de velocidad
                    mVelocityTracker.clear();
                }
                //añadimos el evento para que el tracker lo siga
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                  /*
                Cuando quieras determinar la velocidad llama a computeCurrentVelocity(int)
                Cuanto mayor sea el parametro mayor sera el numero de movimiento (factor de calculo)
                Este parametro viene dado en pixeles por segundo
                 */
                mVelocityTracker.computeCurrentVelocity(100);
                //Ahora vamos a obtener el calculo de la velocidad
                Log.d(DEBUG_TAG, "Velocidad X:" + VelocityTrackerCompat.getXVelocity(mVelocityTracker, pointerId));
                Log.d(DEBUG_TAG, "velocidad instancia x " + mVelocityTracker.getXVelocity(pointerId));
                Log.d(DEBUG_TAG, "Y velocity: " + VelocityTrackerCompat.getYVelocity(mVelocityTracker, pointerId));
                break;

        }

        return true;
    }
}
