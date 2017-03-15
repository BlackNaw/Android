package com.example.gesturesnointerfacev;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	/*cuando no necesitamos todos los movimientos de gestures
	 * Si no un subgrupo de ellos usamos la herencia en vez
	 * de la interface. Para ello creamos una nueva clase 
	 * que hereda de una clase de gesturedetector que tiene
	 * forma de clase y no de interface
	 * Esto permite que sobreescribais s?lo algunos m?todos
	 * El resto de los m?todos no sobreescritos tienen el 
	 * return a false de manera que no molestan
	*/
    private GestureDetectorCompat mDetector; 

//    Asociamos a la activcty el detector de gestos
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }

    @Override 
    public boolean onTouchEvent(MotionEvent event){ 
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";
        
        @Override
        public boolean onDown(MotionEvent event) { 
            Log.d(DEBUG_TAG,"onDown: ");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDouble: ");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, 
                float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " );
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(DEBUG_TAG, "onscroll: " );
            return true;
        }
    }
}


