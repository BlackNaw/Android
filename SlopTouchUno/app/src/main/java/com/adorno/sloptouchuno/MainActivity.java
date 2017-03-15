package com.adorno.sloptouchuno;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "Velocity";
    private VelocityTracker mVelocityTracker = null;
    StringBuilder builder = new StringBuilder();
    private final int slopTouch=10;
    private final int FactorVelocidad=1000;
    TextView texto;
    float deditoX;
    float deditoY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (TextView) findViewById(R.id.texto);
    }

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
                if (mVelocityTracker == null)
                    mVelocityTracker = VelocityTracker.obtain();
                else
                    //poner a cero el tracker de velocidad
                    mVelocityTracker.clear();
                //añadimos el evento para qu eel tracker lo siga
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                /*
                Cuando quieras determinar la velocidad llama a computeCurrentVelocity(int)
                Cuanto mayor sea el parametro mayor sera el numero de movimiento
                Este parametro viene dado en pixeles por segundo
                 */
                mVelocityTracker.computeCurrentVelocity(FactorVelocidad);
                //Ahora vamos a obtener el calculo de la velocidad
                float speedX = mVelocityTracker.getXVelocity(pointerId);
                float speedY = mVelocityTracker.getYVelocity(pointerId);
                //Si cumple con los intervalos
                if (cumpleIntervalo(speedX, speedY)) {
                    deditoX = event.getX(index);
                    deditoY = event.getY(index);
                } else {
                    deditoX = 0f;
                    deditoY = 0f;
                }
                break;
        }

        updateTextView();

        return true;
    }
    private void updateTextView() {
        builder.setLength(0);
        builder.append("Posicion X: " + deditoX + " pos y: " + deditoY);
        texto.setText(builder.toString());
    }// updateTextView

    private boolean cumpleIntervalo(float speedX, float speedY) {
        return speedX > slopTouch || speedX < -slopTouch || speedY > slopTouch || speedY < -slopTouch;
    }
}
