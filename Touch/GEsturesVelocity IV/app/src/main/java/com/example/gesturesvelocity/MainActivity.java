package com.example.gesturesvelocity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;

public class MainActivity extends Activity {
	/*
	 * Como consseguir la velocidad de un gesto que no depende de Gestures, si no 
	 * s?lo de los gestos basicos
	 */
	private static final String DEBUG_TAG = "Velocity";

	private VelocityTracker mVelocityTracker = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Ap?ndice de m?todo generado autom?ticamente
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int index = event.getActionIndex();
		int action = event.getActionMasked();
		int pointerId = event.getPointerId(index);

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			if (mVelocityTracker == null) {
				// Recupera un nuevo objeto VelocityTracker para observar la
				// velocidad del movimiento
				mVelocityTracker = VelocityTracker.obtain();
			} else {
				// Pon a cero el tracker de velocidad

				mVelocityTracker.clear();
			}
			// a?adimos el evento nuevo, producido en down
			mVelocityTracker.addMovement(event);
			break;
		case MotionEvent.ACTION_MOVE:
			mVelocityTracker.addMovement(event);
			// cuando quieras determinar la velocidad llama a
			// computeCurrentVelocity(). Cuanto mayor sea el numero del
			// parametro
			// mayor ser? el n?mero del movimiento.
			// Luego llamammos a getXVelocity() y getYVelocity()
			// que nos entregan la velocidad de cada coordenada
			//
			mVelocityTracker.computeCurrentVelocity(1000);
			// La velocidad viene dada en pixels por segundo

			Log.d(DEBUG_TAG,
					"X velocity: "
							+ VelocityTrackerCompat.getXVelocity(
									mVelocityTracker, pointerId));
			Log.d(DEBUG_TAG,
					"Y velocity: "
							+ VelocityTrackerCompat.getYVelocity(
									mVelocityTracker, pointerId));
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			// retorna el objeto VelocityTracker para ser reutilizado
			mVelocityTracker.recycle();
			break;
		}
		return true;
	}
}
