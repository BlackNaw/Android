package com.example.javi.abrirbasedatos.Control;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.example.javi.abrirbasedatos.Modelo.DBHelper;
import com.example.javi.abrirbasedatos.Modelo.Horario;

/**
 * Created by YO on 23/10/2016.
 */

public class ControlRellenadorAdapter extends AppCompatActivity implements IControlRellenadorAdapter {
    DBHelper dbHelper;
    GestorBD gestorBD;
    Activity activity;

    public ControlRellenadorAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void rellenarHorario(String curso, Horario horario) {

        //Nos conectamos BBDD

        dbHelper = new DBHelper(activity.getApplicationContext(), activity.getPackageName(), "Horario");
        dbHelper.open();
        gestorBD = new GestorBD(dbHelper.getMyDataBase());
        String[][] campos = gestorBD.queryTodasMaterias(curso);

        //Cerramos la base de datos
        dbHelper.close();

        //Rellenamos el horario
        int contador = 0;
        for (int i = 0; i < horario.getCuadrante()[0].length; i++) {
            for (int j = 0; j < horario.getCuadrante().length; j++) {
                horario.set(j, i, campos[contador][1]);
                horario.setAsignaturas(j, i, campos[contador][2]);
                if (contador < campos.length - 1) contador++;
                while (campos[contador][0].equals(campos[contador - 1][0])) {
                    horario.set(j, i, campos[contador][1]);
                    horario.setAsignaturas(j, i, campos[contador][2]);
                    contador++;
                }

            }
        }

    }


}
