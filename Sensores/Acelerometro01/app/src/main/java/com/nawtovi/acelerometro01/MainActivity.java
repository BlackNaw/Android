package com.nawtovi.acelerometro01;

import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
//Tenemos en cuenta si los movimientos estan dentro de un intervalo

    private long last_update = 0, last_movement = 0;
    private float prevX = 0, prevY = 0, prevZ = 0;
    private float curX = 0, curY = 0, curZ = 0;
    private long margin = 23000000;
    private int limit = 1500;
    private float min_movement = 1.12E-6f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    //No existen dos intancias dle mismo acelerometro por lo tanto un listener registrado
    // de un sensor cualquiera bloquea el acceso al resto de las palicaciones se recomienda
    // liberar los listener si la activity no esta en ejecucion


    @Override
    protected void onResume() {
        super.onResume();
        SensorManager sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors=sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SensorManager sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        synchronized (this){
            //momento del evento actual
            long current_time=sensorEvent.timestamp;
//            leemos las posiciones actuales

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
