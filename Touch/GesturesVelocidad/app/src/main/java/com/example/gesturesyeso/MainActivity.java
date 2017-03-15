package com.example.gesturesyeso;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements GestureDetector.OnDoubleTapListener
{
	ImageView imagen;
	RelativeLayout relative;

	private GestureDetectorCompat mDetector;

	// Called when the activity is first created.
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		relative = (RelativeLayout) findViewById(R.id.layaut);
		imagen = (ImageView) findViewById(R.id.imageView1);
		// Instantiate the gesture detector with the
		// application context and an implementation of
		// GestureDetector.OnGestureListener
//		mDetector = new GestureDetectorCompat(this, new MyGestureListenerAdapter(imagen));
		mDetector = new GestureDetectorCompat(this, new MyCortoGestureListener(imagen));
		// Set the gesture detector as the double tap
		// listener.
		mDetector.setOnDoubleTapListener(this);


	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// Log.d(DEBUG_TAG, "Tocando: " + event.toString());
		this.mDetector.onTouchEvent(event);
		// Be sure to call the superclass implementation
		return super.onTouchEvent(event);
	}


	@Override
	public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent motionEvent) {
		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent motionEvent) {
		return false;
	}
}
