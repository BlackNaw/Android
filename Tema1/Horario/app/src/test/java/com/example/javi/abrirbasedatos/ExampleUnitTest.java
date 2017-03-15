package com.example.javi.abrirbasedatos;

import com.example.javi.abrirbasedatos.Control.ControlRellenadorAdapter;
import com.example.javi.abrirbasedatos.Modelo.Horario;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        ControlRellenadorAdapter instancia = new ControlRellenadorAdapter();
        Horario horario = new Horario();
        instancia.rellenarHorario("e2a", horario);
        for (int i = 0; i < horario.getCuadrante().length; i++) {
            for (int j = 0; j < horario.getCuadrante()[i].length; j++) {
                System.out.print(horario.get(i, j) + " ");
            }
            System.out.println();
        }
    }
}
