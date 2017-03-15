package com.adorno.cproyectos2017tema4clasesensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView texto;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        StringBuilder cadena = new StringBuilder();
//        texto = (TextView) findViewById(R.id.texto);
//
//        //Adquirar una instancia de los servicios de los sensores
//        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        //Si hay acelerometro
//        //preguntamos si hay alguno
//        boolean hasAcelerometer = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0;
//        boolean hasGyroscope = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE).size() > 0;
//
//        if (hasAcelerometer)
//            cadena.append("Tiene acelerometro\n");
//        if (hasGyroscope)
//            cadena.append("Si ");
//        else
//            cadena.append("No ");
//        cadena.append("Gyroscope \n");
//        boolean tienetemperatura = sensorManager.getSensorList(Sensor.TYPE_AMBIENT_TEMPERATURE).size() > 0;
//        if (tienetemperatura)
//            cadena.append("tiene temperatura\n" + Sensor.TYPE_AMBIENT_TEMPERATURE);
//        else
//            cadena.append("no tiene temperatura \n");
//        boolean tienegravedad = sensorManager.getSensorList(Sensor.TYPE_GRAVITY).size() > 0;
//        if (tienegravedad)
//            cadena.append("tiene gravedad\n");
//        else
//            cadena.append("no tiene gravedad \n");
//        boolean tieneluz = sensorManager.getSensorList(Sensor.TYPE_LIGHT).size() > 0;
//        if (tieneluz)
//            cadena.append("tiene luz\n");
//        else
//            cadena.append("no tiene luz \n");
//        boolean tienemagnetico = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD).size() > 0;
//        if (tienemagnetico)
//            cadena.append("tiene magnetico\n");
//        else
//            cadena.append("no tiene magnetico \n");
//        boolean tieneprox = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY).size() > 0;
//        if (tieneprox)
//            cadena.append("tiene proximidad\n");
//        else
//            cadena.append("no tiene proximidad \n");
//        boolean tienehumedad = sensorManager.getSensorList(Sensor.TYPE_RELATIVE_HUMIDITY).size() > 0;
//        if (tienehumedad)
//            cadena.append("tiene humedad\n");
//        else
//            cadena.append("no tiene humedad \n");
//        texto.setText(cadena);
//    }


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        List<Sensor>cosa;
        super.onCreate(savedInstanceState, persistentState);
        texto= (TextView) findViewById(R.id.texto);
        // Aqui solicitamos a android el servicio. En este caso usamos el sensor
        // y creamos un manager asociado al servicio SENSOR_SERVICE, puede haber
        // varios
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //Crea una lista con todos los sensores
        cosa = manager.getSensorList(Sensor.TYPE_ALL);
        Sensor ahora;
        String cadena = "";

        for (int i = 0; i < cosa.size(); i++) {
            //y si usamos toast
            ahora = cosa.get(i);
            //El nombre del sensor
            cadena += ahora.getName();
            cadena += " ";
            //El numero que identifica el sensor
            cadena += ahora.getType();
            cadena += "\n";
        }
        texto.setText(cadena);
    }
}
