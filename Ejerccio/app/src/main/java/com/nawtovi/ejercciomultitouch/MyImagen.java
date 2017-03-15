package com.nawtovi.ejercciomultitouch;

import android.view.View;
import android.widget.ImageView;

/**
 * Created by Yo on 22/11/2016.
 */

public class MyImagen {
    ImageView imagen;
    int id;

    public MyImagen(View imagen, int id) {
        this.imagen = (ImageView) imagen;
        this.id = id;
    }

    public ImageView getImagen() {
        return imagen;
    }
    public int getIndex() {
        return id;
    }

}
