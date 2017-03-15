package com.adorno.acelerometrounoclase;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView textview;
    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.textView);
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0)
            builder.append("no hay ningun acelerometro instalado");
        else {
            //Asociamos el acelerometro al objeto Sensor
            Sensor acelerometroUno = manager.getSensorList(
                    Sensor.TYPE_ACCELEROMETER).get(0);
            //Asociar el acelerometro al listener
            if (!manager.registerListener(this, acelerometroUno, SensorManager.SENSOR_DELAY_NORMAL))
                builder.append("no se ha podido registrar el acelerometro");

        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        builder.setLength(0);
        builder.append("x: ");
        builder.append(event.values[0]);
        builder.append(",y: ");
        builder.append(event.values[1]);
        builder.append(",z: ");
        builder.append(event.values[2]);
        builder.append(",acuracy: ");
        builder.append(event.accuracy);
        textview.setText(builder.toString());
        event.accuracy=3;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        textview.setText("cambio de exactitud"+sensor.getName()+Integer.toString(accuracy));
    }
}
