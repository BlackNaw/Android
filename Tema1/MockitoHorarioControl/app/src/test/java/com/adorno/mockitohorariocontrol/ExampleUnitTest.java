package com.adorno.mockitohorariocontrol;

import com.adorno.mockitohorariocontrol.mock.ControlrellenadorAdapterMock;
import com.adorno.mockitohorariocontrol.modelo.Horario;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testHorario() throws Exception {
        Horario horario=new Horario();
        ControlrellenadorAdapterMock mock=new ControlrellenadorAdapterMock();
        mock.rellenarHorario("",horario);
        for (int i = 0; i <horario.getCuadrante().length; i++) {
            for (int j = 0; j < horario.getCuadrante()[i].length; j++) {
                System.out.println(" "+horario.get(j,i));
            }
        }
    }
}