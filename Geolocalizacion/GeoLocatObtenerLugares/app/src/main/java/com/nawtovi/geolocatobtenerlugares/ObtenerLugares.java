package com.nawtovi.geolocatobtenerlugares;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class ObtenerLugares extends AppCompatActivity {

    private EditText entrada;
    private TextView resultado;
    private Button boton;
    private TextView txtpais;
    private CheckBox chkDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtener_lugares);
        entrada = (EditText) findViewById(R.id.editText);
        resultado = (TextView) findViewById(R.id.txtResultado);
        boton = (Button) findViewById(R.id.button);
        txtpais = (TextView) findViewById(R.id.txtPais);
        chkDireccion = (CheckBox) findViewById(R.id.chkDireccion);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    resultado.setText(encuentraCoordenadas(entrada.getText().toString(), chkDireccion.isChecked()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                txtpais.setText(extraerPais(resultado.getText().toString()));
            }
        });
    }

    private String extraerPais(String text) {
        String marcador = "countryName=";
        boolean contiene = text.contains(marcador);
        if (contiene) {
            int posicionInicial = text.indexOf(marcador);
            int posicionFinal = text.indexOf(",", posicionInicial);
            String resultado = text.substring(posicionInicial + marcador.length(), posicionFinal);
            return resultado;
        }
        return "En el medio del map";
    }

    private String encuentraCoordenadas(String in, boolean direccion) throws IOException {
        String result = "Unable to Geocode - " + in;
        if (!in.isEmpty()) {
            Geocoder geocoder = new Geocoder(this);
            if (direccion) {
                List<Address> direccciones = geocoder.getFromLocationName(in, 1);
                return direccciones.get(0).toString() == null ? "" : direccciones.get(0).toString();
            } else {
                String[] coords = in.split(",");
                if (coords.length == 2) {
                    List<Address> direcciones = geocoder.getFromLocation(Double.parseDouble(coords[0]), Double.parseDouble(coords[1]), 1);
                    result = direcciones.get(0).toString();
                }
            }
        }
        return result;
    }
}
