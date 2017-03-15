package com.example.mary.bolitaenmovimiento;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.List;

/**
 * En esta clase vamos a ver como limitar los movimientos
 * de acelerometro y como liberar el registro de listeners
 */
public class MainActivity extends Activity implements SensorEventListener {

    BallPainter ballPainter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Esto sirve para quitar el título (pero debe heredar de Activity)
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Así se pone la aplicación en pantalla completa (si se hereda de Activity tampoco sale el título)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Creo un nuevo SurfaceView
        ballPainter = new BallPainter(this);
        //Y lo asigno
        setContentView(ballPainter);
        //Cambia la orientación de la pantalla a el modo apaisado
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }


    private long last_update = 0, last_movement = 0;
    private float prevX = 0, prevY = 0, prevZ = 0;
    private float curX = 0, curY = 0, curZ = 0;
    private long margin = 2300000;
    private int limit = 1500;
    private float sin_movement = 1.12E-6f;


    //No existen dos instancias del mismo acelerometro por lo tanto un listener
    //registrado de un sensor cualquiera bloquea el acceso al resto de las aplicaciones
    //Se recomienda liberar los listeners si la activity no está en ejecucion


    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (!sensors.isEmpty()) {
            sensorManager.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_FASTEST);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Zona sincronizada, si hay uno no entra otro
        synchronized (this) {
            //Momento del evento actual
            long current_time = event.timestamp;
            //Leemos las posiciones actuales
            curX = event.values[0];
            curY = event.values[1];
            curZ = event.values[2];

            if (prevX == 0 && prevY == 0 && prevZ == 0) {
                last_update = current_time;
                last_movement = current_time;
                prevX = curX;
                prevY = curY;
                prevZ = curZ;
            }
            long time_difference = current_time - last_update;
            if (time_difference > margin) {
                float movement = Math.abs((curX + curY + curZ) - (prevX - prevY - prevZ) / time_difference);
                //Si el cambio fue significativo...
                if (movement > sin_movement && current_time - last_movement >= limit) {
                    //Actualizamos las posiciones de la bola
                    ballPainter.moverCoordenadas(curX, curY);
                    //Y la repintamos para simular el movimiento
                    ballPainter.postInvalidate();
                    last_movement = current_time;
                }
            }
            prevX = curX;
            prevY = curY;
            prevZ = curZ;
            last_update = current_time;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}

