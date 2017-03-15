package com.example.javi.abrirbasedatos.Control;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by YO on 23/10/2016.
 */

public class ControlAsociador implements IControlAsociador {
    @Override
    public TextView[][] asociarComponentes(Activity h) {
        TextView[][] textView=new TextView[6][5];
        for (int i = 0; i <textView.length ; i++) {
            for (int j = 0; j <textView[i].length ; j++) {
                textView[i][j]=(TextView)h.findViewById(h.getResources().getIdentifier(String.format("txt%d%d",i,j),"id",h.getPackageName()));
            }
        }
        return textView;
    }
}
