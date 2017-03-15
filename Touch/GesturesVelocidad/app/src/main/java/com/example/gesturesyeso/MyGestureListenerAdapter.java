package com.example.gesturesyeso;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by jose on 24/11/2016.
 */

public class MyGestureListenerAdapter extends MyGestureListener {
    private static final String DEBUG_TAG = "Gestures";
    private static final int VELOCIDAD = 150;
    ImageView imagen;

    public MyGestureListenerAdapter(ImageView imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
//        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString()
//                + "velocidadX: " + velocityX + " velocidadY" + velocityY);
        Log.d(DEBUG_TAG, "onFling: " + "velocidadX: " + velocityX + " velocidadY" + velocityY);
        if (velocityX < -VELOCIDAD || velocityX > VELOCIDAD || velocityY < -VELOCIDAD
                || velocityY > VELOCIDAD)
            if (imagen.getVisibility() == View.VISIBLE)
                imagen.setVisibility(View.INVISIBLE);
            else
                imagen.setVisibility(View.VISIBLE);
        return true;
    }
}
