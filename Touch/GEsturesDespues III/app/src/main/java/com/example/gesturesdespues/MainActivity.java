package com.example.gesturesdespues;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements
		GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

	private static final String DEBUG_TAG = "Gestures";
	//Este detector sirve para poner el ondoubleTaplistener sobre el y el esta asociado
	//a la propia activity y no a un gesto especial
	private GestureDetectorCompat mDetector; // Definitivamente no se pueden
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDetector = new GestureDetectorCompat(this, this);
		mDetector.setOnDoubleTapListener(this);

		textview = (TextView) findViewById(R.id.textView1);
		
		textview.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Ap?ndice de m?todo generado autom?ticamente
				Log.d(DEBUG_TAG, "aqui si llego: " + arg1.toString());
				//Este ontouchevent deberia ser el de la view pero es el de la 
				//activity.y por lo tanto del overrride
				onTouchEvent(arg1);
				//Prueba a ponerla y a quitarla y ver?s como si la quitas nunca
				//llegas a los gestos
				return true;
			}

		});
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.d(DEBUG_TAG, "onTouchEvent: " + event.toString());
		  this.mDetector.onTouchEvent(event);
		// TODO Ap?ndice de m?todo generado autom?ticamente
		return super.onTouchEvent(event);

	}

	@Override
	public boolean onDown(MotionEvent event) {
		Log.d(DEBUG_TAG, "onDown: " + event.toString());
		return true;
	}

	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2,
			float velocityX, float velocityY) {
		Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
		return false;
	}

	@Override
	public void onLongPress(MotionEvent event) {
		Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
//		Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
		return false;
	}

	@Override
	public void onShowPress(MotionEvent event) {
		Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
	}

	@Override
	public boolean onSingleTapUp(MotionEvent event) {
		Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
		return true;
	}

	@Override
	public boolean onDoubleTap(MotionEvent event) {
		Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent event) {
		Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent event) {
		Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
		return true;
	}

}
