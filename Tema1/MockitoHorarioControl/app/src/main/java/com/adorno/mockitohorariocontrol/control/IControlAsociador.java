package com.adorno.mockitohorariocontrol.control;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by jose on 16/10/15.
 */
public interface IControlAsociador {

    /**
     * Asocia los elementos de una UI a una matriz de objetos java
     * @param activity
     * @return
     */
    public TextView[][] asociadorView(Activity activity);

}
