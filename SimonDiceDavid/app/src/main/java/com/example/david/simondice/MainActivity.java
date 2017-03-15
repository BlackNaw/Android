package com.example.david.simondice;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.david.simondice.controlador.ControlSimondice;
import com.example.david.simondice.modelo.Nivel;
import com.example.david.simondice.modelo.Secuencia;

public class MainActivity extends AppCompatActivity {

    //Clases/Objetos
    ControlSimondice controlSimondice;
    Nivel nivel;
    Secuencia secuencia;

    //Logica
    int totalColoresNivel = 0;
    int pulsacionActual = 0;
    boolean iniciar = true;

    //Vista
    View botones[] = new View[4];
    Button btnIniciar;
    TextView txtInformacion;
    TextView txtNivel;
    TextView txtPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botones[0] = findViewById(R.id.button1);
        botones[1] = findViewById(R.id.button2);
        botones[2] = findViewById(R.id.button3);
        botones[3] = findViewById(R.id.button4);
        txtInformacion = (TextView) findViewById(R.id.textViewInfo);
        txtPuntos = (TextView) findViewById(R.id.txtPuntuacion);
        txtNivel = (TextView) findViewById(R.id.txtNivel);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(botonIniciar);
    }

    View.OnClickListener botonIniciar = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
            if (iniciar) {
                secuencia = new Secuencia();
                nivel = new Nivel(3);
                secuencia.crearSecuencia(nivel);
                controlSimondice = new ControlSimondice(secuencia, botones, nivel);
                controlSimondice.parado = false;
                controlSimondice.start();
                prepararBotones();
                iniciar = false;
                ((Button) v).setText("");
                txtInformacion.setText("");
                txtPuntos.setText("Nivel: 1");
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void prepararBotones() {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setOnTouchListener(botonColores);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                botones[i].setBackgroundTintList( getResources().getColorStateList(secuencia.getColores()[i],null));
            }
            // botones[i].setBackgroundColor(secuencia.getColores()[i]);
        }
    }

    View.OnTouchListener botonColores = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (!iniciar) {
                String pulsado = ((TextView) v).getResources().getResourceEntryName(Integer.parseInt(String.valueOf(v.getId())));
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (controlSimondice.comprobarPulsacion(secuencia.getColores()[(Integer.parseInt(pulsado.substring(pulsado.length() - 1))) - 1], secuencia, pulsacionActual)) {
                        actualizarPuntos();
                        pulsacionActual++;
                        if (pulsacionActual > totalColoresNivel) {
                            if (!controlSimondice.comprobarFinSecuenciaUsuario(totalColoresNivel, nivel)) {
                                reproducirSecuencia();
                            } else {
                                nivel.setPuntos(100);
                                aumentarNivel();
                            }
                            pulsacionActual = 0;
                        }

                    } else {
                        activarReinicio();
                    }
                }
            }
            return true;
        }
    };

    private void actualizarPuntos() {
        nivel.setPuntos(10 * nivel.getNivel());
        txtPuntos.setText("Puntuacion: " + String.valueOf(nivel.getPuntos()));
    }

    private void reproducirSecuencia() {
        totalColoresNivel++;
        secuencia.annadirNotaSecuencia(totalColoresNivel);
        controlSimondice.parado = false;
    }

    private void aumentarNivel() {
        nivel.incrementarNivel();
        txtNivel.setText("Nivel: " + String.valueOf(nivel.getNivel()));
        secuencia.crearSecuencia(nivel);
        totalColoresNivel = 0;
        controlSimondice.parado = false;
    }

    private void activarReinicio() {
        pulsacionActual = 0;
        totalColoresNivel = 0;
        iniciar = true;
        btnIniciar.setText("Reiniciar");
        txtInformacion.setText("OUTH, HAS PERDIDO... DAN DAN DAN DAN! VUELVE A EMPEZAR DE NUEVO");
    }

}
