package com.adorno.gesturesbasicosiclase;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by Yo on 22/11/2016.
 */

public class GestureDetectorCompatAdapter extends GestureDetector.SimpleOnGestureListener {

    private static final String DEBUG_TAG = "Gestures";

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: ");
        return true;
    }
}
