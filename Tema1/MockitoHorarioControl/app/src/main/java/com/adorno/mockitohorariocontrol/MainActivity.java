package com.adorno.mockitohorariocontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.adorno.mockitohorariocontrol.control.ControlRellenador;
import com.adorno.mockitohorariocontrol.control.IControlRellenador;
import com.adorno.mockitohorariocontrol.control.IControlRellenadorAdapter;
import com.adorno.mockitohorariocontrol.mock.ControlrellenadorAdapterMock;

public class MainActivity extends AppCompatActivity {

    TextView[][] matriz;
    //Cuando pasemos a utilizar el control rellenador adapter verdadero
    //solo debemos cambiar la instanciacion en esta línea
    //TODO:Aqui hay un mock
    IControlRellenadorAdapter controlRellenadorAdapter=new ControlrellenadorAdapterMock();
    IControlRellenador controlRellenador=new ControlRellenador(controlRellenadorAdapter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matriz=new TextView[6][5];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=new TextView(this);
            }
        }
        controlRellenador.rellenarCuadrante(matriz,"e1c");
        //TODO: comprobar si se ha rellenado bien el cuadrante
    }
}
